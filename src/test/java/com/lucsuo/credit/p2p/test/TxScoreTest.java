package com.lucsuo.credit.p2p.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lucsuo.credit.p2p.test.entity.AsyncQueryCommunicationVo;
import com.lucsuo.credit.p2p.test.entity.CommunicationScore;
import com.lucsuo.credit.p2p.test.entity.QueryCommunicationInfo;
import com.lucsuo.credit.p2p.test.res.CommunicationResult;
import com.lucsuo.credit.p2p.test.res.CommunicationResultResponse;
import com.lucsuo.credit.p2p.test.service.TXService;
import com.lucsuo.credit.p2p.test.service.impl.TxServiceImpl;
import com.lucsuo.credit.p2p.test.util.AESUtil;

/**
 * 通讯评分测试用例
 * @author wangpeng
 * @version 1.0
 */
public class TxScoreTest {

	// 修改为自己公司的ID
	public static final String ID = "";
	// 修改为自己公司的PrivateKey
	public static final String KEY = "";
	// 日志打印
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	// 调用时间同步接口请求URL
	public static final String URL_TIME_DIFF = "http://servicetest.lcsuo.com:8100/company/get_timeDiff";
	// 通讯信用评分对接请求地址URL
	public static final String URL_GET_QUERY = "http://servicetest.lcsuo.com:8100/company/CommunicationService/get_query";
	// 通信评分结果查询接口URL
	public static final String URL_GET_RESULT = "http://servicetest.lcsuo.com:8100/company/CommunicationService/get_result";
	
	private TXService txService;
	
	// 时间间隔
	private int timeDiff;
	
	@Before
	public void beforeBuild(){
		txService = new TxServiceImpl();
		List<NameValuePair> timeParams = txService.timeParams(KEY, ID);
		timeDiff = txService.get_timeDiff(URL_TIME_DIFF, timeParams);
	}
	
	/**
	 * 通讯信用评分查询接口
	 * @throws Exception
	 */
	@Test
	public void test_Query() throws Exception {
		
		/*************** 初始化查询数据 *************************/
		CommunicationScore communicationScore = new CommunicationScore();
		
		QueryCommunicationInfo queryCommunicationInfo = new QueryCommunicationInfo();
		queryCommunicationInfo.setName("张三");
		queryCommunicationInfo.setTelephone("18916947787");
		queryCommunicationInfo.setIdNumber("220681199408030039");
		List<QueryCommunicationInfo> list = new ArrayList<QueryCommunicationInfo>();
		list.add(queryCommunicationInfo);
		communicationScore.setSubmitTime("2016-05-03");
		communicationScore.setSubmitPerson("甲骨文#01");
		communicationScore.setQueryList(list);
		String data = JSONObject.toJSONString(communicationScore);
		List<NameValuePair> dataParams = txService.dataParams(KEY, ID, timeDiff, data);
		
		/************************ 调用 通讯信用评分结果接口 *************************/
		txService.get_Query(URL_GET_QUERY, dataParams);
	}

	/**
	 * 通讯信用评分结果接口
	 * @throws Exception
	 */
	@Test
	public void test_Result() throws Exception {
		
		/******* 修改为get_Query()方法所返回的批次唯一批次码 *******/
		String batchCode = null;
		
		/************************ 初始化查询数据 *************************/
		AsyncQueryCommunicationVo asyncQueryCommunicationVo = new AsyncQueryCommunicationVo();
		asyncQueryCommunicationVo.setBatchCode(batchCode);
		String data = JSONObject.toJSONString(asyncQueryCommunicationVo);
		List<NameValuePair> dataParams = txService.dataParams(KEY, ID, timeDiff, data);
		
		/************************ 调用 通讯信用评分结果接口 *************************/
		String result = txService.get_Result(URL_GET_RESULT, dataParams);
		CommunicationResultResponse resultResponse = JSON.parseObject(result, CommunicationResultResponse.class);
		String decryptStr = resultResponse.getJsonList(); // 返回的加密字符串
		if (decryptStr == null || decryptStr.length() <= 0)	return;
		
		// 解密字符串, 并且转换为javaBean
		List<CommunicationResult> resultList = JSON.parseArray(new String(AESUtil.decrypt(decryptStr, KEY)), CommunicationResult.class);
		for (CommunicationResult communicationResult : resultList) {
			LOG.debug("结果信息:" + JSON.toJSONString(communicationResult));
		}
	}

}

package com.lucsuo.credit.p2p.test;

import java.util.List;

import org.apache.http.NameValuePair;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.lucsuo.credit.p2p.test.entity.TxpfRequestVo;
import com.lucsuo.credit.p2p.test.service.TXService;
import com.lucsuo.credit.p2p.test.service.impl.TxServiceImpl;

/**
 * 通讯评分测试用例
 * @author wangpeng
 * @version 1.0
 */
public class TxScoreTest {

	// 修改为自己公司的ID
	public static final String ID = "1457494387661";
	// 修改为自己公司的PrivateKey
	public static final String KEY = "xQX4rdx5P2QkRBcE2928acyVQbfvyuFL";
	// 日志打印
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	// 调用时间同步接口请求URL
	public static final String URL_TIME_DIFF = "http://192.168.1.110:8080/credit_manage/company/get_timeDiff";
	// 通讯信用评分对接请求地址URL
	public static final String URL_GET_SCORE = "http://192.168.1.110:8080/credit_manage/company/api/tx/getscore";
	
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
		TxpfRequestVo communicationScore = new TxpfRequestVo();
		communicationScore.setName("张三");
		communicationScore.setTelephone("13321806168");
		communicationScore.setIdNumber("420381199101080024");
		
		String data = JSONObject.toJSONString(communicationScore);
		List<NameValuePair> dataParams = txService.dataParams(KEY, ID, timeDiff, data);
		
		/************************ 调用 通讯信用评分结果接口 *************************/
		String query = txService.getScore(URL_GET_SCORE, dataParams);
		LOG.debug("查询结果:" + query);
	}

	

}

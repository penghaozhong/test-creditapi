package com.lucsuo.credit.p2p.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lucsuo.credit.p2p.test.entity.AsyncQueryCommunicationVo;
import com.lucsuo.credit.p2p.test.entity.CenterScore;
import com.lucsuo.credit.p2p.test.entity.CommunicationScore;
import com.lucsuo.credit.p2p.test.entity.QueryCommunicationInfo;
import com.lucsuo.credit.p2p.test.res.CommunicationResult;
import com.lucsuo.credit.p2p.test.res.CommunicationResultResponse;
import com.lucsuo.credit.p2p.test.service.CreditService;
import com.lucsuo.credit.p2p.test.service.impl.CreditServiceImpl;
import com.lucsuo.credit.p2p.test.util.AESUtil;
/**
 * 
 * @author Sorin
 *
 */
public class CreditServiceTest  {	
	
	private static final Logger LOG = LoggerFactory.getLogger(CreditServiceTest.class);
	
	CreditService service = new CreditServiceImpl();
	
	private String batchCode = "";
	
	/**
	 * 通讯信用评分结果接口
	 * 目前查询进度为最少2小时返回结果, 请在调用<通讯信用评分查询接口>方法2小时后, 调用此方法.
	 * @return
	 */
	@Test
	public void testget_result() {
		AsyncQueryCommunicationVo asyncQueryCommunicationVo = new AsyncQueryCommunicationVo();
		asyncQueryCommunicationVo.setBatchCode(batchCode);
		String jsonString = JSONObject.toJSONString(asyncQueryCommunicationVo);
		String result = service.get_result(jsonString, testGet_timeDiff());

		CommunicationResultResponse resultResponse = JSON.parseObject(result, CommunicationResultResponse.class);

		String decryptStr = resultResponse.getJsonList(); // 返回的加密字符串

		if (decryptStr == null || decryptStr.length() <= 0)
			return;

		// 解密字符串, 并且转换为javaBean
		List<CommunicationResult> resultList = JSON.parseArray(new String(AESUtil.decrypt(decryptStr, CreditServiceImpl.KEY)), CommunicationResult.class);

		for (CommunicationResult communicationResult : resultList) {
			LOG.debug(JSON.toJSONString(communicationResult));
		}
	}
	
	/**
	 * 通讯信用评分查询接口
	 * 注意：每一次testget_query()接口路诚平台都会产生计费，请妥善保管batchCode
	 * @return
	 */
	@Test
	public void testget_query(){
		
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
		String json = JSONObject.toJSONString(communicationScore);
		
		/*************** post查询通讯信用评分 *********************/
		service.get_query(json,testGet_timeDiff());
		
	}
	
	@Test
	public void testget_score() {
		// 装入数据
		CenterScore socore = new CenterScore();
		socore.setTimeStamp(System.currentTimeMillis());
		socore.setCustomerName("李四");
		socore.setIdNumber("210181199310212759");
		socore.setSex("男");
		socore.setDegree("中专");
		socore.setAge(22);
		socore.setWorkTime("2014-12-13");
		socore.setHouse("无房");
		socore.setArea("广东");
		socore.setCityCategory("广州");
		socore.setOrgType("民营企业");
		socore.setSubmitTime("2015-09-01");
		socore.setS3mquery(1);
		socore.setS2yquery(14);
		socore.setFirstLoanOpenMonth("2014-10-30");
		socore.setHistoryLoanCount(1);
		socore.setUnpaidLoanCount(0);
		socore.setUnpaidLoanCreditLimit(0);
		socore.setUnpaidLoanBlance(0);
		socore.setFirstCreditCardOpenTime("2013-03-28");
		socore.setQueryTimesIn6MonthForCreditCard(5);
		socore.setQueryTimesIn2YearForCreditCard(6);
		socore.setCreditCardCountOpenIn6Month(1);
		socore.setCreditCardCountOpenIn2Year(0);
		socore.setCreditCardTotalLimit(83500);
		socore.setCreditCardUsedLimit(0);
		socore.setMaxCreditLimit(77500);
		socore.setCreditCardRecordCount(2);
		socore.setCreditCardCNYCount(2);
		socore.setCityCategory("北京");
		socore.setWorkTime("2014-01-01");
		socore.setCityCategory("北京");
		socore.setWorkTime("2014-01-01");
		String json = JSONObject.toJSONString(socore);
		// AES加密
		byte[] aes1 = AESUtil.encrypt(json, CreditServiceImpl.KEY);
		String data = Base64.encodeBase64URLSafeString(aes1);
		int timeDiff = testGet_timeDiff();
		LOG.debug(service.get_score(data,timeDiff)+"");
		
	}
	
	public int testGet_timeDiff() {
		return service.get_timeDiff(CreditServiceImpl.ID);
	}

}

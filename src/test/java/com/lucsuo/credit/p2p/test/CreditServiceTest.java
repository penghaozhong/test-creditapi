package com.lucsuo.credit.p2p.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSONObject;
import com.lucsuo.credit.p2p.test.entity.AsyncQueryCommunicationVo;
import com.lucsuo.credit.p2p.test.entity.CenterScore;
import com.lucsuo.credit.p2p.test.entity.CommunicationScore;
import com.lucsuo.credit.p2p.test.entity.QueryCommunicationInfo;
import com.lucsuo.credit.p2p.test.service.CreditService;
import com.lucsuo.credit.p2p.test.service.impl.CreditServiceImpl;
import com.lucsuo.credit.p2p.test.util.AESUtil;

import junit.framework.TestCase;

public class CreditServiceTest extends TestCase {

	/**
	 * 央信评分接口对接示例
	 */
	public static void testGetCenterScore() {
		// 装入数据
		CenterScore socore = new CenterScore();
		socore.setTimeStamp(System.currentTimeMillis());
		// 测试模型4
		socore.setCustomerName("高文雷");
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
		
		
		
		String json = JSONObject.toJSONString(socore);
		System.out.println(json);
		// AES加密
		byte[] aes1 = AESUtil.encrypt(json, CreditServiceImpl.KEY);
		System.out.println(new String(aes1));
		String  data =  Base64.encodeBase64URLSafeString(aes1);
		
		System.out.println(new String (AESUtil.decrypt(data, CreditServiceImpl.KEY)));
		CreditService service = new CreditServiceImpl();
		System.out.println(service.getCenterScore(data));
		
	}
	
	/**
	 * 通讯信用评分对接示例
	 */
	public static void testComScore(){
		CreditService service = new CreditServiceImpl();
		//调用时间同步接口
		int comScoreTime = service.getComScoreTime();
		
		CommunicationScore communicationScore = new CommunicationScore();
		QueryCommunicationInfo queryCommunicationInfo = new QueryCommunicationInfo();
		queryCommunicationInfo.setName("张三");
		queryCommunicationInfo.setTelephone("13310006092");
		queryCommunicationInfo.setIdNumber("522725198003025752");
		List<QueryCommunicationInfo> list = new ArrayList<QueryCommunicationInfo>();
		list.add(queryCommunicationInfo);
		communicationScore.setSubmitTime("2015-01-01");
		communicationScore.setSubmitPerson("测试二#01");
		communicationScore.setQueryList(list);
		String json = JSONObject.toJSONString(communicationScore);
		
		//post查询通讯信用评分
		String comScore = service.getComScore(comScoreTime,json);
		AsyncQueryCommunicationVo asyncQueryCommunicationVo = new AsyncQueryCommunicationVo();
		asyncQueryCommunicationVo.setBatchCode(comScore);
		String jsonString = JSONObject.toJSONString(asyncQueryCommunicationVo);
		
		//根据查询返回的batchCode,获取评分
		String comScore2 = service.getComScore(jsonString,comScoreTime);
		System.out.println("====>"+comScore2);
	}
	
}

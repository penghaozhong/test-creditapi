package com.lucsuo.credit.p2p.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

<<<<<<< HEAD
	/**
	 * 央信评分接口对接示例
	 */
	public static void testGetCenterScore() {
=======
	 private static final Logger LOG = LoggerFactory.getLogger(CreditServiceTest.class);
	
	public void testGetCenterScore() {
>>>>>>> branch 'master' of https://github.com/penghaozhong/test-creditapi.git
		// 装入数据
		CenterScore socore = new CenterScore();
		socore.setTimeStamp(System.currentTimeMillis());
<<<<<<< HEAD
		// 测试模型4
		socore.setCustomerName("高文雷");
		socore.setIdNumber("210181199310212759");
=======
		socore.setCustomerName("李四");
>>>>>>> branch 'master' of https://github.com/penghaozhong/test-creditapi.git
		socore.setSex("男");
		socore.setDegree("中专");
		socore.setAge(22);
		socore.setWorkTime("2014-12-13");
		socore.setHouse("无房");
		socore.setArea("广东");
		socore.setCityCategory("广州");
		socore.setOrgType("民营企业");
<<<<<<< HEAD
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
		
		
		
=======
		socore.setCityCategory("北京");
		socore.setWorkTime("2014-01-01");
		// 校验
		socore.setIdNumber("310102196911215239");
		socore.setAge(12);
>>>>>>> branch 'master' of https://github.com/penghaozhong/test-creditapi.git
		String json = JSONObject.toJSONString(socore);
		// AES加密
		byte[] aes1 = AESUtil.encrypt(json, CreditServiceImpl.KEY);
		String  data =  Base64.encodeBase64URLSafeString(aes1);
		CreditService service = new CreditServiceImpl();
		LOG.debug(service.getCenterScore(data)+"");
		
	}
	
	public void testGet_timeDiff() {
		CreditService service = new CreditServiceImpl();
		LOG.debug(service.get_timeDiff(CreditServiceImpl.ID)+"");
		
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

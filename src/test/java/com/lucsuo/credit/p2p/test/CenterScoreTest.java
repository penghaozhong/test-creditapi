package com.lucsuo.credit.p2p.test;

import java.util.List;

import org.apache.http.NameValuePair;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.lucsuo.credit.p2p.test.entity.CenterScore;
import com.lucsuo.credit.p2p.test.service.CTScoreService;
import com.lucsuo.credit.p2p.test.service.impl.CTScoreServiceImpl;

/**
 * 央信评分测试用例 
 * @author wangpeng
 * @version 1.0
 */
public class CenterScoreTest {

	// 修改为自己公司的ID
	public static final String ID = "";
	// 修改为自己公司的PrivateKey
	public static final String KEY = "";
	// 调用时间同步接口请求URL
	public static final String URL_TIME_DIFF = "";
	// 央信评分接口对接请求地址URL
	public static final String CENTER_SCORE_URL = "";
	
	private CTScoreService ctService;
	
	// 时间间隔
	private int timeDiff;
	
	@Before
	public void beforeBuild(){
		ctService = new CTScoreServiceImpl();
		List<NameValuePair> timeParams = ctService.timeParams(KEY, ID);
		timeDiff = ctService.get_timeDiff(URL_TIME_DIFF, timeParams);
	}
	
	@Test
	public void test_Score() throws Exception {
		
		/*************** 初始化查询数据 *************************/
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
		
		String data = JSONObject.toJSONString(socore);
		List<NameValuePair> dataParams = ctService.dataParams(KEY, ID, timeDiff, data);
		
		/************************ 调用 央信评分查询接口 *************************/
		ctService.get_Score(CENTER_SCORE_URL, dataParams);
	}
}

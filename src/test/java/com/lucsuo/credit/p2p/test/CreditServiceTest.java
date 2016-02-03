package com.lucsuo.credit.p2p.test;

import junit.framework.TestCase;

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
/**
 * 
 * @author lcsuo
 *
 */
public class CreditServiceTest extends TestCase {	
	private static final Logger LOG = LoggerFactory.getLogger(CreditServiceTest.class);

	public void testget_score() {
		// 装入数据
		CenterScore socore = new CenterScore();
		socore.setTimeStamp(System.currentTimeMillis());
		// 测试模型4
		socore.setCustomerName("高文雷");
		socore.setIdNumber("210181199310212759");
		socore.setCustomerName("李四");
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
		// 校验
		socore.setIdNumber("310102196911215239");
		socore.setAge(12);
		String json = JSONObject.toJSONString(socore);
		// AES加密
		byte[] aes1 = AESUtil.encrypt(json, CreditServiceImpl.KEY);
		String data = Base64.encodeBase64URLSafeString(aes1);
		CreditService service = new CreditServiceImpl();
		int timeDiff = testGet_timeDiff();
		LOG.debug(service.get_score(data,timeDiff)+"");
		
	}
	
	public int testGet_timeDiff() {
		CreditService service = new CreditServiceImpl();
		//LOG.debug(service.get_timeDiff(CreditServiceImpl.ID)+"");
		return service.get_timeDiff(CreditServiceImpl.ID);
	}

}

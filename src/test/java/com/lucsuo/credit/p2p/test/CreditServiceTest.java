package com.lucsuo.credit.p2p.test;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.lucsuo.credit.p2p.test.entity.CenterScore;
import com.lucsuo.credit.p2p.test.service.CreditService;
import com.lucsuo.credit.p2p.test.service.impl.CreditServiceImpl;
import com.lucsuo.credit.p2p.test.util.AESUtil;


import junit.framework.TestCase;

public class CreditServiceTest extends TestCase {

	 private static final Logger LOG = LoggerFactory.getLogger(CreditServiceTest.class);
	
	public void testGetCenterScore() {
		// 装入数据
		CenterScore socore = new CenterScore();
		socore.setTimeStamp(System.currentTimeMillis());
		socore.setCustomerName("李四");
		socore.setSex("男");
		socore.setHouse("有房有贷款");
		socore.setOrgType("民营企业");
		socore.setCityCategory("北京");
		socore.setWorkTime("2014-01-01");
		// 校验
		socore.setIdNumber("310102196911215239");
		socore.setAge(12);
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

}

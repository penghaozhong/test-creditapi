package com.lucsuo.credit.p2p.test;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSONObject;
import com.lucsuo.credit.p2p.test.entity.CenterScore;
import com.lucsuo.credit.p2p.test.service.CreditService;
import com.lucsuo.credit.p2p.test.service.impl.CreditServiceImpl;
import com.lucsuo.credit.p2p.test.util.AESUtil;

import junit.framework.TestCase;

public class CreditServiceTest extends TestCase {

	public void testGetCenterScore() {
		// 装入数据
		CenterScore socore = new CenterScore();
		socore.setTimeStamp(System.currentTimeMillis());
		// 测试模型4
		socore.setCustomerName("张晓敏");
		socore.setSex("男");
		socore.setHouse("有房有贷款");
		socore.setOrgType("民营企业");
		socore.setCityCategory("北京");
		socore.setWorkTime("2012-01-01");
		
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

}

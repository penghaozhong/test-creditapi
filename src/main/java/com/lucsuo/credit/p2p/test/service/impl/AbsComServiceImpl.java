package com.lucsuo.credit.p2p.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lucsuo.credit.p2p.test.net.HttpClientFactory;
import com.lucsuo.credit.p2p.test.service.ComService;
import com.lucsuo.credit.p2p.test.util.AESUtil;

/**
 * 抽象类, 默认公共实现<br>
 * 时间间隔接口实现<br>
 * 时间参数封装接口实现<br>
 * post参数封装接口实现<br>
 * @author wangpeng
 * @version 1.0
 */
public abstract class AbsComServiceImpl implements ComService {
	
	protected final Logger LOG = LoggerFactory.getLogger(getClass());
	
	public List<NameValuePair> timeParams(String key, String id) {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("id", id));
		// Base64 ( AES ( timeStamp=System.currentTimeMillis()&timeDiff=0 )
		String paramString = "timeStamp=" + System.currentTimeMillis() + "&id=" + id;
		nvps.add(new BasicNameValuePair("param", Base64.encodeBase64URLSafeString(AESUtil.encrypt("timeStamp=" + System.currentTimeMillis(), key))));
		// sha1(参数串)
		nvps.add(new BasicNameValuePair("signature", DigestUtils.sha1Hex(Base64.encodeBase64URLSafeString(AESUtil.encrypt(paramString, key)))));
		return nvps;
	}
	
	public int get_timeDiff(String url, List<NameValuePair> nvps) {
		HttpClientFactory clientFactory = HttpClientFactory.createInstance();
		String response = clientFactory.post(url, nvps);
		LOG.debug("时间同步接口:" + response); // 打印返回结果
		JSONObject parseObject = JSON.parseObject(response);
		return parseObject.getIntValue("timeDiff");
	}

	public List<NameValuePair> dataParams(String key, String id, int timeDiff, String data) {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("id", id));
		// Base64 ( AES ( timeStamp=System.currentTimeMillis()&timeDiff=0 )
		String paramString = "timeStamp=" + System.currentTimeMillis() + "&timeDiff=" + timeDiff;
		nvps.add(new BasicNameValuePair("param", Base64.encodeBase64URLSafeString(AESUtil.encrypt(paramString, key))));
		// sha1(参数串)
		StringBuilder sh1 = new StringBuilder(paramString).append("&id=").append(id);
		nvps.add(new BasicNameValuePair("signature", DigestUtils.sha1Hex(Base64.encodeBase64URLSafeString(AESUtil.encrypt(sh1.toString(), key)))));
		nvps.add(new BasicNameValuePair("data",	Base64.encodeBase64URLSafeString(AESUtil.encrypt(data, key)).toString()));
		return nvps;
	}
}

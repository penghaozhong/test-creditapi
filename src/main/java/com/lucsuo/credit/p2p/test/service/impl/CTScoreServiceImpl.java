package com.lucsuo.credit.p2p.test.service.impl;

import java.util.List;

import org.apache.http.NameValuePair;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lucsuo.credit.p2p.test.net.HttpClientFactory;
import com.lucsuo.credit.p2p.test.service.CTScoreService;

/**
 * 央信评分接口实现
 * @author wangpeng
 * @version 1.0
 */
public class CTScoreServiceImpl extends AbsComServiceImpl implements CTScoreService {

	public float get_Score(String url, List<NameValuePair> nvps) {
		HttpClientFactory clientFactory = HttpClientFactory.createInstance();
		String response = clientFactory.post(url, nvps);
		LOG.debug("央信评分接口:" + response); // 打印返回结果
		JSONObject parseObject = JSON.parseObject(response);
		return parseObject.getFloatValue("queryScore");
	}

}

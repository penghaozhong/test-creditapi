package com.lucsuo.credit.p2p.test.service.impl;

import java.util.List;

import org.apache.http.NameValuePair;

import com.lucsuo.credit.p2p.test.net.HttpClientFactory;
import com.lucsuo.credit.p2p.test.service.TXService;

/**
 * 通讯评分接口实现
 * @author wangpeng
 * @version 1.0
 */
public class TxServiceImpl extends AbsComServiceImpl implements TXService {

	public String get_Query(String url, List<NameValuePair> nvps) {
		HttpClientFactory clientFactory = HttpClientFactory.createInstance();
		String response = clientFactory.post(url, nvps);
		return response;
	}

	public String get_Result(String url, List<NameValuePair> nvps) {
		HttpClientFactory clientFactory = HttpClientFactory.createInstance();
		String response = clientFactory.post(url, nvps);
		LOG.debug("通讯信用评分结果接口:" + response); // 打印返回结果
		return response;
	}

}

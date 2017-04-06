package com.lucsuo.credit.p2p.test.service;

import java.util.List;

import org.apache.http.NameValuePair;

/**
 * 通讯评分接口
 * @author wangpeng
 * @version 1.0
 */
public interface TXService extends ComService {

	/**
	 * 通讯信用评分, 发送查询接口
	 * @param url 请求地址
	 * @param nvps 参数
	 * @return
	 */
	public String getScore(String url, List<NameValuePair> nvps);

	

}

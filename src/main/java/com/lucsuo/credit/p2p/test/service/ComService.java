package com.lucsuo.credit.p2p.test.service;

import java.util.List;

import org.apache.http.NameValuePair;

/**
 * 公共接口操作
 * @author wangpeng
 * @version 1.0
 */
public interface ComService {
	
	/**
	 * 封装请求参数
	 * @param key 密钥
	 * @param id 公司id
	 * @param timeDiff 时间间隔
	 * @param data json序列化字符串
	 * @return
	 */
	public List<NameValuePair> dataParams(String key, String id, int timeDiff, String data);
	
	/**
	 * 时间间隔接口, 封装参数
	 * @param key 密钥
	 * @param id 公司id
	 * @return
	 */
	public List<NameValuePair> timeParams(String key, String id);
	
	/**
	 * 时间间隔接口
	 * @param url 接口地址
	 * @param nvps 参数
	 * @return
	 */
	public int get_timeDiff(String url, List<NameValuePair> nvps);
}

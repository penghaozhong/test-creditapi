package com.lucsuo.credit.p2p.test.service;

import java.util.List;

import org.apache.http.NameValuePair;

/**
 * 央信评分调用接口
 * @author wangpeng
 * @version 1.0
 */
public interface CTScoreService extends ComService {
	
	/**
	 * 央信评分查询接口
	 * @param url 请求地址
	 * @param nvps 参数
	 * @return
	 */
	public float get_Score(String url, List<NameValuePair> nvps);
}

package com.lucsuo.credit.p2p.test.service;


/**
 * @author Sorin
 *
 */

public interface CreditService {
	
	/**
	 * 通讯信用评分结果查询
	 * @param paramData
	 * @param timeDiff
	 */
	public String get_result(String batchCode,int timeDiff);
	/**
	 * 通讯信用评分查询
	 * @param paramData
	 * @param timeDiff
	 */
	public String get_query(String paramData,int timeDiff);
	/**
	 * 获取央信评分
	 * @param paramData
	 * @param timeDiff
	 * @return
	 */
	public float get_score(String paramData,int timeDiff);

	
	/**
	 * @param id  id可以在公司注册邮件里面找到
	 * @return
	 */
	public int get_timeDiff(String id);

}

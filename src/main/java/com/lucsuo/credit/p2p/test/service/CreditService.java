package com.lucsuo.credit.p2p.test.service;


/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public interface CreditService {

	
	/**
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

package com.lucsuo.credit.p2p.test.service;

public interface CreditService {

	/**
	 * 央信评分接口对接示例
	 * @param paramData
	 * @return
	 */
	 public String getCenterScore(String paramData);
	 /**
	  * 调用时间同步接口
	  * @return
	  */
	 public int getComScoreTime();
	 /**
	  * post查询通讯信用评分
	  * @param comScoreTime
	  * @param data
	  * @return
	  */
	 public String getComScore(int comScoreTime,String data);
	 /**
	  * 根据查询返回的batchCode,获取评分
	  * @param batchCode
	  * @param comScoreTime
	  * @return
	  */
	 public String getComScore(String batchCode,int comScoreTime);
}

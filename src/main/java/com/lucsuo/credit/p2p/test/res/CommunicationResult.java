package com.lucsuo.credit.p2p.test.res;

/**
 * 通讯返回内容对象
 * 
 * @author 王鹏
 *
 */
public class CommunicationResult {

	/** 方案id */
	private String caseId;
	/** 分数 */
	private int score;
	/** 查询时间 **/
	private String queryTime;
	/** 客户姓名 **/
	private String customerName;
	/** 客户手机号码 **/
	private String customerMobile;
	/** 客户证件号码 **/
	private String customerIdNumber;
	/** 概率 */
	private float probability;

	/** 方案id */
	public String getCaseId() {
		return caseId;
	}

	/** 方案id */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	/** 分数 */
	public int getScore() {
		return score;
	}

	/** 分数 */
	public void setScore(int score) {
		this.score = score;
	}

	/** 查询时间 **/
	public String getQueryTime() {
		return queryTime;
	}

	/** 查询时间 **/
	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}

	/** 客户姓名 **/
	public String getCustomerName() {
		return customerName;
	}

	/** 客户姓名 **/
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/** 客户手机号码 **/
	public String getCustomerMobile() {
		return customerMobile;
	}

	/** 客户手机号码 **/
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	/** 客户证件号码 **/
	public String getCustomerIdNumber() {
		return customerIdNumber;
	}

	/** 客户证件号码 **/
	public void setCustomerIdNumber(String customerIdNumber) {
		this.customerIdNumber = customerIdNumber;
	}

	/** 概率 */
	public float getProbability() {
		return probability;
	}

	/** 概率 */
	public void setProbability(float probability) {
		this.probability = probability;
	}

}

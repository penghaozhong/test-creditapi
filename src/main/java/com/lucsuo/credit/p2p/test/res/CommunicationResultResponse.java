package com.lucsuo.credit.p2p.test.res;

/**
 * 轮询查询,返回内容对象
 * 
 * @author 王鹏
 *
 */
public class CommunicationResultResponse {

	/** 查询结果代码 */
	private int resCode;

	/** 查询结果描述 */
	private String resMsg;

	/** 查询处理完成时间 */
	private String finishTime;

	/** 本次查询唯一编号, UUID */
	private String batchCode;

	/** 加密的通讯内容列表 */
	private String jsonList;

	/** 查询结果代码 */
	public int getResCode() {
		return resCode;
	}

	/** 查询结果代码 */
	public void setResCode(int resCode) {
		this.resCode = resCode;
	}

	/** 查询结果描述 */
	public String getResMsg() {
		return resMsg;
	}

	/** 查询结果描述 */
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	/** 查询处理完成时间 */
	public String getFinishTime() {
		return finishTime;
	}

	/** 查询处理完成时间 */
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	/** 本次查询唯一编号, UUID */
	public String getBatchCode() {
		return batchCode;
	}

	/** 本次查询唯一编号, UUID */
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	/** 加密的通讯内容列表 */
	public String getJsonList() {
		return jsonList;
	}

	/** 加密的通讯内容列表 */
	public void setJsonList(String jsonList) {
		this.jsonList = jsonList;
	}

}

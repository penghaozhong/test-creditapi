package com.lucsuo.credit.p2p.test.entity;

import java.io.Serializable;

public class AsyncQueryCommunicationVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 文件查询批次码 */
	private String batchCode;

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

}

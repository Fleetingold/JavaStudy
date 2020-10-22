package com.mystudy.icbc.request;

public class QEBILLRequestBizV1 extends RequestBizV1 {
	/**
	 * 	待查指令包序列号
	 */
	@RequestXMLElement(name = "QryfSeqno", parent = "in")
	private String qryfSeqno;
	
	/**
	 * 	待查平台交易流水号
	 */
	@RequestXMLElement(name = "QrySerialNo", parent = "in")
	private String qrySerialNo;
	
	public String getQryfSeqno() {
		return qryfSeqno;
	}
	public void setQryfSeqno(String qryfSeqno) {
		this.qryfSeqno = qryfSeqno;
	}
	public String getQrySerialNo() {
		return qrySerialNo;
	}
	public void setQrySerialNo(String qrySerialNo) {
		this.qrySerialNo = qrySerialNo;
	}
}

package com.mystudy.icbc.request;

public class QEBILLRequestBizV1 extends RequestBizV1 {
	/**
	 * 	����ָ������к�
	 */
	@RequestXMLElement(name = "QryfSeqno", parent = "in")
	private String qryfSeqno;
	
	/**
	 * 	����ƽ̨������ˮ��
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

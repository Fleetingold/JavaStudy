package com.mystudy.icbc.request;

public class QHISDRequestBizV1 extends RequestBizV1 {
	@RequestXMLElement(name = "directin", parent = "in")
	private QHISDRequestV1.QHISDRequestRdV1 rd;

	public QHISDRequestV1.QHISDRequestRdV1 getRd() {
		return rd;
	}

	public void setRd(QHISDRequestV1.QHISDRequestRdV1 rd) {
		this.rd = rd;
	}
}

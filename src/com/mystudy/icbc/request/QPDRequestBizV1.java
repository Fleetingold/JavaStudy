package com.mystudy.icbc.request;

public class QPDRequestBizV1 extends RequestBizV1 {
	@RequestXMLElement(name = "directin", parent = "in")
	private QPDRequestV1.QPDRequestRdV1 rd;

	public QPDRequestV1.QPDRequestRdV1 getRd() {
		return rd;
	}

	public void setRd(QPDRequestV1.QPDRequestRdV1 rd) {
		this.rd = rd;
	}
}

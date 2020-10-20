package com.mystudy.icbc.request;

import java.util.ArrayList;

public class QHISDRequestBizV1 extends RequestBizV1 {
	@RequestXMLElement(name = "rd")
	private ArrayList<QHISDRequestV1.QHISDRequestRdV1> rd;

	public ArrayList<QHISDRequestV1.QHISDRequestRdV1> getRd() {
		return rd;
	}

	public void setRd(ArrayList<QHISDRequestV1.QHISDRequestRdV1> rd) {
		this.rd = rd;
	}
}

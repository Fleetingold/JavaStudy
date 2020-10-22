package com.mystudy.icbc.request;

public class DIBPSBCRequestV1 extends RequestV1 {
	private DIBPSBCRequestBizV1 bizContent;
	
	public DIBPSBCRequestBizV1 getBizContent() {
		return bizContent;
	}
	public void setBizContent(DIBPSBCRequestBizV1 bizContent) {
		this.bizContent = bizContent;
	}
}

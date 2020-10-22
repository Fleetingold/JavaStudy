package com.mystudy.icbc.request;

public class NETINFRequestV1 extends RequestV1 {
	private NETINFRequestBizV1 bizContent;
	
	public NETINFRequestBizV1 getBizContent() {
		return bizContent;
	}
	public void setBizContent(NETINFRequestBizV1 bizContent) {
		this.bizContent = bizContent;
	}
}

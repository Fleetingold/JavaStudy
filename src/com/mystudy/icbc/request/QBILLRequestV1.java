package com.mystudy.icbc.request;

public class QBILLRequestV1 extends RequestV1 {
	private QBILLRequestBizV1 bizContent;
	
	public QBILLRequestBizV1 getBizContent() {
		return bizContent;
	}
	public void setBizContent(QBILLRequestBizV1 bizContent) {
		this.bizContent = bizContent;
	}
}

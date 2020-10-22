package com.mystudy.icbc.request;

public class QEBILLRequestV1 extends RequestV1 {
	private QEBILLRequestBizV1 bizContent;
	
	public QEBILLRequestBizV1 getBizContent() {
		return bizContent;
	}
	public void setBizContent(QEBILLRequestBizV1 bizContent) {
		this.bizContent = bizContent;
	}
}

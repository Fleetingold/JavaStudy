package com.mystudy.icbc.request;

public abstract class RequestV1 {
	protected String serviceUrl;
	protected String param;
	
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getServiceUrl() {
		return serviceUrl;
	}
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
}

package com.mystudy.httpclient;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class FinaBankAccountBalance {
//	@JSONField(name = "ID")
    private String id;
	
//	@JSONField(name = "Bank")
    private String bank;
	
//	@JSONField(name = "Account")
    private String account;
	
//	@JSONField(name = "Balance")
    private double balance;
	
//	@JSONField(name = "Status")
    private int status;
 
//    @JSONField(name = "Creater")
    private String creater;
 
//    @JSONField(name = "CreateDate")
    @JSONField(format="yyyy-MM-dd")
    private Date createDate;
    
//    @JSONField(name = "Updater")
    private String updater;
 
//    @JSONField(name = "UpdateDate")
    @JSONField(format="yyyy-MM-dd")
    private Date updateDate;
    
//    @JSONField(name = "Remark")
    private String remark;
 
    public FinaBankAccountBalance()
    {
    	
    }
    
    public FinaBankAccountBalance(String id,String bank,String account,double balance,int status, String creater, Date createDate, String remark) {
        super();
        this.id = id;
        this.bank= bank;
        this.account= account;
        this.balance = balance;
        this.status = status;
        this.creater = creater;
        this.createDate = createDate;
        this.updater = creater;
        this.updateDate = createDate;
        this.remark = remark;
    }
 
    public void setId(String id) {
    	this.id= id;
    }
    
    public String getId() {
    	return this.id;
    }
    
    public void setBank(String bank) {
    	this.bank= bank;
    }
    
    public String getBank() {
    	return this.bank;
    }
    
    public void setAccount(String account) {
    	this.account= account;
    }
    
    public String getAccount() {
    	return this.account;
    }
    
    public void setBalance(double alance) {
    	this.balance= alance;
    }
    
    public double getBalance() {
    	return this.balance;
    }
    
    // ±ê×¼ getters & setters
    public void setStatus(int status) {
    	this.status = status;
    }
    
    public int getStatus() {
    	return this.status;
    }
    
    public void setCreater(String creater) {
    	this.creater= creater;
    }
    
    public String getCreater() {
    	return this.creater;
    }
    
    public void setCreateDate(Date createDate) {
    	this.createDate= createDate;
    }
    
    public Date getCreateDate() {
    	return this.createDate;
    }
    
    public void setUpdater(String updater) {
    	this.updater= updater;
    }
    
    public String getUpdater() {
    	return this.updater;
    }
    
    public void setUpdateDate(Date updateDate) {
    	this.updateDate= updateDate;
    }
    
    public Date getUpdateDate() {
    	return this.updateDate;
    }
    
    public void setRemark(String remark) {
    	this.remark = remark;
    }
    
    public String getRemark(){
    	return this.remark;
    }
}

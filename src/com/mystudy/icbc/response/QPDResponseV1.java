package com.mystudy.icbc.response;

import java.util.ArrayList;

public class QPDResponseV1 extends ResponseV1 {
	/**
	 * 	账号
	 */
	private String accNo;
	/**
	 * 	户名
	 */
	private String accName;
	/**
	 * 	币种
	 */
	private String currType;
	/**
	 * 	地区代码
	 */
	private String areaCode;
	/**
	 * 	查询下页
	 */
	private String nextTag;
	/**
	 * 	交易条数
	 */
	private String totalNum;
	/**
	 * 	行别
	 */
	private String repReserved1;
	/**
	 * 	响应备用字段2
	 */
	private String repReserved2;
	/**
	 * 	账号序号
	 */
	private String acctSeq;
	
	private ArrayList<QPDResponseV1Rd> rds = new ArrayList<QPDResponseV1.QPDResponseV1Rd>();

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getCurrType() {
		return currType;
	}

	public void setCurrType(String currType) {
		this.currType = currType;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getNextTag() {
		return nextTag;
	}

	public void setNextTag(String nextTag) {
		this.nextTag = nextTag;
	}

	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public String getRepReserved1() {
		return repReserved1;
	}

	public void setRepReserved1(String repReserved1) {
		this.repReserved1 = repReserved1;
	}

	public String getRepReserved2() {
		return repReserved2;
	}

	public void setRepReserved2(String repReserved2) {
		this.repReserved2 = repReserved2;
	}

	public String getAcctSeq() {
		return acctSeq;
	}

	public void setAcctSeq(String acctSeq) {
		this.acctSeq = acctSeq;
	}

	public ArrayList<QPDResponseV1Rd> getRds() {
		return rds;
	}

	public void setRds(ArrayList<QPDResponseV1Rd> rds) {
		this.rds = rds;
	}

	public void addRd(QPDResponseV1Rd rd) {
		rds.add(rd);
	}
	
	@Override
	boolean isSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

	public static class QPDResponseV1Rd {
		/**
		 * 	借贷标志
		 */
		private String drcrf;
		/**
		 * 	凭证号
		 */
		private String vouhNo;
		/**
		 * 	发生额
		 */
		private String Amount;
		/**
		 * 	对方行号
		 */
		private String recipBkNo;
		/**
		 * 	对方账号
		 */
		private String recipAccNo;
		/**
		 * 	对方户名
		 */
		private String recipName;
		/**
		 * 	摘要
		 */
		private String summary;
		/**
		 * 	用途
		 */
		private String useCN;
		/**
		 * 	附言
		 */
		private String postScript;
		/**
		 * 	业务编号
		 */
		private String ref;
		/**
		 * 	业务代码
		 */
		private String busCode;
		/**
		 * 	相关业务编号
		 */
		private String oref;
		/**
		 * 	英文备注
		 */
		private String enSummary;
		/**
		 * 	业务种类
		 */
		private String busType;
		/**
		 * 	凭证种类
		 */
		private String cVouhType;
		/**
		 * 	附加信息
		 */
		private String addInfo;
		/**
		 * 	时间戳
		 */
		private String timeStamp;
		/**
		 * 	电子回单唯一标识 格式:地区号|网点号|柜员号|主机交易流水号
		 */
		private String repReserved3;
		/**
		 * 	财务公司二级账户信息
		 */
		private String repReserved4;
		/**
		 * 	冲正标志
		 */
		private String upDtranf;
		/**
		 * 	起息日
		 */
		private String valueDate;
		/**
		 * 	工行交易代码
		 */
		private String trxCode;
		/**
		 * 	主机交易流水号
		 */
		private String sequenceNo;
		/**
		 * 	交易类型
		 */
		private String cashf;
		/**
		 * 	钞汇标志
		 */
		private String CASHEXF;
		/**
		 * 备注
		 */
		private String remark;
		/**
		 * 	入账日期
		 */
		private String tradeDate;
		/**
		 * 	交易时间
		 */
		private String tradeTime;
		/**
		 * 	交易场所
		 */
		private String tradeLocation;
		/**
		 * 	手续费
		 */
		private String tradeFee;
		/**
		 * 	汇率
		 */
		private String exRate;
		/**
		 * 	外币币种
		 */
		private String forCurrType;
		/**
		 * 	英文摘要
		 */
		private String enAbstract;
		/**
		 * 	对方行名
		 */
		private String recBankName;
		/**
		 * 	开户行行号
		 */
		private String openBankNo;
		/**
		 * 	开户行BIC
		 */
		private String openBankBIC;
		/**
		 * 	开户行名称
		 */
		private String openBankName;
		/**
		 * 	账号序号
		 */
		private String subAcctSeq;
		/**
		 * 	币种
		 */
		private String THCurrency;
		/**
		 * 	类比recip*[对方*],对方信息
		 */
		private String receiptInfo;
		/**
		 * 	银行交易流水号
		 */
		private String onlySequence;
		
		public String getDrcrf() {
			return drcrf;
		}
		public void setDrcrf(String drcrf) {
			this.drcrf = drcrf;
		}
		public String getVouhNo() {
			return vouhNo;
		}
		public void setVouhNo(String vouhNo) {
			this.vouhNo = vouhNo;
		}
		public String getAmount() {
			return Amount;
		}
		public void setAmount(String amount) {
			Amount = amount;
		}
		public String getRecipBkNo() {
			return recipBkNo;
		}
		public void setRecipBkNo(String recipBkNo) {
			this.recipBkNo = recipBkNo;
		}
		public String getRecipAccNo() {
			return recipAccNo;
		}
		public void setRecipAccNo(String recipAccNo) {
			this.recipAccNo = recipAccNo;
		}
		public String getRecipName() {
			return recipName;
		}
		public void setRecipName(String recipName) {
			this.recipName = recipName;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public String getUseCN() {
			return useCN;
		}
		public void setUseCN(String useCN) {
			this.useCN = useCN;
		}
		public String getPostScript() {
			return postScript;
		}
		public void setPostScript(String postScript) {
			this.postScript = postScript;
		}
		public String getRef() {
			return ref;
		}
		public void setRef(String ref) {
			this.ref = ref;
		}
		public String getBusCode() {
			return busCode;
		}
		public void setBusCode(String busCode) {
			this.busCode = busCode;
		}
		public String getOref() {
			return oref;
		}
		public void setOref(String oref) {
			this.oref = oref;
		}
		public String getEnSummary() {
			return enSummary;
		}
		public void setEnSummary(String enSummary) {
			this.enSummary = enSummary;
		}
		public String getBusType() {
			return busType;
		}
		public void setBusType(String busType) {
			this.busType = busType;
		}
		public String getCVouhType() {
			return cVouhType;
		}
		public void setCVouhType(String cVouhType) {
			this.cVouhType = cVouhType;
		}
		public String getAddInfo() {
			return addInfo;
		}
		public void setAddInfo(String addInfo) {
			this.addInfo = addInfo;
		}
		public String getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}
		public String getRepReserved3() {
			return repReserved3;
		}
		public void setRepReserved3(String repReserved3) {
			this.repReserved3 = repReserved3;
		}
		public String getRepReserved4() {
			return repReserved4;
		}
		public void setRepReserved4(String repReserved4) {
			this.repReserved4 = repReserved4;
		}
		public String getUpDtranf() {
			return upDtranf;
		}
		public void setUpDtranf(String upDtranf) {
			this.upDtranf = upDtranf;
		}
		public String getValueDate() {
			return valueDate;
		}
		public void setValueDate(String valueDate) {
			this.valueDate = valueDate;
		}
		public String getTrxCode() {
			return trxCode;
		}
		public void setTrxCode(String trxCode) {
			this.trxCode = trxCode;
		}
		public String getSequenceNo() {
			return sequenceNo;
		}
		public void setSequenceNo(String sequenceNo) {
			this.sequenceNo = sequenceNo;
		}
		public String getCashf() {
			return cashf;
		}
		public void setCashf(String cashf) {
			this.cashf = cashf;
		}
		public String getCASHEXF() {
			return CASHEXF;
		}
		public void setCASHEXF(String cASHEXF) {
			CASHEXF = cASHEXF;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public String getTradeDate() {
			return tradeDate;
		}
		public void setTradeDate(String tradeDate) {
			this.tradeDate = tradeDate;
		}
		public String getTradeTime() {
			return tradeTime;
		}
		public void setTradeTime(String tradeTime) {
			this.tradeTime = tradeTime;
		}
		public String getTradeLocation() {
			return tradeLocation;
		}
		public void setTradeLocation(String tradeLocation) {
			this.tradeLocation = tradeLocation;
		}
		public String getTradeFee() {
			return tradeFee;
		}
		public void setTradeFee(String tradeFee) {
			this.tradeFee = tradeFee;
		}
		public String getExRate() {
			return exRate;
		}
		public void setExRate(String exRate) {
			this.exRate = exRate;
		}
		public String getForCurrType() {
			return forCurrType;
		}
		public void setForCurrType(String forCurrType) {
			this.forCurrType = forCurrType;
		}
		public String getEnAbstract() {
			return enAbstract;
		}
		public void setEnAbstract(String enAbstract) {
			this.enAbstract = enAbstract;
		}
		public String getRecBankName() {
			return recBankName;
		}
		public void setRecBankName(String recBankName) {
			this.recBankName = recBankName;
		}
		public String getOpenBankNo() {
			return openBankNo;
		}
		public void setOpenBankNo(String openBankNo) {
			this.openBankNo = openBankNo;
		}
		public String getOpenBankBIC() {
			return openBankBIC;
		}
		public void setOpenBankBIC(String openBankBIC) {
			this.openBankBIC = openBankBIC;
		}
		public String getOpenBankName() {
			return openBankName;
		}
		public void setOpenBankName(String openBankName) {
			this.openBankName = openBankName;
		}
		public String getSubAcctSeq() {
			return subAcctSeq;
		}
		public void setSubAcctSeq(String subAcctSeq) {
			this.subAcctSeq = subAcctSeq;
		}
		public String getTHCurrency() {
			return THCurrency;
		}
		public void setTHCurrency(String tHCurrency) {
			THCurrency = tHCurrency;
		}
		public String getReceiptInfo() {
			return receiptInfo;
		}
		public void setReceiptInfo(String receiptInfo) {
			this.receiptInfo = receiptInfo;
		}
		public String getOnlySequence() {
			return onlySequence;
		}
		public void setOnlySequence(String onlySequence) {
			this.onlySequence = onlySequence;
		}
	}
}

package com.mystudy.icbc.response;

import java.util.ArrayList;

public class QPDResponseV1 extends ResponseV1 {
	/**
	 * 	�˺�
	 */
	private String accNo;
	/**
	 * 	����
	 */
	private String accName;
	/**
	 * 	����
	 */
	private String currType;
	/**
	 * 	��������
	 */
	private String areaCode;
	/**
	 * 	��ѯ��ҳ
	 */
	private String nextTag;
	/**
	 * 	��������
	 */
	private String totalNum;
	/**
	 * 	�б�
	 */
	private String repReserved1;
	/**
	 * 	��Ӧ�����ֶ�2
	 */
	private String repReserved2;
	/**
	 * 	�˺����
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
		 * 	�����־
		 */
		private String drcrf;
		/**
		 * 	ƾ֤��
		 */
		private String vouhNo;
		/**
		 * 	������
		 */
		private String Amount;
		/**
		 * 	�Է��к�
		 */
		private String recipBkNo;
		/**
		 * 	�Է��˺�
		 */
		private String recipAccNo;
		/**
		 * 	�Է�����
		 */
		private String recipName;
		/**
		 * 	ժҪ
		 */
		private String summary;
		/**
		 * 	��;
		 */
		private String useCN;
		/**
		 * 	����
		 */
		private String postScript;
		/**
		 * 	ҵ����
		 */
		private String ref;
		/**
		 * 	ҵ�����
		 */
		private String busCode;
		/**
		 * 	���ҵ����
		 */
		private String oref;
		/**
		 * 	Ӣ�ı�ע
		 */
		private String enSummary;
		/**
		 * 	ҵ������
		 */
		private String busType;
		/**
		 * 	ƾ֤����
		 */
		private String cVouhType;
		/**
		 * 	������Ϣ
		 */
		private String addInfo;
		/**
		 * 	ʱ���
		 */
		private String timeStamp;
		/**
		 * 	���ӻص�Ψһ��ʶ ��ʽ:������|�����|��Ա��|����������ˮ��
		 */
		private String repReserved3;
		/**
		 * 	����˾�����˻���Ϣ
		 */
		private String repReserved4;
		/**
		 * 	������־
		 */
		private String upDtranf;
		/**
		 * 	��Ϣ��
		 */
		private String valueDate;
		/**
		 * 	���н��״���
		 */
		private String trxCode;
		/**
		 * 	����������ˮ��
		 */
		private String sequenceNo;
		/**
		 * 	��������
		 */
		private String cashf;
		/**
		 * 	�����־
		 */
		private String CASHEXF;
		/**
		 * ��ע
		 */
		private String remark;
		/**
		 * 	��������
		 */
		private String tradeDate;
		/**
		 * 	����ʱ��
		 */
		private String tradeTime;
		/**
		 * 	���׳���
		 */
		private String tradeLocation;
		/**
		 * 	������
		 */
		private String tradeFee;
		/**
		 * 	����
		 */
		private String exRate;
		/**
		 * 	��ұ���
		 */
		private String forCurrType;
		/**
		 * 	Ӣ��ժҪ
		 */
		private String enAbstract;
		/**
		 * 	�Է�����
		 */
		private String recBankName;
		/**
		 * 	�������к�
		 */
		private String openBankNo;
		/**
		 * 	������BIC
		 */
		private String openBankBIC;
		/**
		 * 	����������
		 */
		private String openBankName;
		/**
		 * 	�˺����
		 */
		private String subAcctSeq;
		/**
		 * 	����
		 */
		private String THCurrency;
		/**
		 * 	���recip*[�Է�*],�Է���Ϣ
		 */
		private String receiptInfo;
		/**
		 * 	���н�����ˮ��
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

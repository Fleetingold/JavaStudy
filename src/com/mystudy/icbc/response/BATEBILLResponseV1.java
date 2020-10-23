package com.mystudy.icbc.response;

import java.util.ArrayList;

public class BATEBILLResponseV1 extends ResponseV1 {
	/**
	 * 	平台交易流水号
	 */
	private String serialNo;
	/**
	 * 	总笔数
	 */
	private String totalNum;
	
	private ArrayList<BATEBILLResponseV1Rd> rds = new ArrayList<BATEBILLResponseV1Rd>();
	
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public ArrayList<BATEBILLResponseV1Rd> getRds() {
		return rds;
	}

	public void setRds(ArrayList<BATEBILLResponseV1Rd> rds) {
		this.rds = rds;
	}
	
	public void addRd(BATEBILLResponseV1Rd rd) {
		rds.add(rd);
	}

	@Override
	boolean isSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

	public static class BATEBILLResponseV1Rd {
		/**
		 * 	指令包顺序号
		 */
		private String iSeqno;
		/**
		 * 	平台交易序号
		 */
		private String orderNo;
		/**
		 * 	电子回单号码
		 */
		private String ebillSerialno;
		/**
		 * 	付方账号
		 */
		private String payAccount;
		/**
		 * 	付方账户名称
		 */
		private String payAcctName;
		/**
		 * 	付方开户银行名称
		 */
		private String payBankName;
		/**
		 * 	收方账号
		 */
		private String recAccount;
		/**
		 * 	收方账户名称
		 */
		private String recAcctName;
		/**
		 * 	收方开户行名称
		 */
		private String recBankName;
		/**
		 * 	金额
		 */
		private String payAmt;
		/**
		 * 	币种
		 */
		private String currType;
		/**
		 * 	摘要
		 */
		private String summary;
		/**
		 * 	业务种类
		 */
		private String busType;
		/**
		 * 	用途
		 */
		private String useCN;
		/**
		 * 	交易流水号
		 */
		private String tranSerialNo;
		/**
		 * 	时间戳
		 */
		private String timeStamp;
		/**
		 * 	备注
		 */
		private String remark;
		/**
		 * 	验证码
		 */
		private String ebillKey;
		/**
		 * 	记账网点
		 */
		private String transNetCode;
		/**
		 * 	记账柜员
		 */
		private String transTellno;
		/**
		 * 	记账日期
		 */
		private String transDate;
		/**
		 * 	补打次数
		 */
		private String rePrintNum;
		/**
		 * 	附言
		 */
		private String postScript;
		/**
		 * 	凭证号
		 */
		private String vouchNo;
		/**
		 * 	凭证种类
		 */
		private String vouchType;
		/**
		 * 	处理结果
		 */
		private String result;
		/**
		 * 	明细交易返回码
		 */
		private String iRetCode;
		/**
		 * 	明细交易返回描述
		 */
		private String iRetMsg;
		/**
		 * 	付款人账号
		 */
		private String agentPayAcctNo;
		/**
		 * 	付款人户名
		 */
		private String agentPayName;
		/**
		 * 	冲正标志
		 */
		private String updTranf;
		/**
		 * 	起息日
		 */
		private String valueDate;
		/**
		 * 	账号序号
		 */
		private String acctSeq;
		/**
		 * 	子账户别名
		 */
		private String acctSeqName;
		/**
		 * 	业务（产品）种类
		 */
		private String prodType;
		/**
		 * 	回单个性化要素
		 */
		private String cusInfo;
		/**
		 * 	银行交易流水号
		 */
		private String bankSerialNo;
		
		public String getiSeqno() {
			return iSeqno;
		}
		public void setiSeqno(String iSeqno) {
			this.iSeqno = iSeqno;
		}
		public String getOrderNo() {
			return orderNo;
		}
		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}
		public String getEbillSerialno() {
			return ebillSerialno;
		}
		public void setEbillSerialno(String ebillSerialno) {
			this.ebillSerialno = ebillSerialno;
		}
		public String getPayAccount() {
			return payAccount;
		}
		public void setPayAccount(String payAccount) {
			this.payAccount = payAccount;
		}
		public String getPayAcctName() {
			return payAcctName;
		}
		public void setPayAcctName(String payAcctName) {
			this.payAcctName = payAcctName;
		}
		public String getPayBankName() {
			return payBankName;
		}
		public void setPayBankName(String payBankName) {
			this.payBankName = payBankName;
		}
		public String getRecAccount() {
			return recAccount;
		}
		public void setRecAccount(String recAccount) {
			this.recAccount = recAccount;
		}
		public String getRecAcctName() {
			return recAcctName;
		}
		public void setRecAcctName(String recAcctName) {
			this.recAcctName = recAcctName;
		}
		public String getRecBankName() {
			return recBankName;
		}
		public void setRecBankName(String recBankName) {
			this.recBankName = recBankName;
		}
		public String getPayAmt() {
			return payAmt;
		}
		public void setPayAmt(String payAmt) {
			this.payAmt = payAmt;
		}
		public String getCurrType() {
			return currType;
		}
		public void setCurrType(String currType) {
			this.currType = currType;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public String getBusType() {
			return busType;
		}
		public void setBusType(String busType) {
			this.busType = busType;
		}
		public String getUseCN() {
			return useCN;
		}
		public void setUseCN(String useCN) {
			this.useCN = useCN;
		}
		public String getTranSerialNo() {
			return tranSerialNo;
		}
		public void setTranSerialNo(String tranSerialNo) {
			this.tranSerialNo = tranSerialNo;
		}
		public String getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public String getEbillKey() {
			return ebillKey;
		}
		public void setEbillKey(String ebillKey) {
			this.ebillKey = ebillKey;
		}
		public String getTransNetCode() {
			return transNetCode;
		}
		public void setTransNetCode(String transNetCode) {
			this.transNetCode = transNetCode;
		}
		public String getTransTellno() {
			return transTellno;
		}
		public void setTransTellno(String transTellno) {
			this.transTellno = transTellno;
		}
		public String getTransDate() {
			return transDate;
		}
		public void setTransDate(String transDate) {
			this.transDate = transDate;
		}
		public String getRePrintNum() {
			return rePrintNum;
		}
		public void setRePrintNum(String rePrintNum) {
			this.rePrintNum = rePrintNum;
		}
		public String getPostScript() {
			return postScript;
		}
		public void setPostScript(String postScript) {
			this.postScript = postScript;
		}
		public String getVouchNo() {
			return vouchNo;
		}
		public void setVouchNo(String vouchNo) {
			this.vouchNo = vouchNo;
		}
		public String getVouchType() {
			return vouchType;
		}
		public void setVouchType(String vouchType) {
			this.vouchType = vouchType;
		}
		public String getResult() {
			if(result.equals("0")) {
				result += "-提交成功,等待银行处理";
			} else if(result.equals("6")) {
				result += "-被银行拒绝";
			} else if(result.equals("7")) {
				result += "-处理成功";
			}
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		public String getiRetCode() {
			return iRetCode;
		}
		public void setiRetCode(String iRetCode) {
			this.iRetCode = iRetCode;
		}
		public String getiRetMsg() {
			return iRetMsg;
		}
		public void setiRetMsg(String iRetMsg) {
			this.iRetMsg = iRetMsg;
		}
		public String getAgentPayAcctNo() {
			return agentPayAcctNo;
		}
		public void setAgentPayAcctNo(String agentPayAcctNo) {
			this.agentPayAcctNo = agentPayAcctNo;
		}
		public String getAgentPayName() {
			return agentPayName;
		}
		public void setAgentPayName(String agentPayName) {
			this.agentPayName = agentPayName;
		}
		public String getUpdTranf() {
			switch(updTranf) {
				case "0" :
					updTranf += "-正常";
					break;
				case "1" :
					updTranf += "-红蓝字冲借";
					break;
				case "2" :
					updTranf += "-红蓝字冲贷";
					break;
				case "3" :
					updTranf += "-双方红字冲账(红字单笔)";
					break;
				case "4" :
					updTranf += "-双方蓝字补账(蓝字单笔)";
					break;
				default :
					break;
			}
			
			return updTranf;
		}
		public void setUpdTranf(String updTranf) {
			this.updTranf = updTranf;
		}
		public String getValueDate() {
			return valueDate;
		}
		public void setValueDate(String valueDate) {
			this.valueDate = valueDate;
		}
		public String getAcctSeq() {
			return acctSeq;
		}
		public void setAcctSeq(String acctSeq) {
			this.acctSeq = acctSeq;
		}
		public String getAcctSeqName() {
			return acctSeqName;
		}
		public void setAcctSeqName(String acctSeqName) {
			this.acctSeqName = acctSeqName;
		}
		public String getProdType() {
			return TurnProdType(Integer.parseInt(prodType));
		}
		public void setProdType(String prodType) {
			this.prodType = prodType;
		}
		public String getCusInfo() {
			return cusInfo;
		}
		public void setCusInfo(String cusInfo) {
			this.cusInfo = cusInfo;
		}
		public String getBankSerialNo() {
			return bankSerialNo;
		}
		public void setBankSerialNo(String bankSerialNo) {
			this.bankSerialNo = bankSerialNo;
		}
		
		public String TurnProdType(int iProdType) {
			switch(iProdType) {
				case 0 :
					return iProdType + "-转账";
				case 1 :
					return iProdType + "-现金";
				case 2 :
					return iProdType + "-现金存入";
				case 3 :
					return iProdType + "-同城转账";
				case 4 :
					return iProdType + "-汇划收报";
				case 5 :
					return iProdType + "-跨行收报";
				case 6 :
					return iProdType + "-利息入账";
				case 7 :
					return iProdType + "-即时通";
				case 8 :
					return iProdType + "-对公收费";
				case 9 :
					return iProdType + "-法人理财";
				case 10 :
					return iProdType + "-基金";
				case 11 :
					return iProdType + "-债券";
				case 12 :
					return iProdType + "-贵金属";
				case 13 :
					return iProdType + "-跨行发报";
				case 14 :
					return iProdType + "-汇划发报";
				case 15 :
					return iProdType + "-公益捐款";
				case 16 :
					return iProdType + "-结构性存款";
				case 17 :
					return iProdType + "-电子商务";
				case 18 :
					return iProdType + "-单位定期（通知）存款";
				case 19 :
					return iProdType + "-对公贷款";
				case 20 :
					return iProdType + "-代理业务";
				case 21 :
					return iProdType + "-银证业务";
				case 22 :
					return iProdType + "-银期业务";
				case 23 :
					return iProdType + "-银商业务";
				case 24 :
					return iProdType + "-银关业务";
				case 25 :
					return iProdType + "-银税业务";
				case 26 :
					return iProdType + "-银银合作";
				case 27 :
					return iProdType + "-银财业务";
				case 28 :
					return iProdType + "-全球现金管理业务";
				case 29 :
					return iProdType + "-通存通兑-个人汇款";
				case 30 :
					return iProdType + "-网银互联";
				case 31 :
					return iProdType + "-贷款发放";
				case 32 :
					return iProdType + "-贷款归还";
				case 33 :
					return iProdType + "-贷款红蓝冲借";
				case 34 :
					return iProdType + "-非信贷资产";
				case 35 :
					return iProdType + "-抵债资产";
				case 36 :
					return iProdType + "-垫款";
				case 37 :
					return iProdType + "-贵金属收费";
				case 38 :
					return iProdType + "-贷款付息";
				case 39 :
					return iProdType + "-委托贷款收费";
				case 40 :
					return iProdType + "-表外贷款手续费";
				case 41 :
					return iProdType + "-外汇业务";
				case 42 :
					return iProdType + "-特约商户POS";
				case 43 :
					return iProdType + "-保证金业务";
				case 44 :
					return iProdType + "-BSP和SLB";
				case 45 :
					return iProdType + "-单证中心";
				case 46 :
					return iProdType + "-综合收付款";
				case 47 :
					return iProdType + "-资金池";
				case 48 :
					return iProdType + "-养老金理财";
				case 49 :
					return iProdType + "-存款转换";
				case 50 :
					return iProdType + "-委托收款";
				case 51 :
					return iProdType + "-托收承付";
				default :
					break;
			}
			return Integer.toString(iProdType);
		}
	}
}

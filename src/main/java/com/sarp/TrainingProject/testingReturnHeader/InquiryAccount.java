package com.sarp.TrainingProject.testingReturnHeader;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InquiryAccount {

	@JsonProperty("ACCT_NO")
	private String acctNo;
	
	@JsonProperty("REMARK2")
	private String remark2;
	
	@JsonProperty("REMARK3")
	private String remark3;
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	
	
	
	
}

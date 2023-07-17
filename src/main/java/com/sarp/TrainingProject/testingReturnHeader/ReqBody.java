package com.sarp.TrainingProject.testingReturnHeader;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReqBody {

	@JsonProperty("REQUEST")
	InquiryAccount requestBody;

	public InquiryAccount getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(InquiryAccount requestBody) {
		this.requestBody = requestBody;
	}

	
	
	
}

package com.sarp.TrainingProject.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ResErrorDto {

	private int totalError;
	private List<String> listError;
	private Date timestamp;
	
	public ResErrorDto() {
	
	}
	
	public ResErrorDto(String error) {
		if (error.contains("|")) {
			this.listError = new ArrayList<String>();
			String[] errors = error.split("\\|");
			for (String value : errors) {
				this.listError.add(value);
			}
		} else {
			this.listError = Arrays.asList(new String[] {error});
		}
		
		this.totalError = this.listError.size();
		this.timestamp = new Date();
		
	}
	
	public ResErrorDto(List<String> listError) {
		this.listError = listError;
		this.totalError = this.listError.size();
		this.timestamp = new Date();
	}

	public int getTotalError() {
		return totalError;
	}

	public void setTotalError(int totalError) {
		this.totalError = totalError;
	}

	public List<String> getListError() {
		return listError;
	}

	public void setListError(List<String> listError) {
		this.listError = listError;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}

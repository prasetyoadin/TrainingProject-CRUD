package com.sarp.TrainingProject.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class AppProperties {
		
	@Value("${namaApps}")
	private String namaApps;

	public String getNamaApps() {
		return namaApps;
	}

	public void setNamaApps(String namaApps) {
		this.namaApps = namaApps;
	}
	
	

}

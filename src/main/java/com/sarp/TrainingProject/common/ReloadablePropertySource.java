package com.sarp.TrainingProject.common;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.core.env.PropertySource;

@SuppressWarnings("rawtypes")
public class ReloadablePropertySource extends PropertySource {
	
	PropertiesConfiguration propertiesConfiguration;
	
	public ReloadablePropertySource(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public Object getProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	
}

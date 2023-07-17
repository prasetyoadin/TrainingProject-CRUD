package com.sarp.TrainingProject.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class ResponseHandler {
	
	private ResponseHandler() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
	
	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, List<Object> responseObject) {
		
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("message", message);
		map.add("status", status);
		map.add("data", responseObject);
		
		return new ResponseEntity<Object>(map,status);
	}

}

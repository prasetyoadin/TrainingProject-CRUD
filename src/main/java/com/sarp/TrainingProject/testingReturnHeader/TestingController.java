package com.sarp.TrainingProject.testingReturnHeader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;



@RestController
@RequestMapping("/api/sandy")
public class TestingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestingController.class);
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> post(@RequestBody ReqBody req) {

		String url = "http://10.35.65.148:6001/invoke/bri.core.services.v1:inquiryAccount";
		
		RestTemplate restApi = new RestTemplate();
		MultiValueMap<String, String> mapHeader = new LinkedMultiValueMap<>();
		mapHeader.add("Content-Type", "application/json");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyHHmmss");
		Date date = new Date();  
		mapHeader.add("X-ESB-EXTERNAL_ID", String.valueOf(formatter.format(date)));
		mapHeader.add("X-ESB-CHANNEL_ID", "NBMB");
		mapHeader.add("X-ESB-SERVICE_ID", "00001");
		
		Map<String, String> reqBody = new HashMap<>();
		reqBody.put("ACCT_NO", req.getRequestBody().getAcctNo());
		reqBody.put("REMARK2", req.getRequestBody().getRemark2());
		
		Map<String, Object> body = new HashMap<>();
		body.put("REQUEST", reqBody);
		HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, mapHeader);
		
		ResponseEntity<Object> response = restApi.exchange(url, HttpMethod.POST, request, Object.class);
		
		String responseBody = new Gson().toJson(response.getBody());
		LOGGER.info("Logging : " + responseBody); 

	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.addAll(response.getHeaders());
	    

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body(new Gson().toJson(response.getBody()));
	    
//	    return null;
	}
}

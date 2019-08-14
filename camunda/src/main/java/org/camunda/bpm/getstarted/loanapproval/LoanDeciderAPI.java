package org.camunda.bpm.getstarted.loanapproval;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

//import org.json.simple.JSONArray; 
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser; 

public class LoanDeciderAPI {
	public static LoanDecisionPOJO sendLoanRequest(String userId, int creditScore) throws Exception {

		String creditSc = Integer.toString(creditScore);
		String payload = "{\"userId\": \"" + userId + "\", " + "\"creditScore\": \"" + creditSc + "\"" + "}";


		StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(
				"http://drools-springboot-msk-sample.apps.us-west-2.online-starter.openshift.com/api/rules/loanApproval/getDecision");
		request.setEntity(entity);

		HttpResponse response = httpClient.execute(request);
		
		ObjectMapper objectMapper = new ObjectMapper();
		LoanDecisionPOJO myObject = objectMapper.readValue(response.getEntity().getContent(), LoanDecisionPOJO.class);
		
		System.out.println(myObject.getComments());

		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getClass());
		
		return myObject;
	}
}

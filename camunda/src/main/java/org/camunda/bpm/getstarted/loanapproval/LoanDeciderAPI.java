package org.camunda.bpm.getstarted.loanapproval;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.camunda.bpm.engine.delegate.DelegateExecution;


public class LoanDeciderAPI implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		sendLoanRequest(execution.getVariable("userId"), execution.getVariable("creditScore"));
	}
	
	public static LoanDecisionPOJO sendLoanRequest(Object userId, Object creditScore) throws Exception {

		String creditSc = creditScore.toString();
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

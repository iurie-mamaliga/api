package org.camunda.bpm.getstarted.loanapproval;

//import java.util.Arrays;
//import java.util.List;

//import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RestControl {	
	
	@RequestMapping("/API/bpm/loanApproval/process/startProcess")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoanDecisionSummaryPOJO startLoanApplicationn(@RequestBody CustomerPOJO customer) throws Exception {
		System.out.println("Creating a person");

		LoanDecisionPOJO loanDecision = sendLoanRequest(customer.getUserId(), customer.getCreditScore());

		LoanDecisionSummaryPOJO response = new LoanDecisionSummaryPOJO();
		response.setApr(loanDecision.getApr());
		response.setLoanDecision(loanDecision.getLoanDecision());
		response.setProcessId(loanDecision.getProcessId());
		System.out.println(response.getApr());
		System.out.println(response.getLoanDecision());
		System.out.println(response.getProcessId());
		return response;
	}
	
	
	
	public static LoanDecisionPOJO sendLoanRequest(Object userId, Object creditScore) throws Exception {

		String creditSc = creditScore.toString();
		int crS = Integer.parseInt(creditSc);
		String id = userId.toString();
		
		 String payload = "{ " +
					   "\"variables\":" +
					  "{" +
					    " \"creditScore\" :{ \"value\":" + "\"" + crS + "\"" + ", \"type\": \"integer\"}," +
					     " \"userId\" :{\"value\":" + "\"" + id + "\"" + ", \"type\": \"String\"}" +
					  "}" +
					"}";
					

		StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(
				"http://localhost:8080/rest/process-definition/key/loanApproval/start");
		request.setEntity(entity);

		HttpResponse response = httpClient.execute(request);
		
		ObjectMapper objectMapper = new ObjectMapper();
		CamundaResponseAfterStartPOJO camundaResponse = objectMapper.readValue(response.getEntity().getContent(), CamundaResponseAfterStartPOJO.class);
		
		LoanDecisionPOJO myObject = LoanDeciderAPI.sendLoanRequest(userId, creditScore);
		
		myObject.setProcessId(camundaResponse.getId());
		
		System.out.println(myObject.getComments());
		System.out.println(myObject.getComments());
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getClass());
		
		return myObject;
	}

}


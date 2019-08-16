package org.camunda.bpm.getstarted.loanapproval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.Consumes;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RestControl {	
	
	
	@OPTIONS
	@CrossOrigin(origins="*", allowedHeaders="*")
	@RequestMapping("/API/bpm/loanApproval/process/startProcess")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoanDecisionSummaryPOJO startLoanApplication(@RequestBody CustomerPOJO customer) throws Exception {
		System.out.println("Creating a person");

		LoanDecisionPOJO loanDecision = sendLoanRequest(customer);

		LoanDecisionSummaryPOJO response = new LoanDecisionSummaryPOJO();
		response.setApr(loanDecision.getApr());
		response.setLoanDecision(loanDecision.getLoanDecision());
		response.setProcessId(loanDecision.getProcessId());
		response.setComments(loanDecision.getComments());
		System.out.println(response.getApr());
		System.out.println(response.getLoanDecision());
		System.out.println(response.getProcessId());
		
		Response.ok()
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
	      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
		
		return response;
	}
	
	@OPTIONS
	@CrossOrigin(origins="*", allowedHeaders="*")
	@RequestMapping("/API/bpm/loanApproval/task/completeTask")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TaskCompleteSummaryPOJO completeTask(@RequestBody TaskCompleteSummaryPOJO taskToComplete) throws Exception {
		System.out.println("Task id and decision received");

		String taskId = getTaskId(taskToComplete.getTaskId());
		TaskCompleteSummaryPOJO response = closeTask(taskToComplete, taskId);
		
		Response.ok()
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
	      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
		
		
		System.out.println("Task Closed");
		return response;
	}
	
	public static TaskCompleteSummaryPOJO closeTask(TaskCompleteSummaryPOJO taskToComplete, String taskId) throws ClientProtocolException, IOException {
		
		TaskCompleteSummaryPOJO response = new TaskCompleteSummaryPOJO();
		response.setApproved(taskToComplete.isApproved());
		response.setApprovedBy(taskToComplete.getApprovedBy());
		response.setApprovedOn(taskToComplete.getApprovedOn());
		response.setApr(taskToComplete.getApr());
		response.setComments(taskToComplete.getComments());
		response.setLoanAmount(taskToComplete.getLoanAmount());
		response.setTaskId(taskToComplete.getTaskId());
		
		
		String payload = "{\"variables\":" +
	    "{" +
		    "\"loanApproved\": {\"value\": " + taskToComplete.isApproved() + "}}" +
		"}";
					

		StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost request = new HttpPost(
				"http://localhost:8080/rest/task/" + taskId + "/complete");
		request.setEntity(entity);

		HttpResponse responsee = httpClient.execute(request);
		
		
		System.out.println(responsee);
		System.out.println(responsee.getStatusLine().getStatusCode());
		System.out.println(responsee.getClass());
		
		return response;
	}
	
	public static String getTaskId(String processInstanceId) throws ClientProtocolException, IOException {
		String taskId = null;
		
		String url = "http://localhost:8080/rest/task?processInstanceId=" + processInstanceId;
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		taskId = response.substring(8, 44);
		System.out.println(taskId);
		//print result
		System.out.println(response.toString());
		
		return taskId;
		
	}
	
	
	
	public static LoanDecisionPOJO sendLoanRequest(CustomerPOJO customer) throws Exception {

		
		 String payload = "{ " +
					   "\"variables\":" +
					  "{" +
					    " \"creditScore\" :{ \"value\":" + "\"" + customer.getCreditScore() + "\"" + ", \"type\": \"integer\"}," +
					     " \"userId\" :{\"value\":" + "\"" + customer.getUserId() + "\"" + ", \"type\": \"String\"}," +
					     " \"firstName\" :{\"value\":" + "\"" + customer.getFirstName() + "\"" + ", \"type\": \"String\"}," +
					     " \"lastName\" :{\"value\":" + "\"" + customer.getLastName() + "\"" + ", \"type\": \"String\"}," +
					     " \"income\" :{\"value\":" + "\"" + customer.getIncome() + "\"" + ", \"type\": \"integer\"}," +
					     " \"age\" :{\"value\":" + "\"" + customer.getAge() + "\"" + ", \"type\": \"String\"}," +
					     " \"address\" :{\"value\":" + "\"" + customer.getAddress() + "\"" + ", \"type\": \"String\"}," +
					     " \"email\" :{\"value\":" + "\"" + customer.getEmail() + "\"" + ", \"type\": \"String\"}," +
					     " \"socialSecurityNumber\" :{\"value\":" + "\"" + customer.getSocialSecurityNumber() + "\"" + ", \"type\": \"String\"}," +
					     " \"loanAmount\" :{\"value\":" + "\"" + customer.getLoanAmount() + "\"" + ", \"type\": \"integer\"}" +
					  "}" +
					"}";
					

		StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();
		//add all values to camunda payload
		//TO DO change localhost to route: http://camunda-apii-camunda-api.b9ad.pro-us-east-1.openshiftapps.com
		HttpPost request = new HttpPost(
				"http://localhost:8080/rest/process-definition/key/loanApproval/start");
		request.setEntity(entity);

		HttpResponse response = httpClient.execute(request);
		
		ObjectMapper objectMapper = new ObjectMapper();
		CamundaResponseAfterStartPOJO camundaResponse = objectMapper.readValue(response.getEntity().getContent(), CamundaResponseAfterStartPOJO.class);
		
		LoanDecisionPOJO myObject = LoanDeciderAPI.sendLoanRequest(customer.getUserId(), customer.getCreditScore());
		
		myObject.setProcessId(camundaResponse.getId());
		
		System.out.println(myObject.getComments());
		System.out.println(myObject.getComments());
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getClass());
		
		return myObject;
	}

}


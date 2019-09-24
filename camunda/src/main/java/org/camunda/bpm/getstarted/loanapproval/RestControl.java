package org.camunda.bpm.getstarted.loanapproval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins="*")
public class RestControl {	
	
	//get variables for all processes, one user
		@OPTIONS
		@CrossOrigin(origins="*")
		@RequestMapping("/API/bpm/allApplicationDetailsByUser")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.TEXT_PLAIN)
	    public static LoanApplicationPOJO[] getAllLoanApplicationByUser(@RequestParam ("userId") String userId) throws Exception {
	        
	        System.out.println("Request Received for variables api! ");
	        
	        int responseArrayLength = 0;
	        
	        String uri = "http://localhost:8080/rest/variable-instance";
	        HttpGet request = new HttpGet(uri);
	        
	        System.out.println("Before HttpClient");
	        
	        HttpClient httpClient = HttpClientBuilder.create().build();
	        HttpResponse response = httpClient.execute(request);
	        System.out.println("After Client: "+response.toString());
	        
	        ObjectMapper objectMapper = new ObjectMapper();
	        
	        System.out.println(response.getEntity().getContent().toString());
	          
	        ProcessVariablesPOJO[] pojos = objectMapper.readValue(response.getEntity().getContent(), ProcessVariablesPOJO[].class);
	        
	        for(int i = 0; i < pojos.length / 11; i++) {
	        	if(pojos[7 + i * 11].getValue().equals(userId)) {
	        		responseArrayLength += 1;

	        	}
	        }
	        
	        LoanApplicationPOJO[] processVariables = new LoanApplicationPOJO[responseArrayLength]; //pojos.length/11
	        
	        System.out.println("array length " + processVariables.length);
	        
	        for(int i = 0; i < responseArrayLength ; i++)
	        {
	        	processVariables[i] = new LoanApplicationPOJO();
	        }
	        int count = 0;
	        System.out.println("testing id" + processVariables[0].getProcessInstanceId());
	        for(int i = 0; i < pojos.length / 11; i++) {
	        	if(pojos[7 + i * 11].getValue().equals(userId)) {
		        	processVariables[count].setProcessInstanceId(pojos[0 + i * 11].getActivityInstanceId());
		        	System.out.println("testing id" + processVariables[0].getProcessInstanceId());
		        	
		        	
		        	processVariables[count].setIncome(Integer.parseInt(pojos[0 + i * 11].getValue()));
		        	processVariables[count].setFirstName(pojos[1 + i * 11].getValue());
		        	processVariables[count].setLastName(pojos[2 + i * 11].getValue());
		        	processVariables[count].setCreditScore(Integer.parseInt(pojos[4 + i * 11].getValue()));
		        	processVariables[count].setAddress(pojos[5 + i * 11].getValue());
		        	processVariables[count].setSocialSecurityNumber(pojos[6 + i * 11].getValue());
		        	processVariables[count].setUserId(pojos[7 + i * 11].getValue());
		        	processVariables[count].setAge(Integer.parseInt(pojos[8 + i * 11].getValue()));
		        	processVariables[count].setEmail(pojos[9 + i * 11].getValue());
		        	processVariables[count].setLoanAmount(Integer.parseInt(pojos[10 + i * 11].getValue()));
		        	count += 1;
	        	}
	        }
	        	
	        return processVariables;
	    }

	        
	
	//get variables for all processes, all users
	@OPTIONS
	@CrossOrigin(origins="*")
	@RequestMapping("/API/bpm/allApplicationDetails")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static LoanApplicationPOJO[] getAllLoanApplication() throws Exception {
        
        System.out.println("Request Received for variables api! ");
        
        
        
        String uri = "http://localhost:8080/rest/variable-instance";
        HttpGet request = new HttpGet(uri);
        
        System.out.println("Before HttpClient");
        
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(request);
        System.out.println("After Client: "+response.toString());
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        System.out.println(response.getEntity().getContent().toString());
          
        ProcessVariablesPOJO[] pojos = objectMapper.readValue(response.getEntity().getContent(), ProcessVariablesPOJO[].class);
        
        System.out.println("testing id" + pojos[0].getActivityInstanceId());
        
        LoanApplicationPOJO[] processVariables = new LoanApplicationPOJO[pojos.length/11]; //pojos.length/11
        
        System.out.println("array length " + processVariables.length);
        
        for(int i = 0; i < pojos.length/11 ; i++)
        {
        	processVariables[i] = new LoanApplicationPOJO();
        }
        
        System.out.println("testing id" + processVariables[0].getProcessInstanceId());
        for(int i = 0; i < pojos.length / 11; i++) {
        	processVariables[i].setProcessInstanceId(pojos[0 + i * 11].getActivityInstanceId());
        	System.out.println("testing id" + processVariables[0].getProcessInstanceId());
        	
        	
        	processVariables[i].setIncome(Integer.parseInt(pojos[0 + i * 11].getValue()));
        	processVariables[i].setFirstName(pojos[1 + i * 11].getValue());
        	processVariables[i].setLastName(pojos[2 + i * 11].getValue());
        	processVariables[i].setCreditScore(Integer.parseInt(pojos[4 + i * 11].getValue()));
        	processVariables[i].setAddress(pojos[5 + i * 11].getValue());
        	processVariables[i].setSocialSecurityNumber(pojos[6 + i * 11].getValue());
        	processVariables[i].setUserId(pojos[7 + i * 11].getValue());
        	processVariables[i].setAge(Integer.parseInt(pojos[8 + i * 11].getValue()));
        	processVariables[i].setEmail(pojos[9 + i * 11].getValue());
        	processVariables[i].setLoanAmount(Integer.parseInt(pojos[10 + i * 11].getValue()));
        }
        	
        return processVariables;
    }
	
	//get variables for individual process
	@OPTIONS
	@CrossOrigin(origins="*")
	@RequestMapping("/API/bpm/applicationDetails")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public static CustomerPOJO getVariablesForProcess(@RequestBody Object loanApplicationId) throws Exception {
        
        System.out.println("Request Received for variables api! ");
        
        System.out.println("Loan id from variables" + loanApplicationId.toString());
        
        String processDefinitionKey = loanApplicationId.toString();
        String[] tempString = processDefinitionKey.split("=");
        processDefinitionKey = tempString[1].replaceAll("}", "");
        System.out.println("Loan id from variables " + processDefinitionKey);
        
        System.out.println("Before URI");
        
        String uri = "http://localhost:8080/rest/variable-instance?" +
        		 "processInstanceId=" + processDefinitionKey;
        HttpGet request = new HttpGet(uri);
        
        System.out.println("Before HttpClient");
        
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(request);
        System.out.println("After Client: "+response.toString());
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        System.out.println(response.getEntity().getContent().toString());
          
        ProcessVariablesPOJO[] pojos = objectMapper.readValue(response.getEntity().getContent(), ProcessVariablesPOJO[].class);
        
        CustomerPOJO processVariables = new CustomerPOJO();
        

        	processVariables.setIncome(Integer.parseInt(pojos[0].getValue()));
        	processVariables.setFirstName(pojos[1].getValue());
        	processVariables.setLastName(pojos[2].getValue());
        	processVariables.setCreditScore(Integer.parseInt(pojos[4].getValue()));
        	processVariables.setAddress(pojos[5].getValue());
        	processVariables.setSocialSecurityNumber(pojos[6].getValue());
        	processVariables.setUserId(pojos[7].getValue());
        	processVariables.setAge(Integer.parseInt(pojos[8].getValue()));
        	processVariables.setEmail(pojos[9].getValue());
        	processVariables.setLoanAmount(Integer.parseInt(pojos[10].getValue()));
        
        	/*
        	Response.ok()
  	      .header("Access-Control-Allow-Origin", "*")
  	      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
  	      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
        	*/
        return processVariables;
    }
	
	
	
	@OPTIONS
	@CrossOrigin(origins="*", allowedHeaders="*")
	@RequestMapping("/API/bpm/loanApproval/getProcessTaskList")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public static CamundaTaskInfoPOJO[] getProcessTaskList(@RequestBody Object processDefinition) throws Exception {
        
        System.out.println("Request Received for GetProcessTaskList! ");
        
        System.out.println(processDefinition.toString());
        
        String processDefinitionKey = processDefinition.toString();
        String[] tempString = processDefinitionKey.split("=");
        processDefinitionKey = tempString[1].replaceAll("}", "");
        
        System.out.println("Before URI");
        
        String uri = "http://localhost:8080/rest/task/?processDefinitionKey=" + processDefinitionKey;
        HttpGet request = new HttpGet(uri);
        
        System.out.println("Before HttpClient");
        
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(request);
        System.out.println("After Client: "+response.toString());
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        System.out.println(response.getEntity().getContent().toString());
                
        CamundaTaskInfoPOJO[] pojos = objectMapper.readValue(response.getEntity().getContent(), CamundaTaskInfoPOJO[].class);
        
        Response.ok()
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
	      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
        
        return pojos;
    }
	
	@OPTIONS
	@CrossOrigin(origins="*")
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
		
		
		return response;
	}
	
	@OPTIONS
	@CrossOrigin(origins="*")
	@RequestMapping("/API/bpm/loanApproval/task/completeTask")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TaskCompleteSummaryPOJO completeTask(@RequestBody TaskCompleteSummaryPOJO taskToComplete) throws Exception {
		System.out.println("Task id and decision received");

		String taskId = getTaskId(taskToComplete.getTaskId());
		TaskCompleteSummaryPOJO response = closeTask(taskToComplete, taskId);
		

		
		System.out.println("Task Closed");
		return response;
	}
	
	@OPTIONS
	@CrossOrigin(origins="*")
	@RequestMapping("/API/bpm/loanApproval/process/retrieveProcesses/{businessKey}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<CamundaResponseAfterStartPOJO> retrieveProcesses(@PathVariable ("businessKey") String businessKey) throws Exception {
		
		System.out.println("retrieveProcesses :: " + businessKey);
		
		List<CamundaResponseAfterStartPOJO> response = retrieveProcessList(businessKey);
		

		
		
		System.out.println("retrieveProcess completed");
		return response;
	}
	
	@OPTIONS
	@CrossOrigin(origins="*")
	@RequestMapping("/API/bpm/loanApproval/process/retrieveProcessById/{processId}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerPOJO retrieveProcessById(@PathVariable ("processId") String processId) throws Exception {
		
		System.out.println("retrieveProcessById :: " + processId);
		
		CustomerPOJO customer = retrieveProcessByIdHelper(processId);
		

		
		System.out.println("retrieveProcessId completed");
		return customer;
	}
	
	public static CustomerPOJO retrieveProcessByIdHelper(String processId) throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpGet request = new HttpGet(
				"http://localhost:8080/rest/process-instance/" + processId + "/variables");		

		HttpResponse response = httpClient.execute(request);
		
		ObjectMapper objectMapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		DataVariablesPOJO data = objectMapper.readValue(response.getEntity().getContent(), DataVariablesPOJO.class);
		
		System.out.println(response);
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getClass());
		
		CustomerPOJO customer = new CustomerPOJO();
		customer.setAddress(data.getAddress().getValue());
		customer.setAge(Integer.parseInt(data.getAge().getValue()));
		customer.setCreditScore(Integer.parseInt(data.getCreditScore().getValue()));
		customer.setEmail(data.getEmail().getValue());
		customer.setFirstName(data.getFirstName().getValue());
		customer.setIncome(Integer.parseInt(data.getIncome().getValue()));
		customer.setLastName(data.getLastName().getValue());
		customer.setLoanAmount(Integer.parseInt(data.getLoanAmount().getValue()));
		customer.setSocialSecurityNumber(data.getSocialSecurityNumber().getValue());
		customer.setUserId(data.getUserId().getValue());
				
		return customer;
	}
	
	public static List<CamundaResponseAfterStartPOJO> retrieveProcessList(String businessKey) throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpGet request = new HttpGet(
				"http://localhost:8080/rest/process-instance?businessKey=" + businessKey);		

		HttpResponse response = httpClient.execute(request);
		
		ObjectMapper objectMapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		List<CamundaResponseAfterStartPOJO> camundaResponse = objectMapper.readValue(response.getEntity().getContent(), List.class);
		
		System.out.println(response);
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getClass());
		
		return camundaResponse;
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
		    //"\"loanApproved\": {\"value\": " + taskToComplete.isApproved() + "}}" +
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
					     " \"loanApproved\" :{\"value\":" + "\"" + true + "\"" + ", \"type\": \"boolean\"}," +
					     " \"loanAmount\" :{\"value\":" + "\"" + customer.getLoanAmount() + "\"" + ", \"type\": \"integer\"}" +
					  "}" + "," + 
					 " \"businessKey\" : " + customer.getSocialSecurityNumber() + "," +
					 " \"withVariablesInReturn\" : true" +
					"}";
					

		StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();

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
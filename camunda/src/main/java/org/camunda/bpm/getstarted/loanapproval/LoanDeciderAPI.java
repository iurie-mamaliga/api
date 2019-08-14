package org.camunda.bpm.getstarted.loanapproval;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

//import org.json.simple.JSONArray; 
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser; 

public class LoanDeciderAPI {
	public static StringBuilder sendLoanRequest(String userId, int creditScore) throws Exception {
		//String payload = "{\"userId\": \"123ID\", " + "\"creditScore\": \"800\"" + "}";
		String creditSc = Integer.toString(creditScore);
		String payload = "{\"userId\": \"" + userId + "\", " + "\"creditScore\": \"" + creditSc + "\"" + "}";

		// JSONParser parser = new JSONParser();
		// JSONObject json = (JSONObject) parser.parse(payload);

		StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(
				"http://drools-springboot-msk-sample.apps.us-west-2.online-starter.openshift.com/api/rules/loanApproval/getDecision");
		request.setEntity(entity);

		HttpResponse response = httpClient.execute(request);

		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

		StringBuilder content = new StringBuilder();
		String line;
		while (null != (line = br.readLine())) {
			content.append(line);
		}

		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(content);
		return content;
	}
}

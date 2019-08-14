package org.camunda.bpm.getstarted.loanapproval;

import java.util.Arrays;
import java.util.List;

//import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
//import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControl {

	@RequestMapping("/bpm/loanApproval/process/startProcess")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoanDecisionSummaryPOJO startLoanApplication(@RequestBody CustomerPOJO customer) throws Exception {
		System.out.println("Creating a person");

		LoanDecisionPOJO loanDecision = LoanDeciderAPI.sendLoanRequest(customer.getUserId(), customer.getCreditScore());

		LoanDecisionSummaryPOJO response = new LoanDecisionSummaryPOJO();
		response.setApr(loanDecision.getApr());
		response.setLoanDecision(loanDecision.getLoanDecision());
		response.setProcessId(loanDecision.getProcessId());
		System.out.println(response.getApr());
		System.out.println(response.getLoanDecision());
		System.out.println(response.getProcessId());
		return response;
	}

}

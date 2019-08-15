package org.camunda.bpm.getstarted.loanapproval;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class LoanDecisionSummaryPOJO {

	private String processId;
	private String loanDecision;
	private String apr;
	
	public LoanDecisionSummaryPOJO() {
		
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getLoanDecision() {
		return loanDecision;
	}

	public void setLoanDecision(String loanDecision) {
		this.loanDecision = loanDecision;
	}

	public String getApr() {
		return apr;
	}

	public void setApr(String apr) {
		this.apr = apr;
	}
	

}
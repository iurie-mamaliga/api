package org.camunda.bpm.getstarted.loanapproval;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import org.codehaus.jackson.annotate.JsonProperty;
@JsonInclude(Include.NON_EMPTY)
public class LoanDecisionPOJO {

	private String processId;
	private String loanDecision;
	private int apr;
	
	public LoanDecisionPOJO() {
		
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

	public int getApr() {
		return apr;
	}

	public void setApr(int apr) {
		this.apr = apr;
	}
	

}
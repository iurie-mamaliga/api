package org.camunda.bpm.getstarted.loanapproval;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import org.codehaus.jackson.annotate.JsonProperty;

@JsonInclude(Include.NON_EMPTY)
public class LoanDecisionPOJO {

		private String firstName;
		private String lastName;
		private String userId;
		private int SSN;
		private int age;
		private String address;
		private int income;
		private int loanAmount;
		private int creditScore;
		private String email;
		
		private String processId;
		private String loanDecision;
		private String apr;
		private String comments;

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public int getSSN() {
			return SSN;
		}

		public void setSSN(int sSN) {
			SSN = sSN;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getIncome() {
			return income;
		}

		public void setIncome(int income) {
			this.income = income;
		}

		public int getLoanAmount() {
			return loanAmount;
		}

		public void setLoanAmount(int loanAmount) {
			this.loanAmount = loanAmount;
		}

		public int getCreditScore() {
			return creditScore;
		}

		public void setCreditScore(int creditScore) {
			this.creditScore = creditScore;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
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

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public LoanDecisionPOJO() {

		}
	
	
}

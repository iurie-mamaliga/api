package org.camunda.bpm.getstarted.loanapproval;



	import com.fasterxml.jackson.annotation.JsonInclude;
	import com.fasterxml.jackson.annotation.JsonInclude.Include;

	@JsonInclude(Include.NON_EMPTY)
	public class LoanApplicationPOJO {

		private String firstName = "";
		private String lastName = "";
		private String userId = "";
		private String socialSecurityNumber = "";
		private int age = 0;
		private String address = "";
		private int income = 0;
		private int loanAmount = 0;
		private int creditScore = 0;
		private String email = "";
		private String processInstanceId = "";
		
		public String getProcessInstanceId() {
			return processInstanceId;
		}

		public void setProcessInstanceId(String processInstanceId) {
			this.processInstanceId = processInstanceId;
		}

		public LoanApplicationPOJO() {

		}

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

		public String getSocialSecurityNumber() {
			return socialSecurityNumber;
		}

		public void setSocialSecurityNumber(String socialSecurityNumber) {
			this.socialSecurityNumber = socialSecurityNumber;
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

	}


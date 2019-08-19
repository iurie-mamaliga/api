package org.camunda.bpm.getstarted.loanapproval;

public class DataVariablesPOJO {
	
	private DataFieldPOJO firstName;
	private DataFieldPOJO lastName;
	private DataFieldPOJO userId;
	private DataFieldPOJO socialSecurityNumber;
	private DataFieldPOJO age;
	private DataFieldPOJO address;
	private DataFieldPOJO income;
	private DataFieldPOJO loanAmount;
	private DataFieldPOJO creditScore;
	private DataFieldPOJO email;
	
	public DataFieldPOJO getFirstName() {
		return firstName;
	}
	public void setFirstName(DataFieldPOJO firstName) {
		this.firstName = firstName;
	}
	public DataFieldPOJO getLastName() {
		return lastName;
	}
	public void setLastName(DataFieldPOJO lastName) {
		this.lastName = lastName;
	}
	public DataFieldPOJO getUserId() {
		return userId;
	}
	public void setUserId(DataFieldPOJO userId) {
		this.userId = userId;
	}
	public DataFieldPOJO getSocialSecurityNumber() {		
		return socialSecurityNumber;
	}
	public void setSocialSecurityNumber(DataFieldPOJO socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public DataFieldPOJO getAge() {
		if(null == age) {
			age = new DataFieldPOJO();
			age.setValue("0");
		}
		return age;
	}
	public void setAge(DataFieldPOJO age) {
		this.age = age;
	}
	public DataFieldPOJO getAddress() {
		return address;
	}
	public void setAddress(DataFieldPOJO address) {
		this.address = address;
	}
	public DataFieldPOJO getIncome() {
		if(null == income) {
			income = new DataFieldPOJO();
			income.setValue("0");
		}
		return income;
	}
	public void setIncome(DataFieldPOJO income) {
		this.income = income;
	}
	public DataFieldPOJO getLoanAmount() {
		if(null == loanAmount) {
			loanAmount = new DataFieldPOJO();
			loanAmount.setValue("0");
		}
		return loanAmount;
	}
	public void setLoanAmount(DataFieldPOJO loanAmount) {
		this.loanAmount = loanAmount;
	}
	public DataFieldPOJO getCreditScore() {
		if(null == creditScore) {
			creditScore = new DataFieldPOJO();
			creditScore.setValue("0");
		}
		return creditScore;
	}
	public void setCreditScore(DataFieldPOJO creditScore) {
		this.creditScore = creditScore;
	}
	public DataFieldPOJO getEmail() {
		return email;
	}
	public void setEmail(DataFieldPOJO email) {
		this.email = email;
	}

}

package org.camunda.bpm.getstarted.loanapproval;

public class DataFieldPOJO {
	
	String type;
	String value;
	ValueInfoPOJO valueInfo;
	
	public ValueInfoPOJO getValueInfo() {
		return valueInfo;
	}
	public void setValueInfo(ValueInfoPOJO valueInfo) {
		this.valueInfo = valueInfo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {		
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}

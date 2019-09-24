package org.camunda.bpm.getstarted.loanapproval;

public class ProcessVariablesPOJO {

		 private String type;
		 private String value;
		 Object ValueInfo;
		 private String id;
		 private String name;
		 private String processInstanceId;
		 private String executionId;
		 private String caseInstanceId = null;
		 private String caseExecutionId = null;
		 private String taskId = null;
		 private String activityInstanceId;
		 private String errorMessage = null;
		 private String tenantId = null;


		 // Getter Methods 

		 public String getType() {
		  return type;
		 }

		 public String getValue() {
		  return value;
		 }

		 public Object getValueInfo() {
		  return ValueInfo;
		 }

		 public String getId() {
		  return id;
		 }

		 public String getName() {
		  return name;
		 }

		 public String getProcessInstanceId() {
		  return processInstanceId;
		 }

		 public String getExecutionId() {
		  return executionId;
		 }

		 public String getCaseInstanceId() {
		  return caseInstanceId;
		 }

		 public String getCaseExecutionId() {
		  return caseExecutionId;
		 }

		 public String getTaskId() {
		  return taskId;
		 }

		 public String getActivityInstanceId() {
		  return activityInstanceId;
		 }

		 public String getErrorMessage() {
		  return errorMessage;
		 }

		 public String getTenantId() {
		  return tenantId;
		 }

		 // Setter Methods 

		 public void setType(String type) {
		  this.type = type;
		 }

		 public void setValue(String value) {
		  this.value = value;
		 }

		 public void setValueInfo(Object valueInfo) {
		  this.ValueInfo = valueInfo;
		 }

		 public void setId(String id) {
		  this.id = id;
		 }

		 public void setName(String name) {
		  this.name = name;
		 }

		 public void setProcessInstanceId(String processInstanceId) {
		  this.processInstanceId = processInstanceId;
		 }

		 public void setExecutionId(String executionId) {
		  this.executionId = executionId;
		 }

		 public void setCaseInstanceId(String caseInstanceId) {
		  this.caseInstanceId = caseInstanceId;
		 }

		 public void setCaseExecutionId(String caseExecutionId) {
		  this.caseExecutionId = caseExecutionId;
		 }

		 public void setTaskId(String taskId) {
		  this.taskId = taskId;
		 }

		 public void setActivityInstanceId(String activityInstanceId) {
		  this.activityInstanceId = activityInstanceId;
		 }

		 public void setErrorMessage(String errorMessage) {
		  this.errorMessage = errorMessage;
		 }

		 public void setTenantId(String tenantId) {
		  this.tenantId = tenantId;
		 }
		}
		
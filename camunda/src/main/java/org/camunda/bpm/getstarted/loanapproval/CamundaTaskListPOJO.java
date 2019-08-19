package org.camunda.bpm.getstarted.loanapproval;

public class CamundaTaskListPOJO {
	private CamundaTaskInfoPOJO taskInfo[];

	public CamundaTaskInfoPOJO[] getTaskInfo() {
		return taskInfo;
	}

	public void setTaskInfo(CamundaTaskInfoPOJO[] taskInfo) {
		this.taskInfo = taskInfo;
	}
	
	
}

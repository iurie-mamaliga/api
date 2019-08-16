package org.camunda.bpm.getstarted.loanapproval;

import java.util.ArrayList;
import java.util.List;

public class ProcessListPOJO {
	
	private List<CamundaResponseAfterStartPOJO> processList;

	public List<CamundaResponseAfterStartPOJO> getProcessList() {
		if(null == processList)
			processList = new ArrayList<CamundaResponseAfterStartPOJO>();
		return processList;
	}

	public void setProcessList(List<CamundaResponseAfterStartPOJO> processList) {
		this.processList = processList;
	}

}

package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.util.logging.Logger;

public class LoggerDelegate2 implements JavaDelegate {
	
	private final Logger LOGGER2 = Logger.getLogger(LoggerDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		LOGGER2.info("\n\n   second 50% ...  LoggerDelegade invoked by "
				+ "processDefinitionId=" + execution.getProcessDefinitionId()
				+ ", activityId=" + execution.getCurrentActivityId()
				+ ", acitvityName" + execution.getCurrentActivityName()
				+ ", processInstanceId" + execution.getProcessInstanceId()
				+ ", business Key " + execution.getProcessBusinessKey()
				+ "executionId " + execution.getId()
				+ "\n\n");

	}

}

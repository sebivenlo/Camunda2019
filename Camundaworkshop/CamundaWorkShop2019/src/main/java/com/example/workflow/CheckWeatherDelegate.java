package com.example.workflow;

import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckWeatherDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		Random rando = new Random();
		
		execution.setVariable("name", "ozan");
		execution.setVariable("weatherOk", rando.nextBoolean());
	}

}

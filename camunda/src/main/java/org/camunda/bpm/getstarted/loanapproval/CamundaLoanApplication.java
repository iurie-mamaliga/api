package org.camunda.bpm.getstarted.loanapproval;


import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication
@ProcessApplication("Loan Approval App")
public class CamundaLoanApplication {

  public static void main(String[] args) {
    SpringApplication.run(CamundaLoanApplication.class, args);
  }
    
  @EventListener
  private void processPostDeploy(PostDeployEvent event) throws Exception {
	  System.out.println("Camunda server is running on http://localhost:8080/");
	  System.out.println("");
	  
  }

}
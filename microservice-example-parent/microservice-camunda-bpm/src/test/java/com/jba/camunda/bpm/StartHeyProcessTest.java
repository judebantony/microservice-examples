/**
 * 
 */
package com.jba.camunda.bpm;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareAssertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.complete;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.execute;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.job;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.runtimeService;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.task;
import static org.camunda.bpm.extension.mockito.DelegateExpressions.autoMock;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
import org.junit.Test;

/**
 * @author Jude
 *
 */
@Deployment(resources = "bpmn/judeTest.bpmn")
public class StartHeyProcessTest  extends AbstractProcessEngineRuleTest {

	  @Test
	  public void startAndFinishProcess() {
	    autoMock("bpmn/judeTest.bpmn");

	    final ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("judeTest");

	    assertThat(processInstance).isWaitingAt("UserTask_1");

	    complete(task());

	    assertThat(processInstance).isWaitingAt("ServiceTask_1");
	    execute(job());

	    assertThat(processInstance).isEnded();
	  }
	}
/**
 * 
 */
package com.jba.camunda.bpm.delegate;

import static org.slf4j.LoggerFactory.getLogger;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jude
 *
 */
@Component
public class StartCamundaProcess {
	private final Logger logger = getLogger(this.getClass());

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	private String processInstanceId;

	public void startProcess() {
		processInstanceId = runtimeService.startProcessInstanceByKey("judeTest").getProcessInstanceId();
		logger.info("started instance: {}", processInstanceId);

		Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		taskService.complete(task.getId());
		logger.info("completed task: {}", task);

	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}
}

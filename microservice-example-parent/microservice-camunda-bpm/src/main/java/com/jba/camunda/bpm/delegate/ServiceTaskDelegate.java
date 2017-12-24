/**
 * 
 */
package com.jba.camunda.bpm.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author Jude
 *
 */
@Component
public class ServiceTaskDelegate  implements JavaDelegate {

	  private final Logger logger = LoggerFactory.getLogger(this.getClass());

	  @Override
	  public void execute(DelegateExecution execution) throws Exception {
	    logger.info("executed ServiceTaskDelegate: {}", execution);
	  }

	}

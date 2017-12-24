/**
 * 
 */
package com.jba.camunda.bpm;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jba.camunda.bpm.starter.CamundaBPMStarter;

/**
 * @author Jude
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CamundaBPMStarter.class }, properties = {
    "com.jba.camunda.bpm.starter.CamundaBPMStarter.exitWhenFinished=false" })
public class CamundaBPMStarterTest {
	@Rule
	  public Timeout timeout = Timeout.seconds(5);

	  @Autowired
	  private CamundaBPMStarter application;

	  @Test
	  public void would_fail_if_process_not_completed_after_5_seconds() throws InterruptedException {
	    while (!application.processApplicationStopped && !application.isProcessInstanceFinished()) {
	      Thread.sleep(500L);
	    }
	  }
}

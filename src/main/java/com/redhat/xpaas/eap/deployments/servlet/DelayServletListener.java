package com.redhat.xpaas.eap.deployments.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Simulates a deployment delay
 * @author maschmid
 *
 */
@WebListener
public class DelayServletListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		String delayEnv = System.getenv("XPAAS_QE_DEPLOYMENT_DELAY");
		if (delayEnv != null && !delayEnv.trim().isEmpty()) {
			int delay = Integer.parseInt(delayEnv);
			
			try {
				Thread.sleep(1000 * delay);
			}
			catch (InterruptedException x) {
				// ignore
			}
		}
	}

}

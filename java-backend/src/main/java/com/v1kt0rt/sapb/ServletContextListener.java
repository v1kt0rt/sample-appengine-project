package com.v1kt0rt.sapb;

import javax.servlet.ServletContextEvent;

public class ServletContextListener implements javax.servlet.ServletContextListener {

	public static final String SL_ATTR_NAME = "ServiceLocator";

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		long t0 = System.currentTimeMillis();
		ServiceLocator sl = new ServiceLocator();
		sl.init();
		arg0.getServletContext().setAttribute(SL_ATTR_NAME, sl);
		long t1 = System.currentTimeMillis();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		ServiceLocator sl = (ServiceLocator) arg0.getServletContext().getAttribute(SL_ATTR_NAME);
		sl.destroy();
	}
}

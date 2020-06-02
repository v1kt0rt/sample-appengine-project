package com.v1kt0rt.sapb;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class ServiceLocator {

	private final UserService service = UserServiceFactory.getUserService();

	public void init() {
	}

	public void destroy() {
	}

	public String processCommand(String cmd) {
		if(cmd.startsWith("x")) {
			if(service.isUserAdmin()) {
				return "processed admin " + cmd;
			} else {
				return "forbidden";
			}
		} else {
			return "processed public " + cmd;
		}
	}
}

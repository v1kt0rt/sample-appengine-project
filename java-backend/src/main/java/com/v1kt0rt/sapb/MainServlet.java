package com.v1kt0rt.sapb;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class MainServlet extends HttpServlet {

	private ServiceLocator sl;

	@Override
	public void init(ServletConfig config) {
		sl = (ServiceLocator) config.getServletContext().getAttribute(ServletContextListener.SL_ATTR_NAME);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		writeResult(req, resp, "Hello World!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String body = new BufferedReader(new InputStreamReader(req.getInputStream(), StandardCharsets.UTF_8))
				.lines()
				.collect(Collectors.joining("\n"));
		writeResult(req, resp, sl.processCommand(body));
	}

	private void writeResult(HttpServletRequest req, HttpServletResponse resp, String response) throws IOException {
		try {
			Writer out = new OutputStreamWriter(resp.getOutputStream(), "utf-8");
			resp.setStatus(200);
			resp.setContentType("text/plain");
			out.write(response);
			out.close();
		} catch(UnsupportedEncodingException ex) {
			//Never happens. utf-8 is always supported.
		}
	}
}

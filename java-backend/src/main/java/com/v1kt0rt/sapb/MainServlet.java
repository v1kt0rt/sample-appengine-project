package com.v1kt0rt.sapb;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		writeResult(req, resp, "Hello World!");
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

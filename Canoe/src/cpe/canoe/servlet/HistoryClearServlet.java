package cpe.canoe.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpe.canoe.services.HistoryService;

public class HistoryClearServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3838552809233525146L;
	private HistoryService hService;
	
	public HistoryClearServlet() {
		hService = new HistoryService();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		hService.removeAll();
	}
	
	
}

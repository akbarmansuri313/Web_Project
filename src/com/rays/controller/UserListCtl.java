package com.rays.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserListCtl")

public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		List list = new ArrayList();

		try {
			list = model.search(bean);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();

		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String op = request.getParameter("operation");

		String[] ids = request.getParameterValues("ids");

		if (op.equals("delete")) {

			if (ids != null && ids.length > 0) {

				for (String id : ids) {

					bean.setId(Integer.parseInt(id));

					try {
						model.delete(bean);
						request.setAttribute("msg", "Data Delete successfully");
					} catch (Exception e) {

						e.printStackTrace();
					}
				}
			} else {
				request.setAttribute("msg", "Select one record");
			}
		}

		if (op.equals("search")) {
			bean.setFirstName(request.getParameter("firstname"));
			bean.setLastName(request.getParameter("lastname"));
			bean.setLoginId(request.getParameter("loginId"));
			try {
				bean.setDob(sdf.parse(request.getParameter("dob")));
			} catch (ParseException e1) {

				e1.printStackTrace();
			}

		}

		try {
			List list = model.search(bean);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);
	}
}

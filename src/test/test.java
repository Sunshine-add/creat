package test;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ISelectDao;
import dao.impl.SelectDao;
import util.IPUtil;

//测试类
public class test extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String ip1 = request.getParameter("title");
		ISelectDao selectDao = new SelectDao();
		
//		// 转换为long类型
//		long ipLong = IPUtil.ipToLong(ip1);
		selectDao.select(ip1);
		System.out.println(selectDao.select(ip1));
		
		//页面跳转
		response.sendRedirect("welcome.jsp");
	}
	
}

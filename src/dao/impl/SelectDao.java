package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojo.IPAndLocationPojo;
import util.DBUtil;
import dao.ISelectDao;

public class SelectDao implements ISelectDao{

	@Override
	public String select(String ipLong) {
		String Address=null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select Adress from fileinput where ? between StartIp and EndIp ";
			statement = connection.prepareStatement(sql);
			statement.setString(1, ipLong);
			
			rs = statement.executeQuery();
			while (rs.next()) {
				Address =rs.getString("Adress");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		
		return Address;
		
	}

}

package udn.ute.guitarshopda.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import udn.ute.guitarshopda.bo.LoaiSanPham;
import udn.ute.guitarshopda.dbconnection.ConnectionFactory;

public class LoaiSanPhamDAO {
	public static ArrayList<LoaiSanPham> getAllLoaiSP() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		ArrayList<LoaiSanPham> list = new ArrayList<LoaiSanPham>();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM LOAI");
			while (resultSet.next()) {
				list.add(convertToLoaiSP(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;

	}
	public static LoaiSanPham convertToLoaiSP(ResultSet rs) throws SQLException {
		LoaiSanPham loai = new LoaiSanPham();
		loai.setIdLoai(rs.getInt(1));
		loai.setTenLoai(rs.getString(2));
		return loai;
	}
}

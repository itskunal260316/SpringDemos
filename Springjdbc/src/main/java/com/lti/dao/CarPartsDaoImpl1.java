package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lti.entity.CarPartsDao;

@Component("carPartsDao1")
public class CarPartsDaoImpl1 implements CarPartsDao {

	/* (non-Javadoc)
	 * @see com.lti.dao.CarPartsDaoInterface#addNewPart(com.lti.dao.CarPart)
	 */
	@Override
	public void addNewPart(CarPart carPart) {

		Connection con = null;
		PreparedStatement ps = null; // pre compiled sql statement

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println("Connected....");

			ps = con.prepareStatement("insert into tbl_carparts values(?,?,?,?,?)");
			ps.setInt(1, carPart.getPartNo());
			ps.setString(2, carPart.getName());
			ps.setString(3, carPart.getCarModel());
			ps.setDouble(4, carPart.getPrice());
			ps.setInt(5, carPart.getQuantity());
			ps.executeUpdate();

			System.out.println("Data inserted");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {

				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	/* (non-Javadoc)
	 * @see com.lti.dao.CarPartsDaoInterface#getAvailableParts()
	 */
	@Override
	public List<CarPart> getAvailableParts() {

		Connection conn = null;
		PreparedStatement ps1 = null; // pre compiled sql statement
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println("Connected....");
			ps1 = conn.prepareStatement("select *from tbl_carparts");
			rs = ps1.executeQuery();

			List<CarPart> parts = new ArrayList<CarPart>();
			while (rs.next()) {

				CarPart part = new CarPart();
				part.setPartNo(rs.getInt(1));
				part.setName(rs.getString(2));
				part.setCarModel(rs.getString(3));
				part.setPrice(rs.getDouble(4));
				part.setQuantity(rs.getInt(5));
				parts.add(part);

			}
			return parts;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

}

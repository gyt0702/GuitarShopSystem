package eb.guitarshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import eb.guitarshop.bean.Guitar;
import eb.guitarshop.util.DBUtil;

public class DaoImpl implements IDao
{

	@Override

	public void addGuitar(Guitar g)
	{
		// TODO Auto-generated method stub
		String sql = "insert into guitar(serialNumber,price,builder,model,type,backWood,topWood)values(?,?,?,?,?,?,?)";
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g.getSerialNumber());
			pstmt.setDouble(2, g.getPrice());
			pstmt.setString(3, g.getBuilder());
			pstmt.setString(4, g.getModel());
			pstmt.setString(5, g.getType());
			pstmt.setString(6, g.getBackWood());
			pstmt.setString(7, g.getTopWood());

			pstmt.executeUpdate(); // 更新数据�?

		} catch (SQLException e)
		{
			// TODO 自动生成�? catch �?
			e.printStackTrace();
		} finally
		{
			util.closeConnection(conn);
		}

	}

	@Override
	public List<Guitar> getGuitar(String serialNumber)
	{
		// TODO Auto-generated method stub
		String sql = "select * from guitar where serialNumber=?";
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		List<Guitar> list = new ArrayList<Guitar>();
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serialNumber);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				// System.out.println("serialNumber = " + rs.getString(1));
				// System.out.println("price = " + rs.getDouble(2));
				// System.out.println("builder = " + rs.getString(3));
				// System.out.println("model = " + rs.getString(4));
				// System.out.println("type = " + rs.getString(5));
				// System.out.println("backWood = " + rs.getString(6));
				// System.out.println("toptWood = " + rs.getString(7));
				Double price = rs.getDouble(2);
				String builder = rs.getString(3);
				String model = rs.getString(4);
				String type = rs.getString(5);
				String backWood = rs.getString(6);
				String topWood = rs.getString(7);
				Guitar g = new Guitar();
				g.setSerialNumber(serialNumber);
				g.setPrice(price);
				g.setBuilder(builder);
				g.setModel(model);
				g.setType(type);
				g.setBackWood(backWood);
				g.setTopWood(topWood);
				list.add(g);
			}
			return list;
		} catch (SQLException e)
		{
			// TODO 自动生成�? catch �?
			e.printStackTrace();
		} finally
		{
			util.closeConnection(conn);
		}
		return null;
	}

	@Override
	public Guitar search(Guitar g)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Guitar> list()
	{
		String sql = "select * from guitar";
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		List<Guitar> list = new ArrayList<Guitar>();
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				String sn = rs.getString(1);
				Double price = rs.getDouble(2);
				String builder = rs.getString(3);
				String model = rs.getString(4);
				String type = rs.getString(5);
				String backWood = rs.getString(6);
				String topWood = rs.getString(7);

				Guitar g = new Guitar();
				g.setSerialNumber(sn);
				g.setPrice(price);
				g.setBuilder(builder);
				g.setModel(model);
				g.setType(type);
				g.setBackWood(backWood);
				g.setTopWood(topWood);

				list.add(g);
			}
			return list;
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}

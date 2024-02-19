package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.TeamUser;

public class TeamDao {

	//DB接続情報
	private final String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost/baseballdb";
	private final String USER = "root";
	private final String PASS = "root";
	
	//DB接続メソッド
	public Connection getConnection() throws SQLException{
		try {
			Class.forName(RDB_DRIVE);
			System.out.println("接続成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL,USER,PASS);
	}
	
	//ログイン情報検索メソッド
	public TeamUser check(String teamUsername,String teamPassword) {
		TeamUser tu = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM teaminfo WHERE teamUsername = ? AND teamPassword = ?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, teamUsername);
			ps.setString(2, teamPassword);
			rs = ps.executeQuery();
			if(rs.next()) {
				tu = new TeamUser();
				tu.setTeamUsername(rs.getString("teamUsername"));
				tu.setTeamPassword(rs.getString("teamPassword"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return tu;
	}
	
	//ログイン情報登録メソッド
	public void insert(TeamUser tu) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO teaminfo(teamUsername,teamPassword) VALUES(?,?)";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, tu.getTeamUsername());
			ps.setString(2, tu.getTeamPassword());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

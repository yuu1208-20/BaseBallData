package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.PlayerUser;

public class UserPlayerDao {

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
	
	//ログイン情報登録メソッド
	public void insert(PlayerUser pu) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO playerinfo(userPlayername,playerPassword) VALUES(?,?)";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pu.getUserPlayername());
			ps.setString(2, pu.getPlayerPassword());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
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
	
	//ログイン情報検索メソッド
	public PlayerUser check(String userPlayername, String playerPassword) {
	    PlayerUser pu = null;
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String sql = "SELECT * FROM playerinfo WHERE userPlayername = ? AND playerPassword = ?";
	    try {
	        con = getConnection();
	        ps = con.prepareStatement(sql);
	        ps.setString(1, userPlayername);
	        ps.setString(2, playerPassword);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            pu = new PlayerUser();
	            pu.setUserPlayername(rs.getString("userPlayername"));
	            pu.setPlayerPassword(rs.getString("playerPassword"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ps != null) {
	                ps.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return pu;
	}

}

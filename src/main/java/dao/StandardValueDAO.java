package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.StandardValue;

public class StandardValueDAO {
<<<<<<< HEAD
	private final String JDBC_URL = "jdbc:postgresql://localhost:5433/moderateDrinking";
=======
	private final String JDBC_URL = "jdbc:postgresql://localhost:5433/awesome";
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
	private final String DB_USER = "postgres";
	private final String DB_PASS = "password";
	
	public boolean signUp(int user_id) {
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
						
			String sqlInsert = "INSERT INTO standard_value VALUES (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sqlInsert);
			pStmt.setInt(1, user_id);
			pStmt.setDouble(2, 0);
			pStmt.setDouble(3, 0);
			
			int result = pStmt.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public StandardValue findStandard(int user_id) {
		StandardValue standardValue = null;

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備(user_idで検索)
			String sqlSelect = "SELECT * FROM standard_value WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sqlSelect);
			pStmt.setInt(1, user_id);

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) { //見つかった場合、各データを取得してStandardValueインスタンス生成
				double badValue = rs.getDouble("bad");
				double verybadValue = rs.getDouble("verybad");
				standardValue = new StandardValue(user_id, badValue, verybadValue);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		// 見つかったユーザーまたはnullを返す
		return standardValue;
	}

	public boolean updateStandard(StandardValue standardValue) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// UPDATE文を準備
			String sqlSelect = "UPDATE standard_value SET bad = ?, verybad = ? WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sqlSelect);
			pStmt.setDouble(1, standardValue.getBadValue());
			pStmt.setDouble(2, standardValue.getVerybadValue());
			pStmt.setInt(3, standardValue.getUser_id());

			//UPDATE実行
			int result = pStmt.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

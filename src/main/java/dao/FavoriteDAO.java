package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.FavoriteBeverage;

public class FavoriteDAO {
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
						
			String sqlInsert = "INSERT INTO favorite_beverages VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sqlInsert);
			pStmt.setInt(1, user_id);
			pStmt.setString(2, "ビール");
			pStmt.setDouble(3, 0.05);
			pStmt.setString(4, "ハイボール(1:4)");
			pStmt.setDouble(5, 0.08);
			pStmt.setString(6, "ハイボール(1:3)");
			pStmt.setDouble(7, 0.10);
			pStmt.setString(8, "ワイン");
			pStmt.setDouble(9, 0.12);
			pStmt.setString(10, "清酒");
			pStmt.setDouble(11, 0.15);
			
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
	
	public FavoriteBeverage extractFavorite(int user_id) {
		FavoriteBeverage favBev = null;

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備(user_idと本日の日付で検索)
			String sqlSelect = "SELECT * FROM favorite_beverages WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sqlSelect);

			pStmt.setInt(1, user_id);
			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) { //見つかった場合インスタンス生成
				favBev = new FavoriteBeverage(user_id,
						rs.getString("no1_bev_name"), rs.getDouble("no1_abv"),
						rs.getString("no2_bev_name"), rs.getDouble("no2_abv"),
						rs.getString("no3_bev_name"), rs.getDouble("no3_abv"),
						rs.getString("no4_bev_name"), rs.getDouble("no4_abv"),
						rs.getString("no5_bev_name"), rs.getDouble("no5_abv"));
			} else {
				return null;
			}
			rs.close();
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		// 見つかったユーザーまたはnullを返す
		return favBev;
	}
}

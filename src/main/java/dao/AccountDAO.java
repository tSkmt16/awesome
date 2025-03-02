package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
<<<<<<< HEAD
	private final String JDBC_URL = "jdbc:postgresql://localhost:5433/moderateDrinking";
=======
	private final String JDBC_URL = "jdbc:postgresql://localhost:5433/awesome";
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
	private final String DB_USER = "postgres";
	private final String DB_PASS = "password";

	public Account findByLogin(Login login) {
		Account account = null;

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT user_id, user_name,  password,  dob, gender,  admin FROM accounts WHERE user_name = ? AND password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUser_name());
			pStmt.setString(2, login.getPassword());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したユーザーが存在した場合
			// そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				// 結果表からデータを取得
				int user_id = rs.getInt("user_id");
				String user_name = rs.getString("user_name");
				String password = rs.getString("password");
				Date dob = rs.getDate("dob");
				int gender = rs.getInt("gender");
				int admin = rs.getInt("admin");
				account = new Account(user_id, user_name, password, dob, gender, admin);
			}
			//P303 ログイン失敗
			//	else {}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		// 見つかったユーザーまたはnullを返す
		return account;
	}

	public Account signUp(Account account) {
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
						
			String sqlInsert = "INSERT INTO accounts (user_name, password, dob, gender, admin) VALUES (?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sqlInsert);
			pStmt.setString(1, account.getUser_name());
			pStmt.setString(2, account.getPassword());
			pStmt.setDate(3, account.getDob());
			pStmt.setInt(4, account.getGender());
			pStmt.setInt(5, account.getAdmin());

			int result = pStmt.executeUpdate();
			if (result == 1) {
				// 連番で発行されたuser_idを取得
				String sqlSelect = "SELECT currval('accounts_user_id_seq')";
				pStmt = conn.prepareStatement(sqlSelect);
				ResultSet rs = pStmt.executeQuery();
				if (rs.next()) {
					int user_id=rs.getInt("currval");
					account = new Account(user_id,account.getUser_name(),
							account.getPassword(),account.getDob(),
							account.getGender(),account.getAdmin());
				}
				return account;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
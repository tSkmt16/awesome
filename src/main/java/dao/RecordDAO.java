package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Record;
import model.StandardValue;

public class RecordDAO {
<<<<<<< HEAD
	private final String JDBC_URL = "jdbc:postgresql://localhost:5433/moderateDrinking";
=======
	private final String JDBC_URL = "jdbc:postgresql://localhost:5433/awesome";
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
	private final String DB_USER = "postgres";
	private final String DB_PASS = "password";

	public Record findByRecord(int user_id) {
		Record record = null;

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// recordテーブル
			// SELECT文を準備(user_idと本日の日付で検索)
			String sqlSelect = "SELECT * FROM day_records WHERE user_id = ? AND date = ?";
			PreparedStatement pStmt = conn.prepareStatement(sqlSelect);

			pStmt.setInt(1, user_id);

			//本日の日付を取得
			LocalDateTime ldt = LocalDateTime.now();
			if (ldt.getHour() < 6) { //時刻が0～6時の場合は前日の日付にする
				ldt = ldt.minusDays(1);
			}
			Date today = java.sql.Date.valueOf(ldt.toLocalDate());

			pStmt.setDate(2, today);

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) { //見つかった場合、各データを取得してrecordインスタンス生成
				Date date = rs.getDate("date");
				double alcohol_intake = rs.getDouble("alcohol_intake");
				double liquid_intake = rs.getDouble("liquid_intake");
				int condition = rs.getInt("condition");
				record = new Record(user_id, date, alcohol_intake, liquid_intake, condition);
			} else { //見つからなかった場合INSERT
				String sqlInsert = "INSERT INTO day_records (user_id, date,alcohol_intake, liquid_intake) VALUES (?,?,?,?)";
				pStmt = conn.prepareStatement(sqlInsert);

				pStmt.setInt(1, user_id);
				pStmt.setDate(2, today);
				pStmt.setDouble(3, 0);
				pStmt.setDouble(4, 0);
				record = new Record(user_id, today, 0, 0);

				int result = pStmt.executeUpdate();
				if (result == 0) {
					return null;
				}
			}
			rs.close();
			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		// 見つかったユーザーまたはnullを返す
		return record;
	}

	public boolean updateRecord(Record record) {
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sqlUpdate = "UPDATE day_records SET alcohol_intake = ?, liquid_intake = ? WHERE user_id =? AND date= ?";
			PreparedStatement pStmt = conn.prepareStatement(sqlUpdate);
			pStmt.setDouble(1, record.getAlcohol_intake());
			pStmt.setDouble(2, record.getLiquid_intake());
			pStmt.setInt(3, record.getUser_id());
			pStmt.setDate(4, record.getDate());

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

	@SuppressWarnings("resource")
	public boolean updateCondition(Record record) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sqlSelect = "SELECT * FROM day_records WHERE user_id = ? AND date = ?";
			PreparedStatement pStmt = conn.prepareStatement(sqlSelect);

			pStmt.setInt(1, record.getUser_id());
			pStmt.setDate(2, record.getDate());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			int result = 0;

			if (rs.next()) { //見つかった場合conditionをupdate
				String sqlUpdate = "UPDATE day_records SET condition = ? WHERE user_id =? AND date=?";
				pStmt = conn.prepareStatement(sqlUpdate);

				pStmt.setInt(1, record.getCondition());
				pStmt.setInt(2, record.getUser_id());
				pStmt.setDate(3, record.getDate());
				result = pStmt.executeUpdate();

			} else { //見つからなかった場合INSERT(alcohol_intakeとliquid_intakeは「0」)
				String sqlInsert = "INSERT INTO day_records (user_id, date, alcohol_intake, liquid_intake, condition) VALUES (?,?,?,?,?)";
				pStmt = conn.prepareStatement(sqlInsert);

				pStmt.setInt(1, record.getUser_id());
				pStmt.setDate(2, record.getDate());
				pStmt.setDouble(3, 0);
				pStmt.setDouble(4, 0);
				pStmt.setInt(5, record.getCondition());
				result = pStmt.executeUpdate();
			}

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

	public Record extractRecord(Record record) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備(user_idと本日の日付で検索)
			String sqlSelect = "SELECT * FROM day_records WHERE user_id = ? AND date = ?";
			PreparedStatement pStmt = conn.prepareStatement(sqlSelect);

			pStmt.setInt(1, record.getUser_id());
			pStmt.setDate(2, record.getDate());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) { //見つかった場合、各データを取得してrecordインスタンス生成
				int user_id = rs.getInt("user_id");
				Date date = rs.getDate("date");
				double alcohol_intake = rs.getDouble("alcohol_intake");
				double liquid_intake = rs.getDouble("liquid_intake");
				int condition = rs.getInt("condition");
				record = new Record(user_id, date, alcohol_intake, liquid_intake, condition);
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
		return record;
	}

	@SuppressWarnings("resource")
	public boolean insertOrUpdateRecord(Record record) {
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sqlSelect = "SELECT * FROM day_records WHERE user_id = ? AND date = ?";
			PreparedStatement pStmt = conn.prepareStatement(sqlSelect);
			pStmt.setInt(1, record.getUser_id());
			pStmt.setDate(2, record.getDate());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) { //見つかった場合UPDATE
				String sqlUpdate = "UPDATE day_records SET alcohol_intake = ?, liquid_intake = ?,condition = ? WHERE user_id =? AND date= ?";
				pStmt = conn.prepareStatement(sqlUpdate);

				pStmt.setDouble(1, record.getAlcohol_intake());
				pStmt.setDouble(2, record.getLiquid_intake());
				if (record.getCondition() == 0) {
					pStmt.setNull(3, java.sql.Types.INTEGER);
				} else {
					pStmt.setInt(3, record.getCondition());
				}
				pStmt.setInt(4, record.getUser_id());
				pStmt.setDate(5, record.getDate());

				int result = pStmt.executeUpdate();
				if (result == 1) {
					return true;
				} else {
					return false;
				}
			} else { //見つからなかった場合INSERT
				String sqlInsert = "INSERT INTO day_records VALUES (?,?,?,?,?)";
				pStmt = conn.prepareStatement(sqlInsert);

				pStmt.setInt(1, record.getUser_id());
				pStmt.setDate(2, record.getDate());
				pStmt.setDouble(3, record.getAlcohol_intake());
				pStmt.setDouble(4, record.getLiquid_intake());
				if (record.getCondition() == 0) {
					pStmt.setNull(5, java.sql.Types.INTEGER);
				} else {
					pStmt.setInt(5, record.getCondition());
				}

				int result = pStmt.executeUpdate();

				if (result == 1) {
					return true;
				} else {
					return false;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Record findAvg(Record record) {
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// alcohol_intake
			// 平均値を求めるSELECT文
			String sqlSelect = "SELECT AVG(alcohol_intake) FROM day_records WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sqlSelect);
			pStmt.setInt(1, record.getUser_id());
			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			double avgAlcohol_intake;
			if (rs.next()) { // 見つかった場合、平均値を取得
				avgAlcohol_intake = rs.getDouble("avg");
			} else {
				avgAlcohol_intake = 0;
			}

			// liquid_intake
			// 平均値を求めるSELECT文
			sqlSelect = "SELECT AVG(liquid_intake) FROM day_records WHERE user_id = ?";
			pStmt = conn.prepareStatement(sqlSelect);
			pStmt.setInt(1, record.getUser_id());
			// SELECTを実行し、結果表を取得
			rs = pStmt.executeQuery();
			double avgLiquid_intake;
			if (rs.next()) { // 見つかった場合、平均値を取得
				avgLiquid_intake = rs.getDouble("avg");
			} else {
				avgLiquid_intake = 0;
			}

			record = new Record(record.getUser_id(), avgAlcohol_intake, avgLiquid_intake);
			return record;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public StandardValue standardValueCalc(int user_id) {
		StandardValue standardValue = null;

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// 体調「とてもわるい」のalcohol_intake平均値を取得
			String sqlSelect = "SELECT AVG(alcohol_intake) FROM day_records WHERE user_id = ? AND condition = 1";
			PreparedStatement pStmt = conn.prepareStatement(sqlSelect);
			pStmt.setInt(1, user_id);
			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			double verybad = 0;
			if (rs.next()) { // 見つかった場合、平均値を取得
				verybad = rs.getDouble("avg");
			}

			// 体調「わるい」のalcohol_intake平均値を取得
			sqlSelect = "SELECT AVG(alcohol_intake) FROM day_records WHERE user_id = ? AND condition = 2";
			pStmt = conn.prepareStatement(sqlSelect);
			pStmt.setInt(1, user_id);
			// SELECTを実行し、結果表を取得
			rs = pStmt.executeQuery();
			double bad = 0;
			if (rs.next()) { // 見つかった場合、平均値を取得
				bad = rs.getDouble("avg");
			}

			standardValue = new StandardValue(user_id, bad, verybad);
			return standardValue;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Record> forChart(int user_id,Date startDate,Date endDate) {

		List<Record> recordList = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sqlSelect = 
					"SELECT * FROM day_records "
					+ "WHERE user_id = ? AND date BETWEEN ? AND ? ORDER BY date";
			PreparedStatement pStmt = conn.prepareStatement(sqlSelect);
			pStmt.setInt(1, user_id);
			pStmt.setDate(2, startDate);
			pStmt.setDate(3, endDate);
			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Record record = new Record(user_id, rs.getDate("date"), rs.getDouble("alcohol_intake"),
						rs.getDouble("liquid_intake"), rs.getInt("condition"));
				recordList.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return recordList;
	}
}
import java.sql.*;

public class SignUpDAO {

	public boolean duplicationCheck(String ID) {

		Statement stmt = null;
		Connection conn = null;
		boolean find = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/swinformation?characterEncoding=UTF-8&serverTimezone=UTC", "root",
					"1209");
			stmt = conn.createStatement();

			String query = "select schoolid from signup";
			// rs = 입력된 id가 있는 위치
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String findId = rs.getString("schoolid");

				if (ID.equals(findId)) {

					find = true;

				}
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		if (find)
			return true;
		else
			return false;
	}

	public void SignUpMember(SignUpDTO member) {

		PreparedStatement pstmt = null;
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/swinformation?characterEncoding=UTF-8&serverTimezone=UTC", "root",
					"1209");

			// rs = 입력된 id가 있는 위치
			String query = "insert into signup(schoolid, name, pw) values('" + member.getSchoolID() + "','"
					+ member.getName() + "','" + member.getPW() + "')";
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}

	}

}

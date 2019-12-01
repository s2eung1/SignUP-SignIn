
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SignInDAO {

	public SignUpDTO isSignIn(String id, String pw) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/SWInformation?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "1209");
			stmt = conn.createStatement();
			
			String query = "SELECT * FROM SignUp"; //필요한 정보, 테이블이름 가져오기
			rs=stmt.executeQuery(query);
			

			
			while(rs.next()) {
				if(rs.getString("schoolid").equals(id)) 
				{					
					if(rs.getString("pw").equals(pw)) 
					{						
						SignUpDTO inform = new SignUpDTO(rs.getString("schoolid"),rs.getString("pw"),rs.getString("name"));
						return inform;
					}
				}
			}
		
		} catch (SQLException se1) {
			se1.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;

	}
}

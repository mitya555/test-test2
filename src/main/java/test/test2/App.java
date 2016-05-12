package test.test2;

//import java.sql.ResultSet;
//import java.sql.SQLException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;

public class App 
{
    private static AbstractApplicationContext context;

	public static void main( String[] args )
    {
        context = new ClassPathXmlApplicationContext("Beans.xml");

        Profile profile = (Profile) context.getBean("profile");

        profile.printAge();
        profile.printName();
        
        JdbcTemplate jdbc = (JdbcTemplate) context.getBean("jdbc");
        jdbc.query("SELECT table_name FROM information_schema.tables /*WHERE table_schema = ?*/;",
        		new Object[] {/*"%"*/},
        		(rs, rowNum) -> {
        			System.out.println(rowNum + ": " + rs.getString(1));
        			return null;
        		}
        		/*new RowMapper<Object>() {

					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						System.out.println(rowNum + ": " + rs.getString(1));
						return null;
					}
				}*/);
        
        context.registerShutdownHook();
    }
}

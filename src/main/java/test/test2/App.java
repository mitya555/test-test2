package test.test2;

import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;

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
        jdbc.query("SELECT * FROM information_schema.tables /*WHERE table_name = ?*/ /*WHERE table_schema = ?*/;",
        		new Object[] {/*"%"*//*"test"*/},
        		(rs, rowNum) -> {
        			System.out.println(rowNum + ": " +
//        					rs.getString("table_catalog") + "." + 
        					rs.getString("table_schema") + "." + 
        					rs.getString("table_name"));
        			String[] res = null;
        			if (rowNum == 0) {
        				ResultSetMetaData m = rs.getMetaData();
        				res = new String[m.getColumnCount()];
						for (int i = 1; i <= m.getColumnCount(); i++) {
							res[i - 1] = m.getColumnName(i) + ": " + m.getColumnTypeName(i);
						}
        			}
        			return res;
        		}
        		/*new RowMapper<Object>() {

					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						System.out.println(rowNum + ": " + rs.getString(1));
						return null;
					}
				}*/).stream().findFirst().ifPresent((String[] m) -> Arrays.stream(m).forEach(System.out::println));
        
        if (jdbc.queryForObject("select count(*) from information_schema.tables WHERE table_name = 'test'", int.class) == 0)
        	jdbc.execute("create table test ( id serial, name varchar(100), value int)");
        
        context.registerShutdownHook();
    }
}

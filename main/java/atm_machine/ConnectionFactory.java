package atm_machine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private static DataSource source = null;
	public static Connection getConnection() throws IOException, SQLException {
	if(source==null) {
	  Properties pr = new Properties();
	  FileInputStream fis = new FileInputStream(new File("C:\\Users\\Admin\\eclipse-workspace\\BookProject2\\src\\dbconfig.properties"));
      
  	pr.load(fis);
  	String url = pr.getProperty("db.url");
	String user = pr.getProperty("db.username");
	String psd = pr.getProperty("db.password");
	String driver = pr.getProperty("db.driver");
	HikariConfig config = new HikariConfig();
    
    config.setDriverClassName(driver);
    config.setJdbcUrl(url);
   
    config.setUsername(user);
    config.setPassword(psd);
  
    source = new HikariDataSource(config);
	}
	return source.getConnection();
	}


}

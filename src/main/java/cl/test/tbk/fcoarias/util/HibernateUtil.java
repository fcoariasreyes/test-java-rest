package cl.test.tbk.fcoarias.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HibernateUtil {
	private Session session;
	private Statement st;

	private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
	
	
	private HibernateUtil()  {
		
	}

	public static Session getSession() throws HibernateException, SQLException, ClassNotFoundException {
		logger.info("HIBERNATE opening connection...");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session  session = sessionFactory.openSession();
		logger.info("HIBERNATE Sesion is open :"+session.isOpen() + " is connected:"+session.isConnected());
		/*// Load the JDBC driver.
		Class.forName("org.hsqldb.jdbcDriver");
		logger.info("Hibernate driver open...");
		// Establish the connection to the database.
		String url = "jdbc:hsqldb:data/testdb";

		Connection conn = DriverManager.getConnection(url, "sa", "");
		logger.info("Hibernate open connection....");
		*/
		return session;
	}

	

}
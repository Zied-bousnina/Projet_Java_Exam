package Ma.project.Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexion {

	 private static String login = "root";
	    private static String password = "";
	    private static String url = "jdbc:mysql://localhost/hotel?zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8";
	    private static Connection cn;
	    static {
	        try {
	            //?tape 1 : Charger le driver de la base de donn?es
	            // cible
	            Class.forName("com.mysql.jdbc.Driver");
	            //?tape 2 : Authentification aupr?s de la base de donn?es
	            // et s?lectionner le sch?ma
	            cn = DriverManager.getConnection(url, login, password);
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Impossible de charger le driver");
	        } catch (SQLException ex) {
	            System.out.println("Erreur de connexion");
	        }
	    }
	 
	    public static Connection getCn() {
	        return cn;
	    }
	    

}

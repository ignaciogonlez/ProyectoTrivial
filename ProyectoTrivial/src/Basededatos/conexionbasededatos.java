package Basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;



public class conexionbasededatos {
		
	public static Connection inicioBD( String nombreBD ) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	
	
	/**Crea las tablas y devuelve el statment para trabajar con esta base de datos
	 * @param con Conexion creada ya anteriormente
	 * @return sentencia para trabajar/null si hay error
	 */
	public static Statement crearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  
			try {
				String stat = "create table if not exists Usuarios " +
						"(id integer primary key autoincrement" +	//Identificador del usuario
						"nombre varchar(40)" + 						//Nombre del usuario
						"password varchar(50)"+						//Clave del usuario
						");";
				statement.executeUpdate( stat );
				stat = "create table if not exists Sesiones " +
						"(id integer " +							//Clave externa del usuario
						"fecha varchar(10)"+						//Fecha de la sesion (cambiar a string con format)
						"NumSesiones integer"+						//Numero de sesiones del usuario
						");";
				statement.executeUpdate( stat );
				stat = "create table if not exits Preguntas " +
						"(Id integer primary key autoincrement" +	//Identificador de la pregunta
						"pregunta varchar (200)"+					//Pregunta
						");";
				statement.executeUpdate(stat);
				stat = "create table if not exits Respuestas " +
						"(id integer primary key autoincrement" +	//Identificador de la respuesta
						"(IdPregunta integer" +						//Clave externa de pregunta 
						" respuesta varchar(100)"+					//Respuesta
						"correcta varchar(10)"+						//Si la respuesta es la correcta
						");";
				statement.executeUpdate(stat);
				
			}catch (SQLException e) {} 
			return statement;
		}catch(SQLException e) {
			return null;
		}
	}
	/**
	 * Borra las tablas de la base de datos
	 * @param con Conexión creada
	 */
	public static void borrarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); 
			statement.executeUpdate("drop table if exists Usuarios");
			statement.executeUpdate("drop table if exists Preguntas");
		} catch (SQLException e) {
		}
	}
	
	/** Cierra la base de datos
	 * @param con Conexión creada
	 * @param st sentencia abierta
	 */
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
		} catch (SQLException e) {
		}
	}
	
	/**
	public static boolean insertarUsuarios( Statement st) {
		}
	public static boolean insertarPreguntas( Statement st) {
		}
	public static boolean updateValor( Statement st) {
	*/
	

}

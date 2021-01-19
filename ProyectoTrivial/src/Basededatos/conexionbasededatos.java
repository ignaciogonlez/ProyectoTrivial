package Basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;




public class conexionbasededatos {
		
	private Connection conn;
	private Statement stmt;
	
	public void inicioBD( String nombreBD ) {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			stmt = conn.createStatement();
			stmt.setQueryTimeout(30);  
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**Crea las tablas y devuelve el statment para trabajar con esta base de datos
	 * @param con Conexion creada ya anteriormente
	 * @return sentencia para trabajar/null si hay error
	 */
	public void crearTablasBD() {
		
		try {
			String stat = "create table if not exists Usuarios " +
					"(id integer primary key autoincrement" +	//Identificador del usuario
					"nombre varchar(40)" + 						//Nombre del usuario
					"password varchar(50)"+						//Clave del usuario	
					");";
				stmt.executeUpdate( stat );
				stat = "create table if not exists Sesiones " +
						"(id integer " +							//Clave externa del usuario
						"fecha varchar(10)"+						//Fecha de la sesion (cambiar a string con format)
						"NumSesiones integer"+						//Numero de sesiones del usuario
						");";
				stmt.executeUpdate( stat );
				stat = "create table if not exits Preguntas " +
						"(Id integer primary key autoincrement" +	//Identificador de la pregunta
						"pregunta varchar (100)"+					//Pregunta
						");";
				stmt.executeUpdate(stat);
				stat = "create table if not exits Respuestas " +
						"(id integer primary key autoincrement" +	//Identificador de la respuesta
						"(IdPregunta integer" +						//Clave externa de pregunta 
						" respuesta varchar(50)"+					//Respuesta
						"correcta varchar(10)"+						//Si la respuesta es la correcta
						");";
				stmt.executeUpdate(stat);
				
			
		}catch(SQLException e) {
			
		}
	}
	/**
	 * Borra las tablas de la base de datos
	 * @param con Conexión creada
	 */
	public void borrarBD() {
		try {
			stmt.executeUpdate("drop table if exists Usuarios");
			stmt.executeUpdate("drop table if exists Preguntas");
		} catch (SQLException e) {
		}
	}
	
	/** Cierra la base de datos
	 * @param con Conexión creada
	 * @param st sentencia abierta
	 */
	public void cerrarBD() {
		
		try {
			if (stmt!=null) stmt.close();
			if (conn!=null) conn.close();
		} catch (SQLException e) {
		}
	}
	
	
	public boolean insertarUsuarios(String usuario, String password) {
		String sentSQL = "";
		try {
			sentSQL = "insert into Tipo (nombre, valor, fechaUltModif) values (" +
					"'" + usuario + "', " +   
					"'" + password + "', " +
					")";
			stmt.executeUpdate( sentSQL );
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	/**
	public static boolean insertarPreguntas( Statement st) {
		}
	public static boolean updateValor( Statement st) {
	*/
	

}

package Basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import datos.Pregunta;
import datos.Respuesta;
import main.Main;
import main.Sistema;




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
					"(nombre varchar(40) primary key, " +	//Identificador del usuario						//Nombre del usuario
					"password varchar(50)"+						//Clave del usuario	
					");";
				stmt.executeUpdate( stat );
				stat = "create table if not exists Sesiones " +
						"(nombre varchar(40)," +							//Clave externa del usuario
						"fecha varchar(10) primary key"+							//Fecha de la sesion (cambiar a string con format)					//Numero de sesiones del usuario
						");";
				stmt.executeUpdate( stat );
				stat = "create table if not exists Preguntas " +
						"(Id integer primary key autoincrement," +	//Identificador de la pregunta
						"pregunta varchar (100)"+					//Pregunta
						");";
				stmt.executeUpdate(stat);
				stat = "create table if not exists Respuestas " +
						"(id integer primary key autoincrement," +	//Identificador de la respuesta
						"IdPregunta integer," +						//Clave externa de pregunta 
						" respuesta varchar(50),"+					//Respuesta
						"correcta varchar(10)"+						//Si la respuesta es la correcta
						");";
				stmt.executeUpdate(stat);
				
			System.out.println("Las tablas han sido creadas corretamente");
		}catch(SQLException e) {
			e.printStackTrace();
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
			sentSQL = "insert into Usuarios (nombre, password) values (" +
					"'" + usuario + "', " +   
					"'" + password + "', " +
					")";
			stmt.executeUpdate( sentSQL );
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean insertarPreguntas(ArrayList<Pregunta> preguntas) {
		String sentSQL = "";
		try {
			for (Pregunta preg : preguntas) {
				sentSQL = "insert into Preguntas (pregunta) values (" +
					"'" + preg.toString() + "'" +   
					");";
				stmt.executeUpdate( sentSQL );
				System.out.println("funciona");
			}
				return false;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public void insertarRespuestas(ArrayList<Pregunta> preguntas) {
		String sentSQL = "";
		try {
			int numero = 0;
			for (Pregunta preg : preguntas) {
				numero = numero+1;
				for(Respuesta res: preg.getListaRespuesta()) {
					
					sentSQL = "insert into Respuestas (IdPregunta,respuesta,correcta) values (" +
							"'" + numero + "'," + 
							"'" + res.toString() + "'," + 
							"'" + Boolean.toString(res.getCorrecta()) + "'" +   
							");";
						stmt.executeUpdate( sentSQL );
						
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public void verPreguntas() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM PREGUNTAS");
			while(rs.next()) {
				System.out.println(rs.getInt("Id"));
			}
			
			System.out.println("Las preguntas si");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void verRespuestas() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM RESPUESTAS");
			while(rs.next()) {
				System.out.println(rs.getInt("Id")+rs.getString("respuesta")+rs.getString("correcta")+ rs.getInt("IdPregunta"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void eliminar(){
		String sentSQL = "drop table Respuestas";
		try {
			stmt.executeUpdate(sentSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

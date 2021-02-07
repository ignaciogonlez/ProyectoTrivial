package Basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
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
	
	/**
	 * Metodo para insertar nuevos usuario en la BD
	 * @param usuario nombre del usuario
	 * @param password clave del usuario
	 * @return
	 */
	public boolean insertarUsuarios(String usuario, String password) {
		String sentSQL = "";
		try {
			sentSQL = "insert into Usuarios (nombre, password) values (" +
					"'" + usuario + "', " +   
					"'" + password + "'" +
					")";
			stmt.executeUpdate( sentSQL );
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	/**
	 * Metodo para añadir preguntas a través de un arrayList de preguntas a la tabla preguntas
	 * @param preguntas array de preguntas creado en la clase sistema 
	 * @return
	 */
	public void insertarPreguntas(ArrayList<Pregunta> preguntas) {
		String sentSQL = "";
		try {
			for (Pregunta preg : preguntas) {
				sentSQL = "insert into Preguntas (pregunta) values (" +
					"'" + preg.toString() + "'" +   
					");";
				stmt.executeUpdate( sentSQL );
				System.out.println("funciona");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para añadir respuestas a través de un arrayList de preguntas a la tabla preguntas
	 * @param preguntas preguntas array de preguntas creado en la clase sistema
	 */
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
	
	/**
	 * Metodo para visualizar preguntas en consola
	 */
	public void verPreguntas() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM PREGUNTAS");
			while(rs.next()) {
				System.out.println(rs.getInt("Id"));
			}
			
			System.out.println("Las preguntas si");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo para visualizar respuestas en consola
	 */
	public void verRespuestas() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM RESPUESTAS");
			while(rs.next()) {
				System.out.println(rs.getInt("Id")+rs.getString("respuesta")+rs.getString("correcta")+ rs.getInt("IdPregunta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para visualizar usuarios en consola
	 */
	public void verUusuarios() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIOS");
			while(rs.next()) {
				System.out.println(rs.getString("nombre"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para eliminar la tabla respuestas
	 */
	public void eliminar(){
		String sentSQL = "drop table Respuestas";
		try {
			stmt.executeUpdate(sentSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return Devuelve una pregunta aleatoria
	 * @throws SQLException
	 */
	public String preguntaAleatoria(int id) throws SQLException {
		String sentSQL = "select * from Preguntas where Id= "+ id;	
		ResultSet rs = stmt.executeQuery(sentSQL);
		return rs.getString("pregunta");
	}
	
	/**
	 * Devuelve las respuestas de la pregunta asociada
	 * @param id de la pregunta que tiene asociadas unas respuestas
	 * @return lista respuestas
	 * @throws SQLException
	 */
	public String[] respuestasPregunta(int id) throws SQLException {
		String[] listaRespuestas = new String[4];
		String sentSQL = "select respuesta from Respuestas where IdPregunta= "+ id;
		ResultSet rs = stmt.executeQuery(sentSQL);
		int numero = 0;
		while (rs.next()) {
			String respuesta = rs.getString("respuesta");
			listaRespuestas[numero]= respuesta;
			numero=numero+1;
		}
		return listaRespuestas;
	}
	
	/**
	 * método para comprobar si existe el usuario que se loggea en la bd
	 * @param nombre textField del nombre
	 * @param password textField del password
	 * @return correcto si está en la bd
	 * @throws SQLException
	 */
	public boolean inicioCorrecto(String nombre, String password) throws SQLException {
		boolean correcto= false;
		String sentSQL = "select * from Usuarios";
		ResultSet rs = stmt.executeQuery(sentSQL);
		while (rs.next()) {
			String nombre_bd = rs.getString("nombre");
			String password_bd = rs.getString("password");
			if(nombre_bd.equals(nombre)) {
				correcto = true;
			}
		}
		return correcto;
	}
	
}

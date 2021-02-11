package Basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import datos.Pregunta;
import datos.Respuesta;
import datos.Usuario;
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
					"password varchar(50), "+
					"puntuacion integer"+						//Clave del usuario	
					");";
				stmt.executeUpdate( stat );
				
				
				stat = "create table if not exists Amigos " +
						"(nombre varchar(40)," +							//Clave externa del usuario
						"amigo varchar(40)"+								//Nombre del amigo
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

				
				log( Level.INFO, "BD creación de tabla\t" + stat, null );
				
				System.out.println("Las tablas han sido creadas corretamente");
				
		}catch(SQLException e) {
			log( Level.SEVERE, "Error en creación de base de datos", e );
			System.out.println("no se han podido borrar");
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
			stmt.executeUpdate("drop table if exists Respuestas");
			
			log( Level.INFO, "Reiniciada base de datos", null );
			
		} catch (SQLException e) {
			
			log( Level.SEVERE, "Error en reinicio de base de datos", e );
			
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
			
			log( Level.INFO, "Cierre de base de datos", null );
			
		} catch (SQLException e) {
			
			log( Level.SEVERE, "Error en cierre de base de datos", e );
		}
	}
	
	/**
	 * Metodo para insertar nuevos usuario en la BD
	 * @param usuario nombre del usuario
	 * @param password clave del usuario
	 * @return
	 */
	public void insertarUsuarios(String usuario, String password) {
		String sentSQL = "";
		try {
			int iniciarPuntuacion = 0;
			sentSQL = "insert into Usuarios (nombre, password, puntuacion) values (" +
					"'" + usuario + "', " + 
					"'" + password + "', " +
					"'" + iniciarPuntuacion + "'" +
					")";
			stmt.executeUpdate( sentSQL );
			
		} catch (SQLException e) {
			e.printStackTrace();
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
				System.out.println(preg.toString());
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
	public void verUsuarios() {
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
	
	/**
	 * método para comprobar si existe el usuario que se loggea en la bd
	 * @param nombre textField del nombre
	 * @param lista lista de amigos del usuario actual para anyadirle el nuevo amigo
	 * @return true si se ha agregado correctamente
	 * @throws SQLException
	 */
	public boolean verificarUsuario(String nombre) throws SQLException {
		boolean correcto= false;
		String sentSQL = "select * from Usuarios";
		ResultSet rs = stmt.executeQuery(sentSQL);
		while (rs.next()) {
			String nombre_bd = rs.getString("nombre");
			if(nombre_bd.equals(nombre)) {
				correcto = true;
				break;
			}
		}
		return correcto;
	}
	
	public void updatePuntuacion(String nombreUsuario) throws SQLException {
		String sentSQL = "select puntuacion from Usuarios where nombre='" + nombreUsuario + "';";
		ResultSet res = stmt.executeQuery(sentSQL);
		int puntuacion=-1;
		while (res.next()) {
			puntuacion = res.getInt(puntuacion);
		}
		puntuacion++;
		sentSQL = "update Usuarios set"+
						"puntuacion=" + puntuacion + "where nombre='" + nombreUsuario + "';";
		stmt.executeUpdate( sentSQL );
	}
	
	public void volcarUsuarios(ArrayList<Usuario> lista) throws SQLException {
		String sentSQL = "select * from Usuarios;";
		ResultSet res = stmt.executeQuery(sentSQL);
		String nombre = "";
		String password = "";
		int puntuacion = -1;
		while (res.next()) {
			nombre = res.getString(nombre);
			password = res.getString(password);
			puntuacion = res.getInt(puntuacion);
			Usuario u = new Usuario(nombre, password, puntuacion);
			lista.add(u);
		}
	}
	
	public void insertarAmigo(String usuario, String amigo) throws SQLException {
		String sql = "select * from Amigos where nombre='" + usuario + "';";
		ResultSet res = stmt.executeQuery(sql);
		if(!(res.next())){
			String sentSQL = "insert into Amigos(nombre,amigo) values (" +
					"'" + usuario + "'," +
					"'" + amigo + "'" + 
					");";
			stmt.executeUpdate( sentSQL );
		}
		while (!(res.next())) {
			System.out.println("esta");
			String amigo_bd = res.getString("amigo");
			if(amigo_bd.equals(amigo)){
				System.out.println("Ya está");
			}else{
				String sentSQL = "insert into Amigos(nombre,amigo) values (" +
						"'" + usuario + "'," +
						"'" + amigo + "'" + 
						");";
				stmt.executeUpdate( sentSQL );
			}
		}
	}
	
	public ArrayList<String> listaNombreAmigos(String nombreUsuario) throws SQLException {
		ArrayList<String> listaAmigos = new ArrayList<String>();
		String sentSQL = "select * from Amigos where nombre='" + nombreUsuario + "';";
		ResultSet res = stmt.executeQuery(sentSQL);
		String amigo = "";
		while (res.next()) {
			amigo = res.getString("amigo");
			listaAmigos.add(amigo);
		}
		return listaAmigos;
	}
	
	public ArrayList<Usuario> listaUsuariosAmigos(String nombreUsuario) throws SQLException {
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		ArrayList<String> listaAmigos = new ArrayList<String>();
		String sentSQL = "select amigo from Usuarios where nombre='" + nombreUsuario + "';";
		ResultSet res = stmt.executeQuery(sentSQL);
		String amigo = "";
		while (res.next()) {
			amigo = res.getString(amigo);
			listaAmigos.add(amigo);
		}
		for(String a:listaAmigos) {
			sentSQL = "select * from Usuarios where nombre='" + amigo + "';";
			int puntuacion=-1;
			String password = "";
			while (res.next()) {
				puntuacion = res.getInt(puntuacion);
				password = res.getString(password);
				Usuario u = new Usuario(a,password,puntuacion);
				listaUsuarios.add(u);
			}
		}
		
		return listaUsuarios;
	}
	
	
	//logging
	
	private static Logger logger = null;
	
	private static void log(Level level, String msg, Throwable excepcion) {
		if (logger==null) {  
			logger = Logger.getLogger( conexionbasededatos.class.getName() );  
			logger.setLevel( Level.ALL ); 
		}
		if (excepcion==null) {
			logger.log( level, msg );
		}else {
			logger.log( level, msg, excepcion );
		}
	}
}


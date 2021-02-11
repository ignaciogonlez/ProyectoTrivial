package datos;
/**
 * Objeto "respuesta" que se iran realizando durante el juego para facilitar la gestión de datos con la bd
 * @author luissuarezcuartas
 *
 */
public class Respuesta {
		
		String respuesta;
		Boolean correcta;
		public Respuesta(String respuesta, Boolean correcta) {
			this.respuesta=respuesta;
			this.correcta=correcta;
		}
		public String getRespuesta() {
			return respuesta;
		}
		public Boolean getCorrecta() {
			return correcta;
		}
		public String toString() {
			return respuesta;
		}
}
package datos;

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

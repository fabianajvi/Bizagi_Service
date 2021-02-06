package co.com.santander.bizagi.util;

public enum MessageApi {

	STATUS_OK(Constants.STATUS_OK), LABELS_ERROR(Constants.LABELS_ERROR), CONNECT_TIMEOUT(Constants.CONNECT_TIMEOUT), 
	NOT_FOUND(Constants.NOT_FOUND); 
	
	private MessageApi(String label) {}
	
	public static class Constants {
		
		public static final String STATUS_OK = "Operación Exitosa";
		public static final String LABELS_ERROR = "{Error de consumo}, {Error en campos}";
		public static final String CONNECT_TIMEOUT = "connect timed out";
		public static final String NOT_FOUND = "Not Found";
		public static final String ERROR_SERVICE = "Ocurrio un error al consumir el servicio de bizagi";
	}
}

package exercicio.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * Formato: dd/MM/yyyy
	 */
	public static final String FORMAT_DD_MM_YYYY = "dd/MM/yyyy";
	
	public static String format(Date date, String format) {
		
		return new SimpleDateFormat(format).format(date);
	}
	
}

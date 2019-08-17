package br.com.acc.slc.resources.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe de utilidades para o tipo String
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 17 de ago de 2019 |
 *         10:27:28
 */
public class StringUtils {

    public static boolean validarTextoString(String string) {
	if (string == null || "".equals(string.trim())) {
	    return false;
	} else {
	    return true;
	}
    }

    public static String converterCalendarEmStringCompleto(Calendar calendar) {
	if (calendar == null) {
	    return "00/00/0000 00:00:00";
	} else {
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date(calendar.getTimeInMillis());
	    return simpleDateFormat.format(date);
	}
    }

    public static String converterCalendarEmStringSomenteHoras(Calendar calendar) {
	if (calendar == null) {
	    return "00:00:00";
	} else {
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	    Date date = new Date(calendar.getTimeInMillis());
	    return simpleDateFormat.format(date);
	}
    }

    public static String converterCalendarEmStringSomenteData(Calendar calendar) {
	if (calendar == null) {
	    return "00/00/0000";
	} else {
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = new Date(calendar.getTimeInMillis());
	    return simpleDateFormat.format(date);
	}
    }
}

package br.com.acc.slc.resources.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe de utilidade para o tipo Calendar
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 17 de ago de 2019 |
 *         10:55:20
 */
public class CalendarUtils {

    public static Calendar converterStringEmCalendar(String string) throws ParseException {

	if (string == null) {
	    Calendar calendar = Calendar.getInstance();
	    return calendar;
	} else {
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = simpleDateFormat.parse(string);
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    return calendar;
	}

    }

    public static Calendar converterDateEmCalendar(Date date) {
	if (date == null) {
	    Calendar calendar = Calendar.getInstance();
	    return calendar;
	} else {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    return calendar;
	}
    }

    public static Calendar somarMinutos(Integer minutosAMais, Calendar calendar) {
	Integer minutos = calendar.get(Calendar.MINUTE);
	minutos = minutos + minutosAMais;
	Calendar novoCalendar = Calendar.getInstance();
	novoCalendar.setTime(calendar.getTime());
	novoCalendar.set(Calendar.MINUTE, minutos);

	return novoCalendar;
    }

    public static Calendar subtrairMinutos(Integer minutosAMenos, Calendar calendar) {
	Integer minutos = calendar.get(Calendar.MINUTE);
	minutos = minutos - minutosAMenos;
	Calendar novoCalendar = Calendar.getInstance();
	novoCalendar.setTime(calendar.getTime());
	novoCalendar.set(Calendar.MINUTE, minutos);

	return novoCalendar;
    }

    public static Calendar somarHoras(Integer horasAMais, Calendar calendar) {
	Integer horas = calendar.get(Calendar.HOUR_OF_DAY);
	horas = horas + horasAMais;
	Calendar novoCalendar = Calendar.getInstance();
	novoCalendar.setTime(calendar.getTime());
	novoCalendar.set(Calendar.HOUR_OF_DAY, horas);

	return novoCalendar;
    }

    public static Calendar subtrairHoras(Integer horasAMenos, Calendar calendar) {
	Integer horas = calendar.get(Calendar.HOUR_OF_DAY);
	horas = horas - horasAMenos;
	Calendar novoCalendar = Calendar.getInstance();
	novoCalendar.setTime(calendar.getTime());
	novoCalendar.set(Calendar.HOUR_OF_DAY, horas);

	return novoCalendar;
    }

    public static Calendar somarDias(Integer diasAMais, Calendar calendar) {
	Integer dias = calendar.get(Calendar.DAY_OF_MONTH);
	dias = dias + diasAMais;
	Calendar novoCalendar = Calendar.getInstance();
	novoCalendar.setTime(calendar.getTime());
	novoCalendar.set(Calendar.DAY_OF_MONTH, dias);

	return novoCalendar;
    }

    public static Calendar subtrairDias(Integer diasAMenos, Calendar calendar) {
	Integer dias = calendar.get(Calendar.DAY_OF_MONTH);
	dias = dias - diasAMenos;
	Calendar novoCalendar = Calendar.getInstance();
	novoCalendar.setTime(calendar.getTime());
	novoCalendar.set(Calendar.DAY_OF_MONTH, dias);

	return novoCalendar;
    }

    public static Calendar somarMeses(Integer mesesAMais, Calendar calendar) {
	Integer meses = calendar.get(Calendar.MONTH);
	meses = meses + mesesAMais;
	Calendar novoCalendar = Calendar.getInstance();
	novoCalendar.setTime(calendar.getTime());
	novoCalendar.set(Calendar.MONTH, meses);

	return novoCalendar;
    }

    public static Calendar subtrairMeses(Integer mesesAMenos, Calendar calendar) {
	Integer meses = calendar.get(Calendar.MONTH);
	meses = meses - mesesAMenos;
	Calendar novoCalendar = Calendar.getInstance();
	novoCalendar.setTime(calendar.getTime());
	novoCalendar.set(Calendar.MONTH, meses);

	return novoCalendar;
    }

    public static Calendar somarAnos(Integer anosAMais, Calendar calendar) {
	Integer anos = calendar.get(Calendar.YEAR);
	anos = anos + anosAMais;
	Calendar novoCalendar = Calendar.getInstance();
	novoCalendar.setTime(calendar.getTime());
	novoCalendar.set(Calendar.YEAR, anos);

	return novoCalendar;
    }

    public static Calendar subtrairAnos(Integer anosAMenos, Calendar calendar) {
	Integer anos = calendar.get(Calendar.YEAR);
	anos = anos - anosAMenos;
	Calendar novoCalendar = Calendar.getInstance();
	novoCalendar.setTime(calendar.getTime());
	novoCalendar.set(Calendar.YEAR, anos);

	return novoCalendar;
    }

}

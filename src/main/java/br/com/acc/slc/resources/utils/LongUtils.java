package br.com.acc.slc.resources.utils;

/**
 * Classe de utilidades para o tipo Long
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 17 de ago de 2019 |
 *         10:23:12
 */
public class LongUtils {

    public static boolean validarIdLong(Long _long) {
	if (_long == null || _long <= 0) {
	    return false;
	} else {
	    return true;
	}
    }
}

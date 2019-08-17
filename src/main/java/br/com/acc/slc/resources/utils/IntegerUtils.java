package br.com.acc.slc.resources.utils;

/**
 * Classe de utilidades para o tipo Integer
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 17 de ago de 2019 |
 *         10:22:30
 */
public class IntegerUtils {

    public static boolean validarIdInteger(Integer integer) {
	if (integer == null || integer <= 0) {
	    return false;
	} else {
	    return true;
	}
    }
}

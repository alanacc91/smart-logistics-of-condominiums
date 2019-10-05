package br.com.acc.slc.service.validations;

import java.util.List;

import br.com.acc.slc.resources.utils.IntegerUtils;
import br.com.acc.slc.vo.Nivel2;

public class Nivel2Validator {
    public static boolean nivel2NaoPossuirNumero(Nivel2 nivel2) {
	if (nivel2 == null || nivel2.getNumero() == null || "".equals(nivel2.getNumero().trim())) {
	    return true;
	}
	return false;
    }

    public static boolean listaDeNivel2TemItens(List<Nivel2> listaDeNiveis2) {
	if (listaDeNiveis2 == null || listaDeNiveis2.isEmpty() || listaDeNiveis2.get(0) == null || !IntegerUtils.validarIdInteger(listaDeNiveis2.get(0).getId())) {
	    return false;
	}
	return true;
    }
}

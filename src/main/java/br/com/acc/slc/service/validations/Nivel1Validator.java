package br.com.acc.slc.service.validations;

import java.util.List;

import br.com.acc.slc.resources.utils.IntegerUtils;
import br.com.acc.slc.vo.Nivel1;

public class Nivel1Validator {
    public static boolean nivel1NaoPossuirNome(Nivel1 nivel1) {
	if (nivel1 == null || nivel1.getNome() == null || "".equals(nivel1.getNome().trim())) {
	    return true;
	}
	return false;
    }

    public static boolean listaDeNivel1TemItens(List<Nivel1> listaDeNivel1) {
	if (listaDeNivel1 == null || listaDeNivel1.isEmpty() || listaDeNivel1.get(0) == null || !IntegerUtils.validarIdInteger(listaDeNivel1.get(0).getId())) {
	    return false;
	}
	return true;
    }
}

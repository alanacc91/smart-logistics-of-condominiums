package br.com.acc.slc.service.validations;

import br.com.acc.slc.vo.Configuracao;

public class ConfiguracaoValidator {
    public static boolean tipoDeCondominioForVertical(Configuracao configuracao) {
	if (configuracao == null || configuracao.getValor() == null || "VERTICAL".equals(configuracao.getValor())) {
	    return true;
	}
	return false;
    }
}

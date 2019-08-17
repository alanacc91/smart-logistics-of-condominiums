package br.com.acc.slc.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.acc.slc.repository.INivel2Repository;
import br.com.acc.slc.resources.exceptions.DataIntegrityException;
import br.com.acc.slc.resources.exceptions.ObjectNotFoundException;
import br.com.acc.slc.service.INivel2Service;
import br.com.acc.slc.vo.Nivel2;

/**
 * Classe responsavel pela camada de negocios da entidade Nivel2
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 15 de ago de 2019 |
 *         19:39:15
 */
@Service
public class Nivel2Service implements INivel2Service {

    @Autowired
    INivel2Repository nivel2Repository;

    public Page<Nivel2> selecionarNiveis2Paginados(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao) {
	return nivel2Repository.selecionarNiveis2Paginados(pagina, linhasPorPagina, ordernacao, direcao);
    }

    public Nivel2 selecionarNivel2PorId(Integer id) {
	Optional<Nivel2> nivel2 = nivel2Repository.selecionarNivel2PorId(id);
	return nivel2.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Nivel2.class.getName()));
    }

    public Nivel2 inserirNivel2(Nivel2 nivel2) {
	return nivel2Repository.inserirNivel2(nivel2);
    }

    public Nivel2 atualizarNivel2(Nivel2 nivel2) {
	return nivel2Repository.atualizarNivel2(nivel2);
    }

    public void deletarNivel2(Integer id) {
	try {
	    nivel2Repository.deletarNivel2(id);
	} catch (DataIntegrityViolationException e) {
	    throw new DataIntegrityException("Falha ao deletar Nivel2!");
	}

    }

}

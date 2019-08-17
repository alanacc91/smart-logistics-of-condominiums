package br.com.acc.slc.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.acc.slc.repository.INivel1Repository;
import br.com.acc.slc.resources.exceptions.DataIntegrityException;
import br.com.acc.slc.resources.exceptions.ObjectNotFoundException;
import br.com.acc.slc.service.INivel1Service;
import br.com.acc.slc.vo.Nivel1;

/**
 * Classe responsavel pela camada de negocios da entidade Nivel1
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 15 de ago de 2019 |
 *         19:39:15
 */
@Service
public class Nivel1Service implements INivel1Service {

    @Autowired
    INivel1Repository nivel1Repository;

    public Page<Nivel1> selecionarNiveis1Paginados(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao) {
	return nivel1Repository.selecionarNiveis1Paginados(pagina, linhasPorPagina, ordernacao, direcao);
    }

    public Nivel1 selecionarNivel1PorId(Integer id) {
	Optional<Nivel1> nivel1 = nivel1Repository.selecionarNivel1PorId(id);
	return nivel1.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Nivel1.class.getName()));
    }

    public Nivel1 inserirNivel1(Nivel1 nivel1) {
	return nivel1Repository.inserirNivel1(nivel1);
    }

    public Nivel1 atualizarNivel1(Nivel1 nivel1) {
	return nivel1Repository.atualizarNivel1(nivel1);
    }

    public void deletarNivel1(Integer id) {
	try {
	    nivel1Repository.deletarNivel1(id);
	} catch (DataIntegrityViolationException e) {
	    throw new DataIntegrityException("Falha ao deletar Nivel1!");
	}

    }

}

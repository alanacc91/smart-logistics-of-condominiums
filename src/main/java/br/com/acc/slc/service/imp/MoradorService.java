package br.com.acc.slc.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.acc.slc.repository.IMoradorRepository;
import br.com.acc.slc.resources.exceptions.DataIntegrityException;
import br.com.acc.slc.resources.exceptions.ObjectNotFoundException;
import br.com.acc.slc.service.IMoradorService;
import br.com.acc.slc.vo.Morador;

/**
 * Classe responsavel pela camada de negocios da entidade Morador
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 15 de ago de 2019 |
 *         19:39:15
 */
@Service
public class MoradorService implements IMoradorService {

    @Autowired
    IMoradorRepository moradorRepository;

    public Page<Morador> selecionarMoradoresPaginados(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao) {
	return moradorRepository.selecionarMoradoresPaginados(pagina, linhasPorPagina, ordernacao, direcao);
    }

    public Morador selecionarMoradorPorId(Integer id) {
	Optional<Morador> morador = moradorRepository.selecionarMoradorPorId(id);
	return morador.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Morador.class.getName()));
    }

    public Morador inserirMorador(Morador morador) {
	return moradorRepository.inserirMorador(morador);
    }

    public Morador atualizarMorador(Morador morador) {
	return moradorRepository.atualizarMorador(morador);
    }

    public void deletarMorador(Integer id) {
	try {
	    moradorRepository.deletarMorador(id);
	} catch (DataIntegrityViolationException e) {
	    throw new DataIntegrityException("Falha ao deletar Morador!");
	}

    }

}

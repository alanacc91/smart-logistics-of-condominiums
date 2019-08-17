package br.com.acc.slc.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.acc.slc.repository.IAreaComumRepository;
import br.com.acc.slc.resources.exceptions.DataIntegrityException;
import br.com.acc.slc.resources.exceptions.ObjectNotFoundException;
import br.com.acc.slc.service.IAreaComumService;
import br.com.acc.slc.vo.AreaComum;

/**
 * Classe responsavel pela camada de negocios da entidade AreaComum
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 15 de ago de 2019 |
 *         19:39:15
 */
@Service
public class AreaComumService implements IAreaComumService {

    @Autowired
    IAreaComumRepository areaComumRepository;

    public Page<AreaComum> selecionarAreasComumPaginadas(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao) {
	return areaComumRepository.selecionarAreasComumPaginadas(pagina, linhasPorPagina, ordernacao, direcao);
    }

    public AreaComum selecionarAreaComumPorId(Integer id) {
	Optional<AreaComum> areaComum = areaComumRepository.selecionarAreaComumPorId(id);
	return areaComum.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + AreaComum.class.getName()));
    }

    public AreaComum inserirAreaComum(AreaComum areaComum) {
	return areaComumRepository.inserirAreaComum(areaComum);
    }

    public AreaComum atualizarAreaComum(AreaComum areaComum) {
	return areaComumRepository.atualizarAreaComum(areaComum);
    }

    public void deletarAreaComum(Integer id) {
	try {
	    areaComumRepository.deletarAreaComum(id);
	} catch (DataIntegrityViolationException e) {
	    throw new DataIntegrityException("Falha ao deletar AreaComum!");
	}

    }

}

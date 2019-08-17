package br.com.acc.slc.repository.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import br.com.acc.slc.repository.IAreaComumRepository;
import br.com.acc.slc.repository.jpa.IAreaComumJPARepository;
import br.com.acc.slc.vo.AreaComum;

/**
 * Classe responsavel pela persistencia da entidade AreaComum
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 13 de ago de 2019 |
 *         19:45:41
 */
@Repository
public class AreaComumRepository implements IAreaComumRepository {

    @Autowired
    IAreaComumJPARepository areaComumRepository;

    public Page<AreaComum> selecionarAreasComumPaginadas(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao) {

	PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordernacao);
	return areaComumRepository.findAll(pageRequest);
    }

    public Optional<AreaComum> selecionarAreaComumPorId(Integer id) {
	return areaComumRepository.findById(id);
    }

    public AreaComum inserirAreaComum(AreaComum areaComum) {
	areaComum.setId(null);
	return areaComumRepository.save(areaComum);
    }

    public AreaComum atualizarAreaComum(AreaComum areaComum) {
	return areaComumRepository.save(areaComum);
    }

    public void deletarAreaComum(Integer id) {
	areaComumRepository.deleteById(id);
    }

}

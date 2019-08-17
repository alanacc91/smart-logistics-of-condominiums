package br.com.acc.slc.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.acc.slc.vo.AreaComum;

/**
 * Interface responsavel pela persistencia da entidade AreaComum
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de ago de 2019 |
 *         20:27:43
 */
public interface IAreaComumRepository {

    Page<AreaComum> selecionarAreasComumPaginadas(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao);

    Optional<AreaComum> selecionarAreaComumPorId(Integer id);

    AreaComum inserirAreaComum(AreaComum areaComum);

    AreaComum atualizarAreaComum(AreaComum areaComum);

    void deletarAreaComum(Integer id);

}

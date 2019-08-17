package br.com.acc.slc.service;

import org.springframework.data.domain.Page;

import br.com.acc.slc.vo.AreaComum;

/**
 * Interface responsavel pela camada de negocios da entidade AreaComum
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 13 de ago de 2019 |
 *         19:59:51
 */
public interface IAreaComumService {

    /**
     * Metodo reponsavel por selecionar todas as areas comuns paginadas
     * 
     * @param pagina          numero da pagina
     * @param linhasPorPagina quantidade de registros por pagina
     * @param ordernacao      ordenacao da busca
     * @param direcao         ordenacao crescente ou decrescente
     * @return areas comuns paginadas
     */
    Page<AreaComum> selecionarAreasComumPaginadas(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao);

    /**
     * Metodo reponsavel por selecionar uma area comum pelo seu ID
     * 
     * @param id ID da area comum a ser selecionada
     * @return area comum selecionada
     */
    AreaComum selecionarAreaComumPorId(Integer id);

    /**
     * Metodo reponsavel por inserir uma area comum
     * 
     * @param areaComum a comum a ser inserida
     * @return area comum inserida
     */
    AreaComum inserirAreaComum(AreaComum areaComum);

    /**
     * Metodo responsavel por atualizar uma area comum
     * 
     * @param areaComum area comum a ser atualizada
     * @return area comum atualizada
     */
    AreaComum atualizarAreaComum(AreaComum areaComum);

    /**
     * Metodo reponsavel por deletar uma area comum
     * 
     * @param id ID da area comum a ser deletada
     */
    void deletarAreaComum(Integer id);

}

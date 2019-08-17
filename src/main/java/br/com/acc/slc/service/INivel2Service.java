package br.com.acc.slc.service;

import org.springframework.data.domain.Page;

import br.com.acc.slc.vo.Nivel2;

/**
 * Interface responsavel pela camada de negocios da entidade Nivel2
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 13 de ago de 2019 |
 *         19:59:51
 */
public interface INivel2Service {

    /**
     * Metodo reponsavel por selecionar todos os niveis2 paginados
     * 
     * @param pagina          numero da pagina
     * @param linhasPorPagina quantidade de registros por pagina
     * @param ordernacao      ordenacao da busca
     * @param direcao         ordenacao crescente ou decrescente
     * @return niveis2 paginados
     */
    Page<Nivel2> selecionarNiveis2Paginados(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao);

    /**
     * Metodo reponsavel por selecionar um nivel2 pelo seu ID
     * 
     * @param id ID do nivel2 a ser selecionado
     * @return nivel2 selecionado
     */
    Nivel2 selecionarNivel2PorId(Integer id);

    /**
     * Metodo reponsavel por inserir um nivel2
     * 
     * @param nivel2 a ser inserido
     * @return nivel2 inserido
     */
    Nivel2 inserirNivel2(Nivel2 nivel2);

    /**
     * Metodo responsavel por atualizar um nivel2
     * 
     * @param nivel2 nivel2 a ser atualizado
     * @return nivel2 atualizado
     */
    Nivel2 atualizarNivel2(Nivel2 nivel2);

    /**
     * Metodo reponsavel por deletar um nivel2
     * 
     * @param id ID do nivel2 a ser deletado
     */
    void deletarNivel2(Integer id);

}

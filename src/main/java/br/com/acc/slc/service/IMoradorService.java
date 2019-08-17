package br.com.acc.slc.service;

import org.springframework.data.domain.Page;

import br.com.acc.slc.vo.Morador;

/**
 * Interface responsavel pela camada de negocios da entidade Morador
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 13 de ago de 2019 |
 *         19:59:51
 */
public interface IMoradorService {

    /**
     * Metodo reponsavel por selecionar todos os moradores paginados
     * 
     * @param pagina          numero da pagina
     * @param linhasPorPagina quantidade de registros por pagina
     * @param ordernacao      ordenacao da busca
     * @param direcao         ordenacao crescente ou decrescente
     * @return moradores paginados
     */
    Page<Morador> selecionarMoradoresPaginados(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao);

    /**
     * Metodo reponsavel por selecionar um morador pelo seu ID
     * 
     * @param id ID do morador a ser selecionado
     * @return morador selecionado
     */
    Morador selecionarMoradorPorId(Integer id);

    /**
     * Metodo reponsavel por inserir um morador
     * 
     * @param morador morador a ser inserido
     * @return morador inserido
     */
    Morador inserirMorador(Morador morador);

    /**
     * Metodo responsavel por atualizar um morador
     * 
     * @param morador morador a ser atualizado
     * @return morador atualizado
     */
    Morador atualizarMorador(Morador morador);

    /**
     * Metodo reponsavel por deletar um morador
     * 
     * @param id ID do morador a ser deletado
     */
    void deletarMorador(Integer id);

}

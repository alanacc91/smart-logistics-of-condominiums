package br.com.acc.slc.service;

import org.springframework.data.domain.Page;

import br.com.acc.slc.vo.Configuracao;

/**
 * Interface responsavel pela camada de negocios da entidade Configuracao
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 13 de ago de 2019 |
 *         19:59:51
 */
public interface IConfiguracaoService {

    /**
     * Metodo reponsavel por selecionar todos os moradores paginados
     * 
     * @param pagina          numero da pagina
     * @param linhasPorPagina quantidade de registros por pagina
     * @param ordernacao      ordenacao da busca
     * @param direcao         ordenacao crescente ou decrescente
     * @return configuracoes paginados
     */
    Page<Configuracao> selecionarConfiguracoesPaginadas(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao);

    /**
     * Metodo reponsavel por selecionar uma configuracao pelo seu ID
     * 
     * @param id ID do configuracao a ser selecionado
     * @return configuracao selecionado
     */
    Configuracao selecionarConfiguracaoPorId(Integer id);

    /**
     * Metodo reponsavel por inserir uma configuracao
     * 
     * @param configuracao configuracao a ser inserida
     * @return configuracao inserida
     */
    Configuracao inserirConfiguracao(Configuracao configuracao);

    /**
     * Metodo responsavel por atualizar uma configuracao
     * 
     * @param configuracao configuracao a ser atualizada
     * @return configuracao atualizada
     */
    Configuracao atualizarConfiguracao(Configuracao configuracao);

    /**
     * Metodo reponsavel por deletar uma configuracao
     * 
     * @param id ID do configuracao a ser deletada
     */
    void deletarConfiguracao(Integer id);

}

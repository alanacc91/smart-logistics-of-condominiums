package br.com.acc.slc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.acc.slc.vo.Nivel1;

/**
 * Interface responsavel pela camada de negocios da entidade Nivel1
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 13 de ago de 2019 |
 *         19:59:51
 */
public interface INivel1Service {

    /**
     * Metodo reponsavel por selecionar todos os niveis1 paginados
     * 
     * @param pagina          numero da pagina
     * @param linhasPorPagina quantidade de registros por pagina
     * @param ordernacao      ordenacao da busca
     * @param direcao         ordenacao crescente ou decrescente
     * @return niveis1 paginados
     */
    Page<Nivel1> selecionarNiveis1Paginados(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao);

    /**
     * Metodo reponsavel por selecionar um nivel1 pelo seu ID
     * 
     * @param id ID do nivel1 a ser selecionado
     * @return nivel1 selecionado
     */
    Nivel1 selecionarNivel1PorId(Integer id);

    /**
     * Metodo reponsavel por inserir um nivel1
     * 
     * @param nivel1 nivel1 a ser inserido
     * @return nivel1 inserido
     */
    Nivel1 inserirNivel1(Nivel1 nivel1);

    /**
     * Metodo responsavel por atualizar um nivel1
     * 
     * @param nivel1 nivel1 a ser atualizado
     * @return nivel1 atualizado
     */
    Nivel1 atualizarNivel1(Nivel1 nivel1);

    /**
     * Metodo reponsavel por deletar um nivel1
     * 
     * @param id ID do nivel1 a ser deletado
     */
    void deletarNivel1(Integer id);

    /**
     * Metodo responsavel por selecionar niveis1 por nome
     * 
     * @param nome nome a ser buscado
     * @return Lista de niveis 1
     */
    List<Nivel1> selecionarNiveis1PorNomeIgnorandoCaseEUtilizandoLike(String nome);

    /**
     * Metodo responsavel por verificar se nivel1 ja existe
     * 
     * @param nome nome a ser validado
     * @return verdadeiro se existe / falso se nao
     */
    boolean nivel1Existir(String nome);

    /**
     * Metodo responsavel por verificar se nivel1 ja existe com id diferente do que
     * esta sendo atualizado
     * 
     * @param nome nome a procurado
     * @param id   id do objeto atualizado
     * @return verdadeiro se existe / falso se nao
     */
    boolean nivel1ExistirComIdDiferente(String nome, Integer id);

}

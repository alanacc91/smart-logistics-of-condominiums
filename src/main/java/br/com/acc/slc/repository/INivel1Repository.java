package br.com.acc.slc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.acc.slc.vo.Nivel1;

/**
 * Interface responsavel pela persistencia da entidade Nivel1
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de ago de 2019 |
 *         20:27:43
 */
public interface INivel1Repository {

    Page<Nivel1> selecionarNiveis1Paginados(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao);
    
    List<Nivel1> selecionarNiveis1();

    Optional<Nivel1> selecionarNivel1PorId(Integer id);
    
    Optional<Nivel1> selecionarNivel1PorNome(String nome);

    Nivel1 inserirNivel1(Nivel1 nivel1);

    Nivel1 atualizarNivel1(Nivel1 nivel1);

    void deletarNivel1(Integer id);

    List<Nivel1> selecionarNiveis1PorNomeIgnorandoCaseEUtilizandoLike(String nome);
    
    List<Nivel1> selecionarNiveis1PorNomeIgnorandoCase(String nome);
    
    List<Nivel1> selecionarNiveis1PorNomeIgnorandoCaseEPorIdDiferente(String nome, Integer id);

}

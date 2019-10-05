package br.com.acc.slc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.acc.slc.vo.Nivel2;

/**
 * Interface responsavel pela persistencia da entidade Nivel2
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de ago de 2019 |
 *         20:27:43
 */
public interface INivel2Repository {

    Page<Nivel2> selecionarNiveis2Paginados(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao);

    Optional<Nivel2> selecionarNivel2PorId(Integer id);

    Nivel2 inserirNivel2(Nivel2 nivel2);

    Nivel2 atualizarNivel2(Nivel2 nivel2);

    void deletarNivel2(Integer id);

    List<Nivel2> selecionarNiveis2PorNivel1(Integer id);

}

package br.com.acc.slc.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.acc.slc.vo.Morador;

/**
 * Interface responsavel pela persistencia da entidade Morador
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de ago de 2019 |
 *         20:27:43
 */
public interface IMoradorRepository {

    Page<Morador> selecionarMoradoresPaginados(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao);

    Optional<Morador> selecionarMoradorPorId(Integer id);

    Morador inserirMorador(Morador morador);

    Morador atualizarMorador(Morador morador);

    void deletarMorador(Integer id);

}

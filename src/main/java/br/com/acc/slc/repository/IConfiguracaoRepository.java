package br.com.acc.slc.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.acc.slc.vo.Configuracao;

/**
 * Interface responsavel pela persistencia da entidade Configuracao
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de set de 2019 |
 *         20:27:43
 */
public interface IConfiguracaoRepository {

    Page<Configuracao> selecionarConfiguracoesPaginadas(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao);

    Optional<Configuracao> selecionarConfiguracaoPorId(Integer id);

    Configuracao inserirConfiguracao(Configuracao configuracao);

    Configuracao atualizarConfiguracao(Configuracao configuracao);

    void deletarConfiguracao(Integer id);

}

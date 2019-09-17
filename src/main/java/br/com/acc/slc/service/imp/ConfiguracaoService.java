package br.com.acc.slc.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.acc.slc.repository.IConfiguracaoRepository;
import br.com.acc.slc.resources.exceptions.DataIntegrityException;
import br.com.acc.slc.resources.exceptions.ObjectNotFoundException;
import br.com.acc.slc.service.IConfiguracaoService;
import br.com.acc.slc.vo.Configuracao;

/**
 * Classe responsavel pela camada de negocios da entidade Configuracao
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de set de 2019 |
 *         19:39:15
 */
@Service
public class ConfiguracaoService implements IConfiguracaoService {

    @Autowired
    IConfiguracaoRepository configuracaoRepository;

    public Page<Configuracao> selecionarConfiguracoesPaginadas(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao) {
	return configuracaoRepository.selecionarConfiguracoesPaginadas(pagina, linhasPorPagina, ordernacao, direcao);
    }

    public Configuracao selecionarConfiguracaoPorId(Integer id) {
	Optional<Configuracao> configuracao = configuracaoRepository.selecionarConfiguracaoPorId(id);
	return configuracao.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Configuracao.class.getName()));
    }

    public Configuracao inserirConfiguracao(Configuracao configuracao) {
	return configuracaoRepository.inserirConfiguracao(configuracao);
    }

    public Configuracao atualizarConfiguracao(Configuracao configuracao) {
	return configuracaoRepository.atualizarConfiguracao(configuracao);
    }

    public void deletarConfiguracao(Integer id) {
	try {
	    configuracaoRepository.deletarConfiguracao(id);
	} catch (DataIntegrityViolationException e) {
	    throw new DataIntegrityException("Falha ao deletar Configuracao!");
	}

    }

}

package br.com.acc.slc.repository.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import br.com.acc.slc.repository.IConfiguracaoRepository;
import br.com.acc.slc.repository.jpa.IConfiguracaoJPARepository;
import br.com.acc.slc.vo.Configuracao;

/**
 * Classe responsavel pela persistencia da entidade Configuracao
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de set de 2019 |
 *         20:40:50
 */
@Repository
public class ConfiguracaoRepository implements IConfiguracaoRepository {

    @Autowired
    IConfiguracaoJPARepository configuracacoRepository;

    public Page<Configuracao> selecionarConfiguracoesPaginadas(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao) {

	PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordernacao);
	return configuracacoRepository.findAll(pageRequest);
    }

    public Optional<Configuracao> selecionarConfiguracaoPorId(Integer id) {
	return configuracacoRepository.findById(id);
    }

    public Configuracao inserirConfiguracao(Configuracao configuracaco) {
	configuracaco.setId(null);
	return configuracacoRepository.save(configuracaco);
    }

    public Configuracao atualizarConfiguracao(Configuracao configuracaco) {
	return configuracacoRepository.save(configuracaco);
    }

    public void deletarConfiguracao(Integer id) {
	configuracacoRepository.deleteById(id);
    }

}

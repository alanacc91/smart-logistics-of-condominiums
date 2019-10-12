package br.com.acc.slc.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.acc.slc.repository.INivel1Repository;
import br.com.acc.slc.resources.exceptions.DataIntegrityException;
import br.com.acc.slc.resources.exceptions.ObjectNotFoundException;
import br.com.acc.slc.service.IConfiguracaoService;
import br.com.acc.slc.service.INivel1Service;
import br.com.acc.slc.service.INivel2Service;
import br.com.acc.slc.service.validations.ConfiguracaoValidator;
import br.com.acc.slc.service.validations.Nivel1Validator;
import br.com.acc.slc.service.validations.Nivel2Validator;
import br.com.acc.slc.vo.Configuracao;
import br.com.acc.slc.vo.Nivel1;
import br.com.acc.slc.vo.Nivel2;

/**
 * Classe responsavel pela camada de negocios da entidade Nivel1
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 15 de ago de 2019 |
 *         19:39:15
 */
@Service
public class Nivel1Service implements INivel1Service {

    @Autowired
    INivel1Repository nivel1Repository;

    @Autowired
    IConfiguracaoService configuracaoService;

    @Autowired
    INivel2Service nivel2Service;

    public Page<Nivel1> selecionarNiveis1Paginados(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao) {
	pagina -= 1;
	return nivel1Repository.selecionarNiveis1Paginados(pagina, linhasPorPagina, ordernacao, direcao);
    }

    public Nivel1 selecionarNivel1PorId(Integer id) {
	Optional<Nivel1> nivel1 = nivel1Repository.selecionarNivel1PorId(id);
	return nivel1.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Nivel1.class.getName()));
    }

    public Nivel1 inserirNivel1(Nivel1 nivel1) {
	if (Nivel1Validator.nivel1NaoPossuirNome(nivel1)) {
	    throw new DataIntegrityException("Nome não pode ser nulo!");
	}

	if (nivel1Existir(nivel1.getNome())) {
	    Configuracao configuracao = configuracaoService.selecionarConfiguracaoPorId(1);
	    String mensagemDeErro = null;

	    if (ConfiguracaoValidator.tipoDeCondominioForVertical(configuracao)) {
		mensagemDeErro = "Este prédio já está cadastrado!";
	    } else {
		mensagemDeErro = "Esta rua já está cadastrada!";
	    }
	    throw new DataIntegrityException(mensagemDeErro);
	}
	return nivel1Repository.inserirNivel1(nivel1);
    }

    public Nivel1 atualizarNivel1(Nivel1 nivel1) {
	if (Nivel1Validator.nivel1NaoPossuirNome(nivel1)) {
	    throw new DataIntegrityException("Nome não pode ser nulo!");
	}

	if (nivel1ExistirComIdDiferente(nivel1.getNome(), nivel1.getId())) {
	    Configuracao configuracao = configuracaoService.selecionarConfiguracaoPorId(1);
	    String mensagemDeErro = null;

	    if (ConfiguracaoValidator.tipoDeCondominioForVertical(configuracao)) {
		mensagemDeErro = "Este prédio já está cadastrado!";
	    } else {
		mensagemDeErro = "Esta rua já está cadastrada!";
	    }
	    throw new DataIntegrityException(mensagemDeErro);
	}
	return nivel1Repository.atualizarNivel1(nivel1);
    }

    public void deletarNivel1(Integer id) {

	List<Nivel2> listaDeNiveis2 = nivel2Service.selecionarNiveis2PorNivel1(id);

	if (Nivel2Validator.listaDeNivel2TemItens(listaDeNiveis2)) {
	    Configuracao configuracao = configuracaoService.selecionarConfiguracaoPorId(1);
	    String mensagemDeErro = null;

	    if (ConfiguracaoValidator.tipoDeCondominioForVertical(configuracao)) {
		mensagemDeErro = "Não foi possível excluir este prédio, pois existem apartamentos cadastrados nele!";
	    } else {
		mensagemDeErro = "Não foi possível excluir esta rua, pois existem casas cadastradas nela!";
	    }
	    throw new DataIntegrityException(mensagemDeErro);
	}

	try {
	    nivel1Repository.deletarNivel1(id);
	} catch (DataIntegrityViolationException e) {
	    throw new DataIntegrityException("Falha ao deletar Nivel1!");
	}

    }

    @Override
    public List<Nivel1> selecionarNiveis1PorNomeIgnorandoCaseEUtilizandoLike(String nome) {
	return nivel1Repository.selecionarNiveis1PorNomeIgnorandoCaseEUtilizandoLike(nome);
    }

    @Override
    public boolean nivel1Existir(String nome) {
	List<Nivel1> listaDeNivel1 = nivel1Repository.selecionarNiveis1PorNomeIgnorandoCase(nome);
	return Nivel1Validator.listaDeNivel1TemItens(listaDeNivel1);
    }

    @Override
    public boolean nivel1ExistirComIdDiferente(String nome, Integer id) {
	List<Nivel1> listaDeNivel1 = nivel1Repository.selecionarNiveis1PorNomeIgnorandoCaseEPorIdDiferente(nome, id);
	return Nivel1Validator.listaDeNivel1TemItens(listaDeNivel1);
    }

    @Override
    public List<Nivel1> selecionarNiveis1() {
	return nivel1Repository.selecionarNiveis1();
    }

    @Override
    public Nivel1 selecionarNivel1PorNome(String nome) {
	Optional<Nivel1> nivel1 = nivel1Repository.selecionarNivel1PorNome(nome);
	return nivel1.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Nome: " + nome + ", Tipo: " + Nivel1.class.getName()));
    }

}

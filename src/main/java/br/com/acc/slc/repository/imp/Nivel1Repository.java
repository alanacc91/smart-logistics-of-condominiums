package br.com.acc.slc.repository.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import br.com.acc.slc.repository.INivel1Repository;
import br.com.acc.slc.repository.jpa.INivel1JPARepository;
import br.com.acc.slc.vo.Nivel1;

/**
 * Classe responsavel pela persistencia da entidade Nivel1
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de ago de 2019 |
 *         20:46:50
 */
@Repository
public class Nivel1Repository implements INivel1Repository {

    @Autowired
    INivel1JPARepository nivel1Repository;

    @Override
    public Page<Nivel1> selecionarNiveis1Paginados(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao) {

	PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordernacao);
	return nivel1Repository.findAll(pageRequest);
    }

    @Override
    public Optional<Nivel1> selecionarNivel1PorId(Integer id) {
	return nivel1Repository.findById(id);
    }

    @Override
    public Nivel1 inserirNivel1(Nivel1 nivel1) {
	nivel1.setId(null);
	return nivel1Repository.save(nivel1);
    }

    @Override
    public Nivel1 atualizarNivel1(Nivel1 nivel1) {
	return nivel1Repository.save(nivel1);
    }

    @Override
    public void deletarNivel1(Integer id) {
	nivel1Repository.deleteById(id);
    }

    @Override
    public List<Nivel1> selecionarNiveis1PorNomeIgnorandoCaseEUtilizandoLike(String nome) {
	return nivel1Repository.findByNomeIgnoreCaseContaining(nome);
    }

    @Override
    public List<Nivel1> selecionarNiveis1PorNomeIgnorandoCase(String nome) {
	return nivel1Repository.findByNomeIgnoreCase(nome);
    }

    @Override
    public List<Nivel1> selecionarNiveis1PorNomeIgnorandoCaseEPorIdDiferente(String nome, Integer id) {
	return nivel1Repository.findByNomeIgnoreCaseAndIdNot(nome, id);
    }

}

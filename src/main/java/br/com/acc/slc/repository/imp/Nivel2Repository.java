package br.com.acc.slc.repository.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import br.com.acc.slc.repository.INivel2Repository;
import br.com.acc.slc.repository.jpa.INivel2JPARepository;
import br.com.acc.slc.vo.Nivel2;

/**
 * Classe responsavel pela persistencia da entidade Nivel2
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de ago de 2019 |
 *         20:46:50
 */
@Repository
public class Nivel2Repository implements INivel2Repository {

    @Autowired
    INivel2JPARepository nivel2Repository;

    public Page<Nivel2> selecionarNiveis2Paginados(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao) {

	PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordernacao);
	return nivel2Repository.findAll(pageRequest);
    }

    public Optional<Nivel2> selecionarNivel2PorId(Integer id) {
	return nivel2Repository.findById(id);
    }

    public Nivel2 inserirNivel2(Nivel2 nivel2) {
	nivel2.setId(null);
	return nivel2Repository.save(nivel2);
    }

    public Nivel2 atualizarNivel2(Nivel2 nivel2) {
	return nivel2Repository.save(nivel2);
    }

    public void deletarNivel2(Integer id) {
	nivel2Repository.deleteById(id);
    }

}

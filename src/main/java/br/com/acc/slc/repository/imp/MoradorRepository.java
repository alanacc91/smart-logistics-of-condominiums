package br.com.acc.slc.repository.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import br.com.acc.slc.repository.IMoradorRepository;
import br.com.acc.slc.repository.jpa.IMoradorJPARepository;
import br.com.acc.slc.vo.Morador;

/**
 * Classe responsavel pela persistencia da entidade Morador
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de ago de 2019 |
 *         20:46:50
 */
@Repository
public class MoradorRepository implements IMoradorRepository {

    @Autowired
    IMoradorJPARepository moradorRepository;

    public Page<Morador> selecionarMoradoresPaginados(Integer pagina, Integer linhasPorPagina, String ordernacao, String direcao) {

	PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordernacao);
	return moradorRepository.findAll(pageRequest);
    }

    public Optional<Morador> selecionarMoradorPorId(Integer id) {
	return moradorRepository.findById(id);
    }

    public Morador inserirMorador(Morador morador) {
	morador.setId(null);
	return moradorRepository.save(morador);
    }

    public Morador atualizarMorador(Morador morador) {
	return moradorRepository.save(morador);
    }

    public void deletarMorador(Integer id) {
	moradorRepository.deleteById(id);
    }

}

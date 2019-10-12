package br.com.acc.slc.repository.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acc.slc.vo.Nivel1;

/**
 * Interface JPA da entidade Nivel1
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de ago de 2019 |
 *         20:26:26
 */
@Repository
public interface INivel1JPARepository extends JpaRepository<Nivel1, Integer> {

    List<Nivel1> findByNomeIgnoreCaseContaining(String nome);

    List<Nivel1> findByNomeIgnoreCase(String nome);
    
    Optional<Nivel1> findByNome(String nome);

    List<Nivel1> findByNomeIgnoreCaseAndIdNot(String nome, Integer id);
    
    List<Nivel1> findAllByOrderByNome();

}

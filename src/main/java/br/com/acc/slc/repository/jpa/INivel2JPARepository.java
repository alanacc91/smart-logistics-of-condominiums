package br.com.acc.slc.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acc.slc.vo.Nivel2;

/**
 * Interface JPA da entidade Nivel2
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de ago de 2019 |
 *         20:26:40
 */
@Repository
public interface INivel2JPARepository extends JpaRepository<Nivel2, Integer> {

}

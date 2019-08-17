package br.com.acc.slc.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acc.slc.vo.AreaComum;

/**
 * Interface JPA da entidade AreaComum
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de ago de 2019 |
 *         20:25:32
 */
@Repository
public interface IAreaComumJPARepository extends JpaRepository<AreaComum, Integer> {

}

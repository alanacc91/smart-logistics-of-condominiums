package br.com.acc.slc.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acc.slc.vo.Configuracao;

/**
 * Interface JPA da entidade Configuracao
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de set de 2019 |
 *         20:35:56
 */
@Repository
public interface IConfiguracaoJPARepository extends JpaRepository<Configuracao, Integer> {

}

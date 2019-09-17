package br.com.acc.slc.rest;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.acc.slc.service.INivel2Service;
import br.com.acc.slc.vo.Nivel2;

/**
 * Classe responsavel por disponibilizar os endpoints da entidade Nivel2
 * 
 * @author Alan Cristian Cardoso | alan.acc92@gmail.com 25 de ago de 2029 |
 *         20:29:38
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/niveis2")
public class Nivel2Rest {

    @Autowired
    private INivel2Service nivel2Service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Nivel2> selecionarNivel2PorId(@PathVariable Integer id) {

	Nivel2 nivel2 = nivel2Service.selecionarNivel2PorId(id);
	return ResponseEntity.ok().body(nivel2);
    }

    @PostMapping
    public ResponseEntity<Void> inserirNivel2(@Valid @RequestBody Nivel2 nivel2) {

	nivel2 = nivel2Service.inserirNivel2(nivel2);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nivel2.getId()).toUri();
	return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizarNivel2(@Valid @RequestBody Nivel2 nivel2, @PathVariable Integer id) {
	nivel2.setId(id);
	nivel2 = nivel2Service.atualizarNivel2(nivel2);
	return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarNivel2(@PathVariable Integer id) {

	nivel2Service.deletarNivel2(id);
	return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<Nivel2>> selecionarNiveis2Paginados(@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
	    @RequestParam(value = "linhasPorPagina", defaultValue = "24") Integer linhasPorPagina,
	    @RequestParam(value = "ordenacao", defaultValue = "id") String ordenacao, @RequestParam(value = "direcao", defaultValue = "ASC") String direcao) {
	Page<Nivel2> listaDeNiveis2 = nivel2Service.selecionarNiveis2Paginados(pagina, linhasPorPagina, ordenacao, direcao);

	return ResponseEntity.ok().body(listaDeNiveis2);
    }
}

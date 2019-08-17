package br.com.acc.slc.rest;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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

import br.com.acc.slc.service.IMoradorService;
import br.com.acc.slc.vo.Morador;

/**
 * Classe responsavel por disponibilizar os endpoints da entidade Morador
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 15 de ago de 2019 |
 *         20:19:38
 */
@RestController
@RequestMapping(value = "/moradores")
public class MoradorRest {

    @Autowired
    private IMoradorService moradorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Morador> selecionarMoradorPorId(@PathVariable Integer id) {

	Morador morador = moradorService.selecionarMoradorPorId(id);
	return ResponseEntity.ok().body(morador);
    }

    @PostMapping
    public ResponseEntity<Void> inserirMorador(@Valid @RequestBody Morador morador) {

	morador = moradorService.inserirMorador(morador);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(morador.getId()).toUri();
	return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizarMorador(@Valid @RequestBody Morador morador, @PathVariable Integer id) {
	morador.setId(id);
	morador = moradorService.atualizarMorador(morador);
	return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarMorador(@PathVariable Integer id) {

	moradorService.deletarMorador(id);
	return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<Morador>> selecionarMoradoresPaginados(@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
	    @RequestParam(value = "linhasPorPagina", defaultValue = "24") Integer linhasPorPagina,
	    @RequestParam(value = "ordenacao", defaultValue = "id") String ordenacao, @RequestParam(value = "direcao", defaultValue = "ASC") String direcao) {
	Page<Morador> listaDeMoradores = moradorService.selecionarMoradoresPaginados(pagina, linhasPorPagina, ordenacao, direcao);

	return ResponseEntity.ok().body(listaDeMoradores);
    }
}

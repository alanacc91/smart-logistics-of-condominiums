package br.com.acc.slc.rest;

import java.net.URI;
import java.util.List;

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

import br.com.acc.slc.dto.LookupDTO;
import br.com.acc.slc.service.INivel1Service;
import br.com.acc.slc.vo.Nivel1;

/**
 * Classe responsavel por disponibilizar os endpoints da entidade Nivel1
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 15 de ago de 2019 |
 *         20:19:38
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/niveis1")
public class Nivel1Rest {

    @Autowired
    private INivel1Service nivel1Service;

    @GetMapping(value = "/nome/lookup/{nome}")
    public ResponseEntity<Nivel1> selecionarNivel1PorNome(@PathVariable String nome) {

	Nivel1 nivel1 = nivel1Service.selecionarNivel1PorNome(nome);
	return ResponseEntity.ok().body(nivel1);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Nivel1> selecionarNivel1PorId(@PathVariable Integer id) {

	Nivel1 nivel1 = nivel1Service.selecionarNivel1PorId(id);
	return ResponseEntity.ok().body(nivel1);
    }

    @PostMapping
    public ResponseEntity<Void> inserirNivel1(@Valid @RequestBody Nivel1 nivel1) {

	nivel1 = nivel1Service.inserirNivel1(nivel1);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nivel1.getId()).toUri();
	return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizarNivel1(@Valid @RequestBody Nivel1 nivel1, @PathVariable Integer id) {
	nivel1.setId(id);
	nivel1 = nivel1Service.atualizarNivel1(nivel1);
	return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarNivel1(@PathVariable Integer id) {

	nivel1Service.deletarNivel1(id);
	return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<LookupDTO> selecionarNiveis1Paginados(@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
	    @RequestParam(value = "linhasPorPagina", defaultValue = "24") Integer linhasPorPagina,
	    @RequestParam(value = "ordenacao", defaultValue = "id") String ordenacao, @RequestParam(value = "direcao", defaultValue = "ASC") String direcao) {

	Page<Nivel1> listaDeNiveis1 = nivel1Service.selecionarNiveis1Paginados(pagina, linhasPorPagina, ordenacao, direcao);
	LookupDTO lookupNivel1DTO = new LookupDTO();
	lookupNivel1DTO.setItems(listaDeNiveis1.getContent());
	lookupNivel1DTO.setHasNext(lookupNivel1DTO.getItems().size() == linhasPorPagina);

	return ResponseEntity.ok().body(lookupNivel1DTO);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Nivel1>> selecionarNiveis1() {
	List<Nivel1> listaDeNiveis1 = nivel1Service.selecionarNiveis1();

	return ResponseEntity.ok().body(listaDeNiveis1);
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<LookupDTO> selecionarNiveis1PorNome(@PathVariable String nome) {

	List<Nivel1> niveis1 = nivel1Service.selecionarNiveis1PorNomeIgnorandoCaseEUtilizandoLike(nome);
	LookupDTO lookupNivel1DTO = new LookupDTO();
	lookupNivel1DTO.setItems(niveis1);

	return ResponseEntity.ok().body(lookupNivel1DTO);
    }

}

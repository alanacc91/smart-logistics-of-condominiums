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

import br.com.acc.slc.service.IAreaComumService;
import br.com.acc.slc.vo.AreaComum;

/**
 * Classe responsavel por disponibilizar os endpoints da entidade AreaComum
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 15 de ago de 2019 |
 *         20:19:38
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/areasComum")
public class AreaComumRest {

    @Autowired
    private IAreaComumService areaComumService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AreaComum> selecionarAreaComumPorId(@PathVariable Integer id) {

	AreaComum areaComum = areaComumService.selecionarAreaComumPorId(id);
	return ResponseEntity.ok().body(areaComum);
    }

    @PostMapping
    public ResponseEntity<Void> inserirAreaComum(@Valid @RequestBody AreaComum areaComum) {

	areaComum = areaComumService.inserirAreaComum(areaComum);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(areaComum.getId()).toUri();
	return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizarAreaComum(@Valid @RequestBody AreaComum areaComum, @PathVariable Integer id) {
	areaComum.setId(id);
	areaComum = areaComumService.atualizarAreaComum(areaComum);
	return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarAreaComum(@PathVariable Integer id) {

	areaComumService.deletarAreaComum(id);
	return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<AreaComum>> selecionarAreasComumPaginados(@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
	    @RequestParam(value = "linhasPorPagina", defaultValue = "24") Integer linhasPorPagina,
	    @RequestParam(value = "ordenacao", defaultValue = "id") String ordenacao, @RequestParam(value = "direcao", defaultValue = "ASC") String direcao) {
	Page<AreaComum> listaDeAreasComum = areaComumService.selecionarAreasComumPaginadas(pagina, linhasPorPagina, ordenacao, direcao);

	return ResponseEntity.ok().body(listaDeAreasComum);
    }
}

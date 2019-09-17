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

import br.com.acc.slc.service.IConfiguracaoService;
import br.com.acc.slc.vo.Configuracao;

/**
 * Classe responsavel por disponibilizar os endpoints da entidade Configuracao
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de set de 2019 |
 *         20:44:38
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/configuracoes")
public class ConfiguracaoRest {

    @Autowired
    private IConfiguracaoService configuracaoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Configuracao> selecionarConfiguracaoPorId(@PathVariable Integer id) {

	Configuracao configuracao = configuracaoService.selecionarConfiguracaoPorId(id);
	return ResponseEntity.ok().body(configuracao);
    }

    @PostMapping
    public ResponseEntity<Void> inserirConfiguracao(@Valid @RequestBody Configuracao configuracao) {

	configuracao = configuracaoService.inserirConfiguracao(configuracao);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(configuracao.getId()).toUri();
	return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizarConfiguracao(@Valid @RequestBody Configuracao configuracao, @PathVariable Integer id) {
	configuracao.setId(id);
	configuracao = configuracaoService.atualizarConfiguracao(configuracao);
	return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarConfiguracao(@PathVariable Integer id) {

	configuracaoService.deletarConfiguracao(id);
	return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<Configuracao>> selecionarConfiguracoesPaginados(@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
	    @RequestParam(value = "linhasPorPagina", defaultValue = "24") Integer linhasPorPagina,
	    @RequestParam(value = "ordenacao", defaultValue = "id") String ordenacao, @RequestParam(value = "direcao", defaultValue = "ASC") String direcao) {
	Page<Configuracao> listaDeConfiguracoes = configuracaoService.selecionarConfiguracoesPaginadas(pagina, linhasPorPagina, ordenacao, direcao);

	return ResponseEntity.ok().body(listaDeConfiguracoes);
    }
}

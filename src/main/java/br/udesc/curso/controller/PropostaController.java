package br.udesc.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.udesc.curso.model.Apolice;
import br.udesc.curso.repository.ApoliceRepository;
import br.udesc.curso.service.proposta.PropostaService;
import br.udesc.curso.vo.PropostaVO;

@RestController
@RequestMapping("proposta")
public class PropostaController {
	
	@Autowired
	private PropostaService propostaService;
	
	@Autowired
	private ApoliceRepository apoliceRepository;
	
	@PostMapping("/")
	public Apolice propose(@RequestBody PropostaVO proposta) {
		return propostaService.calculate(proposta);
	}
	
	@GetMapping("/")
	public List<Apolice> all() {
		return apoliceRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Apolice findById(@PathVariable("id") long id) {
		return apoliceRepository.findById(id).get();
	}
	
	@GetMapping("aceitar/{id}")
	public Apolice accept(@PathVariable("id") long id) {
		return propostaService.accept(id);
	}

}

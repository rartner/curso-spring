package br.udesc.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.udesc.curso.model.Apolice;
import br.udesc.curso.service.proposta.PropostaService;
import br.udesc.curso.vo.PropostaVO;

@RestController
@RequestMapping("proposta")
public class PropostaController {
	
	@Autowired
	private PropostaService propostaService;
	
	@PostMapping("/")
	public Apolice propor(@RequestBody PropostaVO proposta) {
		return propostaService.calcular(proposta);
	}

}

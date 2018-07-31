package br.udesc.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.udesc.curso.model.Cliente;
import br.udesc.curso.repository.CidadeRepository;
import br.udesc.curso.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<Cliente>> all() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}
	
	@PostMapping("/salvar")
	public Cliente save(@RequestBody Cliente cliente) {
		long cidadeId = cliente.getCidade().getId();
		cliente.setCidade(cidadeRepository.findById(cidadeId).get());
		
		return clienteRepository.saveAndFlush(cliente);
	}
	
	@GetMapping("/busca/{id}")
	public Cliente busca(@PathVariable("id") long id) {
		return clienteRepository.findById(id).get();
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Object> deletar(@PathVariable("id") long id) {
		try {
			clienteRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.ok(e);
		}
				
		return ResponseEntity.ok(true);
	}

}

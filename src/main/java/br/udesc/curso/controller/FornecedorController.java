package br.udesc.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.udesc.curso.model.Fornecedor;
import br.udesc.curso.repository.FornecedorRepository;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
	
	@Autowired
	public FornecedorRepository fornecedorRepository;
	
	@GetMapping("/")
	public List<Fornecedor> all() {
		return fornecedorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Fornecedor findById(@PathVariable("id") long id) {
		return fornecedorRepository.findById(id).get();
	}
	
	@PostMapping("/")
	public Fornecedor save(Fornecedor fornecedor) {
		return fornecedorRepository.saveAndFlush(fornecedor);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable("id") long id) {
		try {
			fornecedorRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e);
		}
				
		return ResponseEntity.ok(true);
	}
	

}

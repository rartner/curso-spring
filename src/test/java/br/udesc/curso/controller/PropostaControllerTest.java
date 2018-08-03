package br.udesc.curso.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.model.Cliente;
import br.udesc.curso.model.Veiculo;
import br.udesc.curso.vo.PropostaVO;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropostaControllerTest {
	
	@Autowired
	private PropostaController propostaController;
	
	PropostaVO proposta;
	
	@Before
	public void setup() {
		Cliente cliente = Cliente.builder()
				.nascimento(new Date(1996-1900, 2, 20))
				.build();
		
		Veiculo veiculo = Veiculo.builder()
				.anoFabricacao(1995)
				.valor(10000.00)
				.build();
		
		Set<Cobertura> coberturas = new HashSet<>();
		coberturas.add(Cobertura.PERDA_TOTAL);
		
		proposta = PropostaVO.builder()
				.cliente(cliente)
				.veiculo(veiculo)
				.coberturas(coberturas)
				.build();
	}
	
	@Test
	public void calculaPropostaVO() {
		double valor = propostaController.propor(proposta);
		
		Assert.assertEquals(500.0, valor);
	}

}

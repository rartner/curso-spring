package br.udesc.curso.service.proposta.calculation;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.udesc.curso.model.Cliente;
import br.udesc.curso.model.Veiculo;
import br.udesc.curso.vo.PropostaVO;

public class PerdaTotalCalculationTest {

	@Test
	public void testFaixaDeRisco() {
		Cliente cliente = new Cliente();
		cliente.setNascimento(new Date(2000-1900, 10, 1));
		
		Veiculo veiculo = new Veiculo();
		veiculo.setValor(10000.00);
		veiculo.setAnoFabricacao(1995);
		veiculo.setImportado(false);
		veiculo.setBlindado(false);
		
		PropostaVO proposta = new PropostaVO();
		proposta.setCliente(cliente);
		proposta.setVeiculo(veiculo);
		
		PerdaTotalCalculation calculation = new PerdaTotalCalculation();
		double valor = calculation.calcular(proposta);
		
		Assert.assertEquals(500.00, valor, 0);
	}
	
	@Test
	public void testMeiaIdade() {
		Cliente cliente = new Cliente();
		cliente.setNascimento(new Date(1987-1900, 10, 1));
		
		Veiculo veiculo = new Veiculo();
		veiculo.setValor(23000.00);
		veiculo.setAnoFabricacao(2008);
		veiculo.setImportado(false);
		veiculo.setBlindado(false);
		
		PropostaVO proposta = new PropostaVO();
		proposta.setCliente(cliente);
		proposta.setVeiculo(veiculo);
		
		PerdaTotalCalculation calculation = new PerdaTotalCalculation();
		double valor = calculation.calcular(proposta);
		
		Assert.assertEquals(690.00, valor, 0);
	}
	
	@Test
	public void testIdoso() {
		Cliente cliente = new Cliente();
		cliente.setNascimento(new Date(1957-1900, 10, 1));
		
		Veiculo veiculo = new Veiculo();
		veiculo.setValor(80000.00);
		veiculo.setAnoFabricacao(2018);
		veiculo.setImportado(true);
		veiculo.setBlindado(true);
		
		PropostaVO proposta = new PropostaVO();
		proposta.setCliente(cliente);
		proposta.setVeiculo(veiculo);
		
		PerdaTotalCalculation calculation = new PerdaTotalCalculation();
		double valor = calculation.calcular(proposta);
		
		Assert.assertEquals(800.00, valor, 0);
	}
}

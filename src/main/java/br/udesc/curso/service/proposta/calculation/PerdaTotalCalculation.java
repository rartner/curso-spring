package br.udesc.curso.service.proposta.calculation;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.udesc.curso.vo.PropostaVO;

@Component
public class PerdaTotalCalculation extends CoberturaCalculation {

	@Override
	double calcularValor(PropostaVO proposta) {
		return 0;
	}

	@Override
	double calcularPercentualVeiculo(PropostaVO proposta) {
		int idadeCliente = new Date().getYear() - proposta.getCliente().getNascimento().getYear();
		
		if (idadeCliente < 24) {
			return 0.05;
		} else if (idadeCliente < 40) {
			return 0.03;
		} else {
			return 0.01;
		}
	}

}

package br.udesc.curso.service.proposta.calculation;

import org.springframework.stereotype.Component;

import br.udesc.curso.vo.PropostaVO;

@Component
public class AssistenciaCalculation extends CoberturaCalculation {

	@Override
	double calcularValor(PropostaVO proposta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double calcularPercentualVeiculo(PropostaVO proposta) {
		// TODO Auto-generated method stub
		return 0;
	}

}

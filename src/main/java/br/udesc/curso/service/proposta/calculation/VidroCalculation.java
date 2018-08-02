package br.udesc.curso.service.proposta.calculation;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.udesc.curso.vo.PropostaVO;

@Component
public class VidroCalculation extends CoberturaCalculation {

	@Override
	double calcularValor(PropostaVO proposta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double calcularPercentualVeiculo(PropostaVO proposta) {
		int idadeVeiculo = new Date().getYear() - proposta.getVeiculo().getAnoFabricacao();
		double percentual = 0;
		
		if (idadeVeiculo < 3) {
			percentual = 0.0075;
		} else if (idadeVeiculo < 5) {
			percentual = 0.0055;
		} else if (idadeVeiculo < 10){
			percentual = 0.0025;
		} else {
			percentual = 0.0075;
		}
		
		if (proposta.getVeiculo().isBlindado()) {
			if (proposta.getVeiculo().isImportado()) {
				percentual += 0.0075;
			} else {
				percentual += 0.005;
			}
		} else {
			if (proposta.getVeiculo().isImportado()) {
				percentual += 0.0065;
			}
		}
		
		return percentual;
	}

}

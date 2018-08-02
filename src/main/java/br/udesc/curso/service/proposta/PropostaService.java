package br.udesc.curso.service.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.service.proposta.calculation.CoberturaCalculation;
import br.udesc.curso.vo.PropostaVO;

@Service
public class PropostaService {
	
	@Autowired
	private CoberturaCalculationFactory coberturaCalculationFactory;
	
	public double calcular(PropostaVO proposta) {
		double custo = 0.0;
		CoberturaCalculation calculation = null;
		
		for (Cobertura cobertura : proposta.getCoberturas()) {
			calculation = coberturaCalculationFactory.build(cobertura);			
			custo += calculation.calcular(proposta);
		}
		
		return custo;
	}

}

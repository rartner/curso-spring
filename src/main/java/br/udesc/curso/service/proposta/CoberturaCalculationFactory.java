package br.udesc.curso.service.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.service.proposta.calculation.AssistenciaCalculation;
import br.udesc.curso.service.proposta.calculation.CarroReservaCalculation;
import br.udesc.curso.service.proposta.calculation.CoberturaCalculation;
import br.udesc.curso.service.proposta.calculation.PerdaTotalCalculation;
import br.udesc.curso.service.proposta.calculation.TerceiroCalculation;
import br.udesc.curso.service.proposta.calculation.VidroCalculation;

@Component
public class CoberturaCalculationFactory {
	
	@Autowired
	private AssistenciaCalculation assistenciaCalculation;
	
	@Autowired
	private PerdaTotalCalculation perdaTotalCalculation;
	
	@Autowired
	private CarroReservaCalculation carroReservaCalculation;
	
	@Autowired
	private VidroCalculation vidroCalculation;
	
	@Autowired 
	private TerceiroCalculation terceiroCalculation;
	
	public CoberturaCalculation build(Cobertura cobertura) {
		switch (cobertura) {
			case ASSISTENCIA:
				return assistenciaCalculation;
			case CARRO_RESERVA:
				return carroReservaCalculation;
			case PERDA_TOTAL:			
				return perdaTotalCalculation;
			case TERCEIROS:
				return terceiroCalculation;
			case VIDROS:
				return vidroCalculation;	
			default:
				throw new IllegalArgumentException("[ERRO] Cálculo para a cobertura " + cobertura + "não implementado.");
		}
	}

}

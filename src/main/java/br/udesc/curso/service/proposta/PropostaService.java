package br.udesc.curso.service.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.model.Apolice;
import br.udesc.curso.repository.ApoliceRepository;
import br.udesc.curso.service.proposta.calculation.CoberturaCalculation;
import br.udesc.curso.vo.PropostaVO;

@Service
public class PropostaService {
	
	@Autowired
	private ApoliceRepository apoliceRepository;
	
	@Autowired
	private CoberturaCalculationFactory coberturaCalculationFactory;
	
	public Apolice calcular(PropostaVO proposta) {
		double custo = 0.0;
		CoberturaCalculation calculation = null;
		
		for (Cobertura cobertura : proposta.getCoberturas()) {
			calculation = coberturaCalculationFactory.build(cobertura);			
			custo += calculation.calcular(proposta);
		}
		
		Apolice apolice = new Apolice();
		apolice.setCliente(proposta.getCliente());
		apolice.setVeiculo(proposta.getVeiculo());
		apolice.setCoberturas(proposta.getCoberturas());
		apolice.setPreco(custo);
		
		apoliceRepository.saveAndFlush(apolice);
		
		return apolice;
	}

}

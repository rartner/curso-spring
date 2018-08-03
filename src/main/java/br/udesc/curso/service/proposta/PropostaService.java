package br.udesc.curso.service.proposta;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.model.Apolice;
import br.udesc.curso.model.Cliente;
import br.udesc.curso.repository.ApoliceRepository;
import br.udesc.curso.repository.ClienteRepository;
import br.udesc.curso.service.proposta.calculation.CoberturaCalculation;
import br.udesc.curso.vo.PropostaVO;

@Service
public class PropostaService {
	
	@Autowired
	private ApoliceRepository apoliceRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CoberturaCalculationFactory coberturaCalculationFactory;
	
	public Apolice calculate(PropostaVO proposta) {
		double custo = 0.0;
		CoberturaCalculation calculation = null;
		
		for (Cobertura cobertura : proposta.getCoberturas()) {
			calculation = coberturaCalculationFactory.build(cobertura);			
			custo += calculation.calcular(proposta);
		}
		
		Apolice apolice = new Apolice();
		Cliente cliente = clienteRepository.findByCpf(proposta.getCliente().getCpf());
		apolice.setCliente(cliente);
		apolice.setVeiculo(proposta.getVeiculo());
		apolice.setCoberturas(proposta.getCoberturas());
		apolice.setPreco(custo);
		
		apoliceRepository.saveAndFlush(apolice);
		
		return apolice;
	}
	
	public Apolice accept(long id) {
		Apolice apolice = null;
		
		try {
			apolice = apoliceRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Date inicioVigencia = new Date();
		apolice.setInicioVigencia(inicioVigencia);
		apolice.setFimVigencia(
				new Date(inicioVigencia.getYear() + 1,
						inicioVigencia.getMonth(),
						inicioVigencia.getDay())
				);
				
		apoliceRepository.saveAndFlush(apolice);
		
		return apolice;
	}

}

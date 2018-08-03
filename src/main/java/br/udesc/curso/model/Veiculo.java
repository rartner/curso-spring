package br.udesc.curso.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
	
	private int anoFabricacao;
	
	@Column(length=8)
	private String placa;
	
	private double valor;
	
	private boolean blindado;
	
	private boolean importado;

}

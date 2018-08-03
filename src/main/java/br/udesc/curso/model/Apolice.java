package br.udesc.curso.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.udesc.curso.enums.Cobertura;
import lombok.Data;

@Data
@Entity
public class Apolice {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="clienteid", referencedColumnName="id")
	private Cliente cliente;
	
	@Embedded
	private Veiculo veiculo;
		
	@ElementCollection(targetClass=Cobertura.class)
	@Enumerated(EnumType.STRING)
	private Set<Cobertura> coberturas;
	
	private double preco;
	
	@Column(insertable=false)
	@Temporal(TemporalType.DATE)
	private Date inicioVigencia;
	
	@Column(insertable=false)
	@Temporal(TemporalType.DATE)
	private Date fimVigencia;
}

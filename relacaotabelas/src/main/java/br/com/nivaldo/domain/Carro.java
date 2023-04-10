package br.com.nivaldo.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
	@SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "CODIGO", length = 10, nullable = false, unique = true)
	private String codigo;

	@Column(name = "DATA_CARRO", nullable = false)
	private Instant dataCarro;

	@Column(name = "valor", nullable = false)
	private Double valor;

	@Column(name = "status", nullable = false)
	private String status;

	@ManyToOne
	@JoinColumn(name = "id_marca_fk", foreignKey = @ForeignKey(name = "fk_marca_carro"), referencedColumnName = "id", nullable = false)
	private Marca marca;

	@OneToOne
	@JoinColumn(name = "id_acessorio_fk", foreignKey = @ForeignKey(name = "fk_acessorio_carro"), referencedColumnName = "id", nullable = false)
	private Acessorio acessorio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Instant getDataCarro() {
		return dataCarro;
	}

	public void setDataCarro(Instant dataCarro) {
		this.dataCarro = dataCarro;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}
}

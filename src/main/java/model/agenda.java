package model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="agendas")
public class agenda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private LocalDate data;
	private LocalTime hora;
	private String situacao;
	private LocalDate data_situacao;
	private String observacoes;
	
	@ManyToOne
	private usuario usuario;
	
	@ManyToOne
	private vacina vacina;
	
	public agenda() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public LocalDate getData_situacao() {
		return data_situacao;
	}

	public void setData_situacao(LocalDate data_situacao) {
		this.data_situacao = data_situacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public usuario getUsuario_id() {
		return usuario;
	}

	public void setUsuario_id(usuario usuario) {
		this.usuario = usuario;
	}

	public vacina getVacina_id() {
		return vacina;
	}

	public void setVacina_id(vacina vacina) {
		this.vacina = vacina;
	}
	
}

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
	private usuario usuario_id;
	
	@ManyToOne
	private vacina vacina_id;
	
	public agenda() {
		
	}

}

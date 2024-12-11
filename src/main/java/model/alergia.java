package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alergias")
public class alergia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;

	@ManyToMany
	@JoinTable(name = "usuarios_alergias", joinColumns = @JoinColumn(name = "id_alergia"), inverseJoinColumns = @JoinColumn(name = "id_usuario"))
	private List<usuario> usuarios = new ArrayList<>();

	public alergia() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addUsuario(usuario u) {
		this.usuarios.add(u);
	}

}
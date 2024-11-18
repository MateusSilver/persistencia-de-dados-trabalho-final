package model;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientBanco {
	private EntityManagerFactory emf;

	public ClientBanco() {
		this.emf = Persistence.createEntityManagerFactory("default");
	}

	public List<usuario> getAllUsers() {
		EntityManager em = emf.createEntityManager();
		try {
			String jpql = "SELECT c FROM usuario c";
			return em.createQuery(jpql, usuario.class).getResultList();
		} finally {
			em.close();
		}
	}

	public List<vacina> getAllVaccines() {
		EntityManager em = emf.createEntityManager();
		try {
			String jpql = "SELECT v FROM vacina v";
			return em.createQuery(jpql, vacina.class).getResultList();
		} finally {
			em.close();
		}
	}

	public List<usuario> getUserVaccines(usuario user){
		EntityManager em = emf.createEntityManager();
		try {
			String jpql = "SELECT a FROM agenda a WHERE a.usuario = :user";
			return em.createQuery(jpql, usuario.class).setParameter("user", user).getResultList();
		} finally {
			em.close();
		}
	}
	
	public List<vacina> getVaccineUsers(vacina vac){
		EntityManager em = emf.createEntityManager();
		try {
			String jpql = "SELECT a FROM agenda a WHERE a.vacina = :vac";
			return em.createQuery(jpql,vacina.class).setParameter("vac", vac).getResultList();
		} finally {
			em.close();
		}
	}
	
	public List<alergia> getAllAlergias(){
		EntityManager em = emf.createEntityManager();
		try {
			String jpql = "SELECT ale FROM alergia ale";
			return em.createQuery(jpql,alergia.class).getResultList();
		} finally {
			em.close();
		}
	}
	
	public List<alergia> getUserAlergiasById(int u){
		EntityManager em = emf.createEntityManager();
		try {
			String jpql = "SELECT ale FROM alergia ale WHERE ale.usuarios.id = :u";
			return em.createQuery(jpql,alergia.class).setParameter("u",u).getResultList();
		} finally {
			em.close();
		}
	}
}
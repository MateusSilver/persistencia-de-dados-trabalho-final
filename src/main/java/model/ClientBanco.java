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

    // ---- CRUD USUÁRIOS ----
    public void createUsuario(usuario user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public usuario getUsuario(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(usuario.class, id);
        } finally {
            em.close();
        }
    }

    public void deleteUsuario(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            usuario user = em.find(usuario.class, id);
            if (user != null) {
                em.remove(user);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // ---- CRUD VACINAS ----
    public void createVacina(vacina vac) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(vac);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public vacina getVacina(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(vacina.class, id);
        } finally {
            em.close();
        }
    }

    public void deleteVacina(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            vacina vac = em.find(vacina.class, id);
            if (vac != null) {
                em.remove(vac);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // ---- CRUD ALERGIAS ----
    public void createAlergia(alergia ale) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ale);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public alergia getAlergia(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(alergia.class, id);
        } finally {
            em.close();
        }
    }

    public void deleteAlergia(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            alergia ale = em.find(alergia.class, id);
            if (ale != null) {
                em.remove(ale);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // ---- CRUD AGENDAS ----
    public void createAgenda(agenda ag) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ag);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public agenda getAgenda(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(agenda.class, id);
        } finally {
            em.close();
        }
    }

    public void deleteAgenda(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            agenda ag = em.find(agenda.class, id);
            if (ag != null) {
                em.remove(ag);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
	
    // Métodos de listagem formatada
    public void listarUsuarios() {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT u FROM usuario u ORDER BY u.nome";
            List<usuario> usuarios = em.createQuery(jpql, usuario.class).getResultList();
            
            System.out.println("\n=== LISTAGEM DE USUÁRIOS ===");
            System.out.println("ID  | NOME                 | DATA NASC  | CIDADE");
            System.out.println("----------------------------------------------------");
            
            for(usuario u : usuarios) {
                System.out.printf("%-4d| %-20s| %-10s | %s\n",
                    u.getId(),
                    limitString(u.getNome(), 20),
                    u.getData_de_nascimento().toString(),
                    u.getCidade()
                );
            }
        } finally {
            em.close();
        }
    }

    public void listarVacinas() {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT v FROM vacina v ORDER BY v.titulo";
            List<vacina> vacinas = em.createQuery(jpql, vacina.class).getResultList();
            
            System.out.println("\n=== LISTAGEM DE VACINAS ===");
            System.out.println("ID  | TÍTULO              | DOSES | PERIODICIDADE");
            System.out.println("------------------------------------------------");
            
            for(vacina v : vacinas) {
                System.out.printf("%-4d| %-20s| %-6d | %d meses\n",
                    v.getId(),
                    limitString(v.getTitulo(), 20),
                    v.getDoses(),
                    v.getPeriodicidade()
                );
            }
        } finally {
            em.close();
        }
    }

    public void listarAlergias() {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT a FROM alergia a ORDER BY a.nome";
            List<alergia> alergias = em.createQuery(jpql, alergia.class).getResultList();
            
            System.out.println("\n=== LISTAGEM DE ALERGIAS ===");
            System.out.println("ID  | NOME");
            System.out.println("---------------------------");
            
            for(alergia a : alergias) {
                System.out.printf("%-4d| %s\n",
                    a.getId(),
                    a.getNome()
                );
            }
        } finally {
            em.close();
        }
    }

    public void listarAgendas() {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT a FROM agenda a ORDER BY a.data, a.hora";
            List<agenda> agendas = em.createQuery(jpql, agenda.class).getResultList();
            
            System.out.println("\n=== LISTAGEM DE AGENDAMENTOS ===");
            System.out.println("ID  | DATA       | HORA  | PACIENTE            | VACINA              | SITUAÇÃO");
            System.out.println("----------------------------------------------------------------------------");
            
            for(agenda a : agendas) {
                System.out.printf("%-4d| %-10s| %-6s| %-20s| %-20s| %s\n",
                    a.getId(),
                    a.getData().toString(),
                    a.getHora().toString(),
                    limitString(a.getUsuario_id().getNome(), 20),
                    limitString(a.getVacina_id().getTitulo(), 20),
                    a.getSituacao()
                );
            }
        } finally {
            em.close();
        }
    }

    // Método auxiliar para limitar tamanho das strings
    private String limitString(String str, int limit) {
        if (str == null) return "";
        return str.length() > limit ? str.substring(0, limit - 3) + "..." : str;
    }

	public List<agenda> getAgendasBySituacao(String situacao) {
		EntityManager em = emf.createEntityManager();
		try {
			String jpql = "SELECT a FROM agenda a WHERE a.situacao = :situacao ORDER BY a.data, a.hora";
			return em.createQuery(jpql, agenda.class)
					.setParameter("situacao", situacao)
					.getResultList();
		} finally {
			em.close();
		}
	}

	public List<agenda> getAgendasByMultiplasSituacoes(List<String> situacoes) {
		EntityManager em = emf.createEntityManager();
		try {
			String jpql = "SELECT a FROM agenda a WHERE a.situacao IN :situacoes ORDER BY a.data, a.hora";
			return em.createQuery(jpql, agenda.class)
					.setParameter("situacoes", situacoes)
					.getResultList();
		} finally {
			em.close();
		}
    }
}

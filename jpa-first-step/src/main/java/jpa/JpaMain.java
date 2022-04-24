package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Team team = new Team();
			team.setName("Team1");
			em.persist(team);
			
			Member member = new Member();
			member.setName("Member1");
			member.setTeam(team);
			em.persist(member);
			
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
		}finally {
			emf.close();
		}
	}
	
}
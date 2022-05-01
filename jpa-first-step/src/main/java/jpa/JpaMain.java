package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javassist.expr.Instanceof;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			Member member = new Member();
			member.setName("hello");
			member.setAddress(new Address("seoul","street","101"));
			member.setPeriod(new Period());
			em.persist(member);
			
			em.flush();
			em.clear();
			

			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
		}finally {
			emf.close();
		}
	}
	
}

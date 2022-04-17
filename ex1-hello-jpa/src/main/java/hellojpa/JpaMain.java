package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction ts = em.getTransaction();
		ts.begin();
		try {
			
			//저장
			Member member = new Member();
			member.setName("태현");
			em.persist(member);
			em.flush();
			em.clear();
			
			
			ts.commit();
		}catch (Exception e) {
			ts.rollback();
		}finally {
			em.close();
			emf.close();
		}
	}
	
}

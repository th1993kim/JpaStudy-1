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
			Team team =new Team();
			team.setName("TeamA");
			em.persist(team);
//			team.getMembers().add(member);
			
			Member member = new Member();
			member.setUsername("member2");
//			member.changeTeam(team);
			em.persist(member);

			team.addMember(member);
			
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

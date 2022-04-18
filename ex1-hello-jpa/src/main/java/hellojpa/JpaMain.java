package hellojpa;

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
			
			Movie movie = new Movie();
			movie.setDirector("aaaa");
			movie.setActor("bbbb");
			movie.setName("바람과 함께 사라지다");
			movie.setPrice(100000);
			
			//저장
			em.persist(movie);
			em.flush();
			em.clear();
			
			Movie findMovie = em.find(Movie.class, movie.getId());
			System.out.println("findMovie" + findMovie);
			
			
			ts.commit();
		}catch (Exception e) {
			ts.rollback();
		}finally {
			em.close();
			emf.close();
		}
	}
	
}

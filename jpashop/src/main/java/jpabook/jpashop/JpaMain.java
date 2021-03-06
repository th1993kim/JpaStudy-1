package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.jpashop.domain.Book;


public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction ts = em.getTransaction();
		ts.begin();
		try {
			Book book = new Book();
			book.setName("JPX");
			book.setAuthor("태현");
			em.persist(book);
			
			ts.commit();
		}catch (Exception e) {
			ts.rollback();
		}finally {
			em.close();
			emf.close();
		}
	}
}

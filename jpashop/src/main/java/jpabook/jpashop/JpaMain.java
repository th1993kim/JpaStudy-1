package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;


public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction ts = em.getTransaction();
		ts.begin();
		try {
			Order order = new Order();
			order.addOrderItem(new OrderItem());
			ts.commit();
		}catch (Exception e) {
			ts.rollback();
		}finally {
			em.close();
			emf.close();
		}
	}
}

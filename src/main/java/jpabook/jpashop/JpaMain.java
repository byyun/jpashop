package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();


		try {
			/*
			Order order = new Order();
			order.addOrderItem(new OrderItem());

			 */
			/*
			em.persist(order);

			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);

			em.persist(orderItem);

			 */
			Book book = new Book();
			book.setName("JPA");
			book.setAuthor("bokbok");
			em.persist(book);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}


		emf.close();
	}
}

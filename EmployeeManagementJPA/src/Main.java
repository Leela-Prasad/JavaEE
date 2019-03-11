import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeDB");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//Employee employee = new Employee("user1", "sur1", "Test", 1100);
		//em.persist(employee);
		
		Query q = em.createQuery("select employee from Employee employee");
		List<Employee> employees = q.getResultList();
		System.out.println(employees);
		
		tx.commit();
		em.close();
	}

}

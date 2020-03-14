package business;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import persistence.Employee;

public class ManageEmployee {
	
	private static SessionFactory factory; 

	public static void main(String[] args) {
		
		try{
			factory = new Configuration().configure().buildSessionFactory();
	    } catch (Throwable e) { 
	        throw e; 
	    }
	    
		ManageEmployee me = new ManageEmployee();
		
		/* Add few employee records in database */
	    Integer empID1 = me.addEmployee("fname1", "lname1", 1000);
	    Integer empID2 = me.addEmployee("fname2", "lname2", 5000);
	    Integer empID3 = me.addEmployee("fname3", "lname3", 10000);

	}
	
	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String fname, String lname, int salary){
		Session session = factory.openSession();
		Transaction tx = null;
	    Integer employeeID = null;
	      try {
	         tx = session.beginTransaction();
	         Employee employee = new Employee(fname, lname, salary);
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return employeeID;
	   }
	
	   /* Method to  READ all the employees */
	   public void listEmployees( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List employees = session.createQuery("FROM Employee").list(); 
	         for (Iterator iterator = employees.iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next(); 
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println("  Salary: " + employee.getSalary()); 
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }

}

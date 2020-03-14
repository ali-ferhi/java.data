package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Employee;

public class CreateEmployee {
	
	   public static void main( String[ ] args ) {
		   
		      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("punit1");
		      
		      EntityManager entitymanager = emfactory.createEntityManager( );
		      entitymanager.getTransaction( ).begin( );

		      Employee employee = new Employee( ); 
		      employee.setFirstName( "fname4" );
		      employee.setLastName( "lname4" );
		      employee.setSalary(400);
		      
		      entitymanager.persist( employee );
		      entitymanager.getTransaction( ).commit( );

		      entitymanager.close( );
		      emfactory.close( );
		   }

}

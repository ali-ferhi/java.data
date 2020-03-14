package one;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
	
	public static void main(String[] args) {
		
		String[] springConfig  =  {"one/springContext1.xml"};  
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext(springConfig);
	    
	    Service1 service1 = (Service1) springContext.getBean("service1");
	    service1.read2ViaDaoImpl();
	    springContext.close();
		
	}

}

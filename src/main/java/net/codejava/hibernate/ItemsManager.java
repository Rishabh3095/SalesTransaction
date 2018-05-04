package net.codejava.hibernate;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ItemsManager {
	
	//
    protected SessionFactory sessionFactory;
    
    protected void setup() {
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    }
 
    protected void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
    }
 
    protected void create() {
        // code to save
    	SalesTransaction satr = new SalesTransaction();
       
        Date date = new Date();  
        
    	satr.setDate(date);
    	satr.setProductName("Headset");
    	satr.setQuantity(20);
    	satr.setTotalCost(120);
    	satr.setUnitCost(6);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(satr);
        
     
        session.getTransaction().commit();
        session.close();
    }
 
    protected void read() {
        // code to get a book
    }
 
    protected void update() {
        // code to modify a book
    }
 
    protected void delete() {
        // code to remove a book
    }
 
    public static void main(String[] args) {
        // code to run the program
        ItemsManager manager = new ItemsManager();
        manager.setup();
        manager.create();
        manager.exit();
    }
}
package net.codejava.hibernate;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SalesManager {
	
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
       
    	boolean inputCheck = false;
    	Scanner numb = new Scanner(System.in);
    	Scanner str = new Scanner(System.in);
    	
    	System.out.println("Enter the name of the product: ");
    	
    	String prodName = "";
    	while(!inputCheck)
    	{
        	prodName = str.nextLine();
        	if(!prodName.trim().equals(""))
        		System.out.println("Please enter valid input: ");
        	inputCheck = true;
    	}
    	
    	System.out.println("Enter the quantity: ");
    	
    	int quantity = numb.nextInt();    			
    	
    	System.out.println("Enter the total cost of the bulk: ");
    	int totalCost = numb.nextInt();
    	System.out.println("Enter the cost per piece: ");
    	int unitCost = numb.nextInt();
    	
    	Date date = new Date();
    	satr.setDate(date);
    	satr.setProductName(prodName);
    	satr.setQuantity(quantity);
    	satr.setTotalCost(totalCost);
    	satr.setUnitCost(unitCost);
    	
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(satr);
        
        numb.close();
        str.close();
        session.getTransaction().commit();
        session.close();
    }
 
    protected void read() throws ParseException {
        // code to get
    	
    	Scanner in = new Scanner(System.in);
    	
    	System.out.println("Enter the details for the first date: ");
    	System.out.println("Enter the year: ");
    	int year = in.nextInt();
    	System.out.println("Enter the month: ");
    	int month = in.nextInt();
    	System.out.println("Enter the date: ");
    	int d = in.nextInt();
    	Month m = Month.of(month);

    	LocalDate localid = LocalDate.of(year, m, d);
        java.sql.Date date1 = java.sql.Date.valueOf(localid);

    	System.out.println("Enter the details for the second date: ");
    	System.out.println("Enter the year: ");
    	int year2 = in.nextInt();
    	System.out.println("Enter the month: ");
    	int month2 = in.nextInt();
    	System.out.println("Enter the date: ");
    	int d2 = in.nextInt();
    	Month m2 = Month.of(month2);

    	LocalDate localid2 = LocalDate.of(year2, m2, d2);
        java.sql.Date date2 = java.sql.Date.valueOf(localid2);
        
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
    	
        
        //get all the dates from the date1 to date2
        
    	SalesTransaction input = session.get(SalesTransaction.class, date2);
    	
    	System.out.println("Date: "+input.getDate());
    	System.out.println("Product Name: "+input.getProductName());
    	System.out.println("Total Quantity: "+input.getQuantity());
    	System.out.println("Bulk Cost: "+input.getTotalCost());
    	System.out.println("Unit Cost: "+input.getUnitCost());
    	

    	in.close();
        session.getTransaction().commit();
        session.close();
        
    }
 
    protected void update() {
        // code to modify a book
    }
 
    protected void delete() {
        // code to remove a book
    }
 
    public static void main(String[] args) throws ParseException {
        // code to run the program
        SalesManager manager = new SalesManager();
        manager.setup();
        manager.create();
        manager.read();
        manager.exit();
    }
}
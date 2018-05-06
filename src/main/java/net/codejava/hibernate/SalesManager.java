package net.codejava.hibernate;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

public class SalesManager {
	
	//
    protected static SessionFactory sessionFactory;
	protected static Session session;
	static Scanner numb = new Scanner(System.in);
	static Scanner str = new Scanner(System.in);



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
 
    protected static void create() {
        // code to save
    	SalesTransaction satr = new SalesTransaction();
       
        session = sessionFactory.openSession();
        session.beginTransaction();

    	
    	System.out.println("Enter the name of the product: ");
    	
    	String prodName = "";
    	
    	prodName = str.nextLine();
    	
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
    	
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
     
        session.save(satr);
        session.getTransaction().commit();
        session.close();
    }
 
	/**
	*Prints out the search interface
	*/
	public static void displaySearchInterface()
	{
		System.out.println();
		System.out.println("Please select an option from the menu:");
		System.out.println("=======================");
		System.out.println("|1. Create a Sales Transaction	");
		System.out.println("|2. Search one transaction	");
		System.out.println("|3. Search transactions from one day		");
		System.out.println("|4. Search transactions made between two dates				");
		System.out.println("|5. Quit/Log Out...				");
		System.out.println("=======================");
	}

     
    private static void readMultipleDates() {
    	
		// TODO Auto-generated method stub
    	
        session = sessionFactory.openSession();
        session.beginTransaction();

    	
    	System.out.println("Please enter the name of the product: ");
    	String prodName = str.nextLine();
    	
//    	System.out.println("Enter the details for the first date: ");
//    	System.out.println("Enter the year: ");
//    	int year = in.nextInt();
//    	System.out.println("Enter the month: ");
//    	int month = in.nextInt();
//    	System.out.println("Enter the date: ");
//    	int d = in.nextInt();
//    	Month m = Month.of(month);

    	LocalDate localid = LocalDate.of(2018, 05, 04);
        java.sql.Date date1 = java.sql.Date.valueOf(localid);

//    	System.out.println("Enter the details for the second date: ");
//    	System.out.println("Enter the year: ");
//    	int year2 = in.nextInt();
//    	System.out.println("Enter the month: ");
//    	int month2 = in.nextInt();
//    	System.out.println("Enter the date: ");
//    	int d2 = in.nextInt();
//    	Month m2 = Month.of(month2);

    	LocalDate localid2 = LocalDate.of(2018, 05, 05);
        java.sql.Date date2 = java.sql.Date.valueOf(localid2);
        	
        Criteria criteria = session.createCriteria(SalesTransaction.class)
           .add(Restrictions.between("date", date1, date2));
        
        List<SalesTransaction> result = criteria.list();
        
        //get all the dates from the date1 to date2
        for(SalesTransaction input: result)
        {        	
        	if(input.getProductName().equals(prodName))
        	{
            	System.out.println("Date: "+input.getDate());
            	System.out.println("Product Name: "+input.getProductName());
            	System.out.println("Total Quantity: "+input.getQuantity());
            	System.out.println("Bulk Cost: "+input.getTotalCost());
            	System.out.println("Unit Cost: "+input.getUnitCost());        		
        	}
        }
    	
        session.getTransaction().commit();
        session.close();		
	}

	private static void readOneDate() {
		// TODO Auto-generated method stub
        session = sessionFactory.openSession();
        session.beginTransaction();

     	System.out.println("Please enter the name of the product: ");
    	String prodName = str.nextLine();
//    	
//    	System.out.println("Enter the details for the first date: ");
//    	System.out.println("Enter the year: ");
//    	int year = in.nextInt();
//    	System.out.println("Enter the month: ");
//    	int month = in.nextInt();
//    	System.out.println("Enter the date: ");
//    	int d = in.nextInt();
//    	Month m = Month.of(month);

    	LocalDate localid = LocalDate.of(2018, 05, 05);
        java.sql.Date date1 = java.sql.Date.valueOf(localid);

        	
        Criteria criteria = session.createCriteria(SalesTransaction.class)
           .add(Restrictions.eq("date",  date1));
        
        List<SalesTransaction> result = criteria.list();
        
        //get all the dates from the date1 to date2
        for(SalesTransaction input: result)
        {        	
        	if(input.getProductName().equals(prodName))
        	{
            	System.out.println("Date: "+input.getDate());
            	System.out.println("Product Name: "+input.getProductName());
            	System.out.println("Total Quantity: "+input.getQuantity());
            	System.out.println("Bulk Cost: "+input.getTotalCost());
            	System.out.println("Unit Cost: "+input.getUnitCost());        		
        	}
        }
    	
        session.getTransaction().commit();
        session.close();			
	}

	private static void readOneTransaction() {
		// TODO Auto-generated method stub
		
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

    	boolean userInput = true;
    	
    	
    	while(userInput)
    	{
        	displaySearchInterface();
        	
        	String choice = str.nextLine().trim();
            
    		int userChoice = Integer.parseInt(choice);
    		
    		switch (userChoice)
    		{
    			case 1: create();
    					break;
    			case 2: readOneTransaction();
    					break;
    			case 3: readOneDate();
    					break;
    			case 4: readMultipleDates();
    					break;
    			case 5: System.out.println("Logging out...");
						userInput = false;
						break;
    			default:System.out.println("Not a valid option");
						break;
				
    		}
    	}
    	manager.exit();
    }
}
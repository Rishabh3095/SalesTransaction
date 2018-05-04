package net.codejava.hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "items")

public class Items {
	
	int iID;
	String Name;
	double Price;
	String Description;
	String Category;
	int Stock;
	
	public Items()
	{
		
	}
	
    @Id
    @Column(name = "iID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getiID() {
		return iID;
	}
	
    public void setiID(int iID) {
		this.iID = iID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}

	
}

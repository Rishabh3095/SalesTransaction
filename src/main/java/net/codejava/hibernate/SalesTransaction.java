package net.codejava.hibernate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "sales")

public class SalesTransaction {
	
	Date date;
	String ProductName;
	int Quantity;
	int UnitCost;
	int TotalCost;
	
	
	public SalesTransaction()
	{	
	}
	
    @Id
    @Column(name = "Date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getUnitCost() {
		return UnitCost;
	}
	public void setUnitCost(int unitCost) {
		UnitCost = unitCost;
	}
	public int getTotalCost() {
		return TotalCost;
	}
	public void setTotalCost(int totalCost) {
		TotalCost = totalCost;
	}
	
	
}

package net.codejava.hibernate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "sales")

public class SalesTransaction {
	@Id
        @Column(name = "Date")
	Date date;
        @Column(name = "ProductName")
	String ProductName;
        @Column(name = "Quantity")
	int Quantity;
        @Column(name = "UnitCost")
	int UnitCost;
        @Column(name = "TotalCost")
	int TotalCost;
	
	
	public SalesTransaction()
	{	
	}
	
    
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

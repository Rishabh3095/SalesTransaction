package net.codejava.hibernate;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

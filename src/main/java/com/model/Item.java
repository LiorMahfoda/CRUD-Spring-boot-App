package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
@Entity
@Table(name = "ITEMS")
public class Item { 
	@Id
	@SequenceGenerator(name= "ITEM_SEQUENCE", sequenceName = "ITEM_SEQUENCE_ID", initialValue=100, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="ITEM_SEQUENCE")
	private int itemno;
  
	@Column(name = "name", nullable=false)
 	private String name;
  
	@Column(name = "amount", nullable=false)
	private int amount;
  
	@Column(name = "inventorycode", nullable=false)
	private String inventory_code;
 	
	public Item() {}
	
	public Item(int itemno, String name, int amount, String inventory_code){
		this.itemno=itemno;
		this.name=name;
		this.amount=amount;
		this.inventory_code=inventory_code;
	}
	
	public int getItem_no() {
		return itemno;
	}
 
	public void setItem_no(int itemno) {
		this.itemno = itemno;
	}
 	
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public int getAmount() {
		return amount;
 }
 
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
 
	public String getInventory_code() {
		return inventory_code;
	}
 
	public void setInventory_code(String inventory_code) {
		this.inventory_code = inventory_code;
	}
	
	 @Override
	 public String toString() {
		 return "Item [item_no = " + itemno + ", name = " + name + ", amount = " + amount + ", inventory_code = " + inventory_code + "]";
	 }
}

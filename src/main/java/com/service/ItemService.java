package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.Item;
import com.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepository;
	
	public List<Item> getAllItems(){
		return  itemRepository.findAll();
	}
	
	public Optional<Item> getItemById(Integer id){
		return itemRepository.findById(id);
	}
	
	public void AddItem(Item item) {
		itemRepository.save(item);
	}

	public void deleteItem(Integer id) throws ResourceNotFoundException {
		if (itemRepository.findById(id)!= null) // if item exists in db
			itemRepository.deleteById(id);
		else
			throw new ResourceNotFoundException("item id's not found");
		
	}
	
	public void UpdateItem(Item item) {
		itemRepository.save(item);
		
	}
	
	public void depositItem(Integer id, Integer amount) throws ResourceNotFoundException {
		try {
			Item item = itemRepository.getOne(id); // get item by id
			if (amount > 0) {
				item.setAmount(item.getAmount() + amount);
				itemRepository.save(item);   
			}
			else
				throw new ResourceNotFoundException("amount most be a positive number");
		}
		catch(Exception e) { // for not integer type in amount field
				e.getMessage();
		}
	}
	
	public void withdrawItem(Integer id, Integer amount) throws ResourceNotFoundException {
		try {
			Item item = itemRepository.getOne(id);
			int current = item.getAmount();
			int count  = current - amount;
			if (count >= 0 && amount > 0) { // validate field
				item.setAmount(item.getAmount() - amount);
				itemRepository.save(item); //this.UpdateItem(item) //can use this instead
			}			
			else
				throw new ResourceNotFoundException("Amount must be a positive number. " + 
						"current amount is "+ current + " the and field is " + amount);
		}
		catch(Exception e) { // for not integer type in amount field
			e.getMessage();
		}	
	}
}

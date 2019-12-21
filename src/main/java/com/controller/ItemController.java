package com.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.ResourceNotFoundException;
import com.model.Item;
import com.service.ItemService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class ItemController {
	@Autowired
    private ItemService itemService;
	
	/**
	 * This method retrieves all the items
	 * @return a List of objects(Items)
	 */
	@GetMapping("/Items")
    public List<Item> getAllitems(){
    	return itemService.getAllItems();
    }
	
	/**
	 * 
	 * @param id - Item's item no field id db
	 * @return the Item which was found. Otherwise null
	 */
	@GetMapping("Items/{id}")
	public Optional<Item> getItemById(@PathVariable Integer id){
		return itemService.getItemById(id); 	
	}
	
	/**
	 * This method adds an Item to db
	 * @param item
	 */
	@PostMapping("/Items/addItem")
	public void AddItem(@RequestBody Item item) {
		itemService.AddItem(item);
	}
	
	/**
	 * This method deletes an Item by id to db
	 * @param item
	 * @throws ResourceNotFoundException 
	 */
	@DeleteMapping("/Items/{id}/deleteItem")
	public void DeleteItemById(@PathVariable Integer id) throws ResourceNotFoundException {
		itemService.deleteItem(id);
	}
	
	/**
	 *Removed - to not view in the Swagger controller
	 **/
	/**
	 * @param item
	 * Enable to update the entire object
	 */
	@PutMapping("/Items/{id}/updateItem")
	public void UpdateItem(@RequestBody Item item ) {
		itemService.UpdateItem(item);
	}
	
	/**
	 * This Method adds amount to a specific item(by id)
	 * @param id - Item's id
	 * @param amount - to add in the field
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/Items/{id}/depositAmount")
	public void depositAmount(@PathVariable Integer id, @RequestBody Integer amount) throws ResourceNotFoundException {
		itemService.depositItem(id, amount);
	}
	
	/**
	 * This Method subtracts amount of a specific item(by id)
	 * @param id - Item's id
	 * @param amount - to subtract in the field
	 * @throws ResourceNotFoundException if number is below 0
	 */
	@PutMapping("/Items/{id}/withdrowAmount")
	public void withdrowAmount(@PathVariable Integer id, @RequestBody Integer amount) throws ResourceNotFoundException {
		itemService.withdrawItem(id, amount);
	}
	  
}
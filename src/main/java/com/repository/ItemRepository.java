package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
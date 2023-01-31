package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;
import java.util.List;
public interface customerRepository extends CrudRepository<customer, Long> {
    List<customer> findByLastName(String lastName);
    customer findById(long id);
    customer deleteById(long id);

}


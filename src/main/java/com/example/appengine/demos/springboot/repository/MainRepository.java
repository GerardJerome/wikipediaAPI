package com.example.appengine.demos.springboot.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.appengine.demos.springboot.model.MainTable;

public interface MainRepository extends CrudRepository<MainTable, Integer> {

}

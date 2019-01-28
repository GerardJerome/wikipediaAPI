package com.example.appengine.demos.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.appengine.demos.springboot.model.MainTable;
import com.example.appengine.demos.springboot.repository.MainRepository;

@Service
public class MainTableService implements IMainTableService{
	

@Autowired MainRepository mainRepo;
	@Override
	public List<MainTable> findAll() {
		return (List<MainTable>)mainRepo.findAll();
	}
	@Override
	public void save(MainTable main) {
		mainRepo.save(main);
	}

}

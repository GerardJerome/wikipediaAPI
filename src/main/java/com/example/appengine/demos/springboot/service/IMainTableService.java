package com.example.appengine.demos.springboot.service;

import java.util.List;

import com.example.appengine.demos.springboot.model.MainTable;

public interface IMainTableService {
	public List<MainTable> findAll();
	public void save(MainTable main);

}

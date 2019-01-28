/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appengine.demos.springboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appengine.demos.springboot.model.MainTable;
import com.example.appengine.demos.springboot.repository.MainRepository;
import com.example.appengine.demos.springboot.service.IMainTableService;
import com.example.appengine.demos.springboot.service.MainTableService;
import com.example.appengine.demos.springboot.service.WikipediaService;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.CompositeFilter;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;

@RestController

public class HelloworldController {
	
	private WikipediaService wikipediaService = new WikipediaService();
	@Autowired MainTableService mainRepo;
	@CrossOrigin(origins = "*")	
  @RequestMapping("/find/{name}")
  public String hello(@PathVariable String name) {
	  
    try {
    	mainRepo.save(new MainTable( name));
		return wikipediaService.getInfoBox(name);
	} catch (IOException e) {
		e.printStackTrace();
	}
    return "nothing";
  }
  
  
}

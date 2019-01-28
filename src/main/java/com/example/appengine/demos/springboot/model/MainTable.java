package com.example.appengine.demos.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="main")
public class MainTable {

	@Id
	@SequenceGenerator (name = "main_id_sequence", sequenceName = "main_id_seq", allocationSize = 1)

	@GeneratedValue(strategy = GenerationType.AUTO, generator="main_id_sequence")
//	@SequenceGenerator(name = "mySeqGen", sequenceName = "SEQUENCE_ID_MAIN", initialValue = 1, allocationSize = 3)

	@Column
	Integer id ;
	@Column
	String title;
	
	
	public MainTable() {
		super();
	}
	
	
	public MainTable(String title) {
		super();
		this.title = title;
	}


	public MainTable(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}

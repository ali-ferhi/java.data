package it.infinispan1.model;

import java.io.Serializable;

public class Entity1 implements Serializable {
	
	private Integer id;
	
	private String name;
	
	public Entity1() {
		super();
	}

	public Entity1(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId( ) {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

}

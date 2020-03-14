package one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table4")
public class Entity4 {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "key")
	private String key;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "table1_id")
	private Integer entity1Id;

	
	public Entity4() {
		super();
	}	
	
	public Entity4(Integer id, String key, String value, Integer entity1Id) {
		super();
		this.id = id;
		this.key = key;
		this.value = value;
		this.entity1Id = entity1Id;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Integer getEntity1Id() {
		return entity1Id;
	}

	public void setEntity1Id(Integer entity1Id) {
		this.entity1Id = entity1Id;
	}

}

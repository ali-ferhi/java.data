package one;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "table2")
public class Entity2 {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "key")
	private String key;
	
	@Column(name = "value")
	private String value;

	//@Access(AccessType.FIELD)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "table1_id", referencedColumnName = "id")
	private Entity1 entity1;
	
	public Entity2() {
		super();
	}
	
	public Entity2(Integer id, String key, String value, Entity1 entity1) {
		super();
		this.id = id;
		this.key = key;
		this.value = value;
		this.entity1 = entity1;
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

	public Entity1 getEntity1() {
		return entity1;
	}

	public void setEntity1(Entity1 entity1) {
		this.entity1 = entity1;
	}

}


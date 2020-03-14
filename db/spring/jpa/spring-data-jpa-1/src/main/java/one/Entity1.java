package one;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "table1")
public class Entity1 {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "key")
	private String key;
	
	@Column(name = "value")
	private String value;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "entity1")
	private Entity2 entity2;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "entity1")
	private List<Entity3> entity3;
	
	public Entity1() {
		super();
	}	
	
	public Entity1(Integer id, String key, String value, Entity2 entity2, List<Entity3> entity3) {
		super();
		this.id = id;
		this.key = key;
		this.value = value;
		this.entity2 = entity2;
		this.entity3 = entity3;
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
	
	public Entity2 getEntity2() {
		return entity2;
	}

	public void setEntity2(Entity2 entity2) {
		this.entity2 = entity2;
	}
	
	public List<Entity3> getEntity3() {
		if(entity3 == null) {
			entity3 = new ArrayList<>();
		}
		return entity3;
	}

	public void setEntity3(List<Entity3> entity3) {
		this.entity3 = entity3;
	}

}


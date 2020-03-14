package one;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity1Dao extends CrudRepository<Entity1, Integer> {

}

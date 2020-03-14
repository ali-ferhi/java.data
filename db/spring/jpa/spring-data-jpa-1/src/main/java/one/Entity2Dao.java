package one;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity2Dao extends CrudRepository<Entity2, Integer> {

}

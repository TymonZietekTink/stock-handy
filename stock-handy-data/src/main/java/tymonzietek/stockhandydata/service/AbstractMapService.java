package tymonzietek.stockhandydata.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tymonzietek.stockhandydata.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID> {

  protected Map<ID, T> map = new HashMap<>();

  protected Set<T> findAll(){
    return new HashSet<>(map.values());
  }

  protected T findById(ID id) {
    return map.get(id);
  }

  protected T save(ID id, T object){
    map.put(id, object);

    return object;
  }

  protected void deleteById(ID id){
    map.remove(id);
  }

  protected void delete(T object){
    map.entrySet().removeIf(entry -> entry.getValue().equals(object));
  }

}

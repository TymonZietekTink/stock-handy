package tymonzietek.stockhandydata.service.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import tymonzietek.stockhandydata.model.FinancialInstitution;
import tymonzietek.stockhandydata.service.AbstractMapService;
import tymonzietek.stockhandydata.service.FinancialInstitutionService;

@Service
public class FinancialInstitutionMap extends AbstractMapService<FinancialInstitution,Long> implements
    FinancialInstitutionService {

  @Override
  public FinancialInstitution save(FinancialInstitution object) {
    return super.save(object.getId(),object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }


  @Override
  public Set<FinancialInstitution> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(FinancialInstitution object) {
    super.delete(object);
  }

  @Override
  public FinancialInstitution findById(Long id) {
    return findById(id);
  }
}

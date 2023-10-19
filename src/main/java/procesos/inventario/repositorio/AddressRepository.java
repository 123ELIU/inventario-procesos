package procesos.inventario.repositorio;

import org.springframework.data.repository.CrudRepository;
import procesos.inventario.model.Address;
//interfaces
public interface AddressRepository extends CrudRepository<Address, Long> {
}

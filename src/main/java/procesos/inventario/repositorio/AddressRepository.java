package procesos.inventario.repositorio;

import org.springframework.data.repository.CrudRepository;
import procesos.inventario.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}

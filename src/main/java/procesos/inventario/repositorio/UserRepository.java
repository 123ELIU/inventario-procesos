package procesos.inventario.repositorio;

import org.springframework.data.repository.CrudRepository;
import procesos.inventario.model.User;

import java.util.List;

public interface UserRepository  extends CrudRepository<User,Long> {
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
}

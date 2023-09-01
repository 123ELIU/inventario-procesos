package procesos.inventario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import procesos.inventario.model.User;

@RestController
public class UserController {
    @GetMapping("users/{id}")

    public User getUserById(@PathVariable Long id){
      User user = new User(id,"eliu","felizzola","calle 20","efelizzolap@ufpso.edu.co","313783737","12345","1064116193");
      return user;
    }

}

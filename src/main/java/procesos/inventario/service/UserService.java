package procesos.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procesos.inventario.model.User;
import procesos.inventario.repositorio.UserRepository;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User updateUser(User user, Long id) {
        if (userRepository.existsById(id)) {
            User userBd = userRepository.findById(id).get();
            userBd.setLastName(user.getLastName());
            userBd.setAddress(user.getAddress());
            userBd.setDocument(user.getDocument());
            userBd.setEmail(user.getEmail());
            userBd.setPhone(user.getPhone());
            return userRepository.save(userBd);


        }
        return null;
    }
    public Boolean deleteUserById(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}



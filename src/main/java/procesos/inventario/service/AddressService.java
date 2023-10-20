package procesos.inventario.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procesos.inventario.exceptions.AddressNotFoundException;
import procesos.inventario.exceptions.UserNotFoundException;
import procesos.inventario.model.Address;
import procesos.inventario.model.User;
import procesos.inventario.repositorio.AddressRepository;

import java.util.List;
import java.util.Optional;
//address s
@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserService userService;
    public Address createAddress(Address address, Long idUser){

        if (idUser == null || idUser == 0)
                throw new UserNotFoundException("User Id is null");

        try {
            User user = userService.getUserById(idUser);
            address.setUser(user);
            return addressRepository.save(address);

       } catch (Exception e){
            throw new UserNotFoundException("User not found");
    }}
    public Address disabledAddress(Long id){
        Optional<Address> address = addressRepository.findById(id);
        if(address.isEmpty()){
            throw new RuntimeException("Address not fun");
        }
        address.get().setStatus(Boolean.FALSE);
        return addressRepository.save(address.get());
    }
    public Address getAddressById(Long id){
        if (id== null || id== 0){
            throw new AddressNotFoundException("Address id not found");
        }
        Optional<Address> address = addressRepository.findById(id);
        if(address.isEmpty()){
            throw new AddressNotFoundException("Address not fun");
        }
        address.get().setStatus(Boolean.FALSE);
        return addressRepository.save(address.get());
    }
    public List<Address> getAllAddress(){
        List<Address> address = (List<Address>)  addressRepository.findAll();
        if(address.isEmpty()){
            throw new RuntimeException("Address not fun");
        }
        return address;
    }

}

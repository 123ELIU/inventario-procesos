package procesos.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import procesos.inventario.model.Address;
import procesos.inventario.service.AddressService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdressController {
    @Autowired
    private AddressService addressService;
    @PostMapping("address/{idUser}")

    public ResponseEntity create(@Validated @RequestBody Address address, @PathVariable Long idUser){
        return new ResponseEntity<>(addressService.createAddress(address, idUser), HttpStatus.CREATED);
    }
    @PutMapping("address/{id}")
    public  ResponseEntity disabled(@PathVariable Long id){
        return ResponseEntity.ok(addressService.disabledAddress(id));
    }
    @GetMapping("address/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getAddressById(id));
    }
    @GetMapping("address")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(addressService.getAllAddress());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
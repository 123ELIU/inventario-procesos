package procesos.inventario.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException(String address_not_found) {
        super(address_not_found);
    }
}

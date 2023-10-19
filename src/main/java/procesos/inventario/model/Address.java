package procesos.inventario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

@Entity
@Data

public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @jakarta.validation.constraints.NotNull(message = "street address is required")
    @Size(max = 100, message = "street address max 100 characters")
    private String StreetAddress;
    @jakarta.validation.constraints.NotNull(message = "city is required")
    @Size(max = 100, message = "city max 100 characters")
    private String city;
    @jakarta.validation.constraints.NotNull(message = "state is required")
    @Size(max = 100, message = "state max 100 characters")
    private String state;
    @NotNull(message = "postal code is required")
    @Size(min = 1, max = 10, message = "postal code max 100 characters")
    private String postalCode;
    @JsonIgnore
    private Boolean status = Boolean.TRUE;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;

}

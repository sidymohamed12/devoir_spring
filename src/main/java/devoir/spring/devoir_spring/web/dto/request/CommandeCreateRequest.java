package devoir.spring.devoir_spring.web.dto.request;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandeCreateRequest {
    private Integer id;
    private Double montant;
    private LocalDateTime date = LocalDateTime.now();

}

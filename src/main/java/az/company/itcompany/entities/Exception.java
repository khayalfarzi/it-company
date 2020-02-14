package az.company.itcompany.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Exception {

    private int code;
    private String message;
}

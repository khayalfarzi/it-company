package az.company.itcompany.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Email {

    private String from;
    private String to;
    private String link;
}

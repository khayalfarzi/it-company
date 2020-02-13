package az.company.itcompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ItCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItCompanyApplication.class, args);
    }

}

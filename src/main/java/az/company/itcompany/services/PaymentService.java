package az.company.itcompany.services;

import az.company.itcompany.repository.PaymentRepo;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepo paymentRepo;

    public PaymentService(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }
}

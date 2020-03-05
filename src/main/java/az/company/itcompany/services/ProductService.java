package az.company.itcompany.services;

import az.company.itcompany.repository.ProductRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
}

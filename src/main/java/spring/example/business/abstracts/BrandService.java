package spring.example.business.abstracts;

import java.util.List;

import spring.example.entities.concretes.Brand;

public interface BrandService {
 //iş kuralları
	List<Brand> getAll();
}

package spring.example.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import spring.example.dataAccess.abstracts.BrandRepository;
import spring.example.entities.concretes.Brand;

@Repository //bu sınıf bir dataAccess nesnesidir
public class InMemoryBrandRepository implements BrandRepository {

	List<Brand> brands;

	public InMemoryBrandRepository() {
		brands = new ArrayList<Brand>();
		brands.add(new Brand("mercedes", 1));
		brands.add(new Brand("bmw", 2));
		brands.add(new Brand("renault", 3));
		brands.add(new Brand("dacia", 4));
		brands.add(new Brand("audi", 5));

	}
	
	@Override
	public List<Brand> getAll() {//içinde markalar olan liste döndürecek
		
		return brands;
	}

}

package spring.example.dataAccess.abstracts;

import java.util.List;


import spring.example.entities.concretes.Brand;

public interface BrandRepository {
	//veri tabanı işlemleri
	List<Brand> getAll();//getAll'ı çağrılarak markalar listelenir
	
}

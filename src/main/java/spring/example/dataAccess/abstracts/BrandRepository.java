package spring.example.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import spring.example.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>//pk Integera karşılık geliyor 
{
	//veri tabanı işlemleri
	
	
}

//BTK ileri java spring kısımları izle

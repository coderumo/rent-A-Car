package spring.example.business.concretes;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.example.business.abstracts.BrandService;
import spring.example.business.requests.CreateBrandRequest;
import spring.example.business.responses.GetAllBrandResponse;
import spring.example.dataAccess.abstracts.BrandRepository;
import spring.example.entities.concretes.Brand;

@Service //bu sınıf bir business nesnesidir
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;//interfacei enjekte ediyoruz
	
	@Autowired
	public BrandManager(BrandRepository brandRepository) {//marka ile ilgili kural yazabilmrk için repository istiyoruz
		this.brandRepository = brandRepository;
	}

	@Override
	public List<GetAllBrandResponse> getAll() {
		//iş kuralları
		List<Brand> brands = brandRepository.findAll(); //dbden gelen datalar
		List<GetAllBrandResponse> brandsResponse = new ArrayList<GetAllBrandResponse>();//boş liste
		for (Brand brand : brands) {
			GetAllBrandResponse responseItem = new GetAllBrandResponse();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			responseItem.setLastName(brand.getLastName()); //response request pattern uygulayabiliriz
			
			brandsResponse.add(responseItem);
		}
		return brandsResponse;
	}
//Brand --> id, name, c
//GetAllBrandResponse --> id, name 
// branddekileri getalla ata yani MAPPİNG yap

	@Override
	public void add(CreateBrandRequest createBrandRequest) {//dbye kayıt ekleme
		
		Brand brand = new Brand();
		brand.setName(createBrandRequest.getName());
		
		this.brandRepository.save(brand);
	}
}

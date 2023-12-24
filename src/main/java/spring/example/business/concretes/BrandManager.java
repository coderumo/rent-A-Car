package spring.example.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.example.business.abstracts.BrandService;
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
	public List<Brand> getAll() {
		// iş kuralları
		return brandRepository.getAll();
	}

}

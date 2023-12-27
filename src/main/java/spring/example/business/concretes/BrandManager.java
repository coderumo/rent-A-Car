package spring.example.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import spring.example.business.abstracts.BrandService;
import spring.example.business.requests.CreateBrandRequest;
import spring.example.business.requests.UpdateBrandRequest;
import spring.example.business.responses.GetAllBrandResponse;
import spring.example.business.responses.GetByIdBrandResponse;
import spring.example.core.utilities.mappers.ModelMapperService;
import spring.example.dataAccess.abstracts.BrandRepository;
import spring.example.entities.concretes.Brand;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;//interfacei enjekte ediyoruz
	private ModelMapperService modelMapperService;
	//marka ile ilgili kural yazabilmrk için repository istiyoruz constructor


	@Override
	public List<GetAllBrandResponse> getAll() {
		//iş kuralları
		List<Brand> brands = brandRepository.findAll(); //dbden gelen datalar
//		List<GetAllBrandResponse> brandsResponse = new ArrayList<GetAllBrandResponse>();//boş liste
//		for (Brand brand : brands) {
//			GetAllBrandResponse responseItem = new GetAllBrandResponse();
//			responseItem.setId(brand.getId());
//			responseItem.setMarka(brand.getMarka());
//			responseItem.setModel(brand.getModel());
//			
//			brandsResponse.add(responseItem);
//		}
		
		List<GetAllBrandResponse> brandsResponse = brands.stream()
				.map(brand->this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class))
				.collect(Collectors.toList());//stream foreachin yaptığını yapar
		
		return brandsResponse;
	}
	
	
//Brand --> id, name, c
//GetAllBrandResponse --> id, name 
// branddekileri getalla ata yani MAPPİNG yap

	@Override
	public void add(CreateBrandRequest createBrandRequest) {//dbye kayıt ekleme
		
//		Brand brand = new Brand();
//		brand.setMarka(createBrandRequest.getMarka());
		
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);//createBrandRequestim var brand tipine çevir diyoz.
		this.brandRepository.save(brand);
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);//createBrandRequestim var brand tipine çevir diyoz.
		this.brandRepository.save(brand);//id olduğu için update işlemi yapar, id olmasaydı insert işlemi
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
		
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return response;
	}




}

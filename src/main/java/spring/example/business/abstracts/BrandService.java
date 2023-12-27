package spring.example.business.abstracts;

import java.util.List;

import spring.example.business.requests.CreateBrandRequest;
import spring.example.business.requests.UpdateBrandRequest;
import spring.example.business.responses.GetAllBrandResponse;
import spring.example.business.responses.GetByIdBrandResponse;

public interface BrandService {
 //iş kuralları
	List<GetAllBrandResponse> getAll();//response
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
}

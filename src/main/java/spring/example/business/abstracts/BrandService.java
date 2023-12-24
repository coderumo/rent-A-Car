package spring.example.business.abstracts;

import java.util.List;

import spring.example.business.requests.CreateBrandRequest;
import spring.example.business.responses.GetAllBrandResponse;

public interface BrandService {
 //iş kuralları
	List<GetAllBrandResponse> getAll();//response
	void add(CreateBrandRequest createBrandRequest);
}

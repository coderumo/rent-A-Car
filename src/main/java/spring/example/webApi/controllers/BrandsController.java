package spring.example.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import spring.example.business.abstracts.BrandService;
import spring.example.business.requests.CreateBrandRequest;
import spring.example.business.requests.UpdateBrandRequest;
import spring.example.business.responses.GetAllBrandResponse;
import spring.example.business.responses.GetByIdBrandResponse;

@RestController //annotation derlenirken restcontrollerı araıyor
@RequestMapping("/api/brands")//adresleme
@AllArgsConstructor
public class BrandsController { // istek controllera yapılıyor
	private BrandService brandService;//controller uygun bulırsa busineesa gönderiyor
	
	//Ioc
	//parametrelere bak, uygulamayı tara, hangi sayfa bu parametreyi implemente ediyor, onun newlenmiş halini veriyor

	
	@GetMapping()
	public List<GetAllBrandResponse> getAll(){
		return brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id){
		return brandService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);

	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}
	
	
}

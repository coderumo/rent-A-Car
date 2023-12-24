package spring.example.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.example.business.abstracts.BrandService;
import spring.example.business.requests.CreateBrandRequest;
import spring.example.business.responses.GetAllBrandResponse;

@RestController //annotation derlenirken restcontrollerı araıyor
@RequestMapping("/api/brands")//adresleme
public class BrandsController { // istek controllera yapılıyor
	private BrandService brandService;//controller uygun bulırsa busineesa gönderiyor
	
	//Ioc
	//parametrelere bak, uygulamayı tara, hangi sayfa bu parametreyi implemente ediyor, onun newlenmiş halini veriyor
	@Autowired
	public BrandsController(BrandService brandService) {//business data accesse gidiyor iş kurralrını geçince artık veri verebilirsin diyor
		this.brandService = brandService;
	}
	
	@GetMapping("/getall")
	public List<GetAllBrandResponse> getAll(){
		return brandService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
}

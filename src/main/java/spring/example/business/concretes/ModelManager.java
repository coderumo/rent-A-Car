package spring.example.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import spring.example.business.abstracts.ModelService;
import spring.example.business.responses.GetAllModelsResponse;
import spring.example.core.utilities.mappers.ModelMapperService;
import spring.example.dataAccess.abstracts.ModelRepository;
import spring.example.entities.concretes.Model;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll(); //dbden gelen datalar
		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model->this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());//stream foreachin yaptığını yapar
		
		return modelsResponse;
	}

}

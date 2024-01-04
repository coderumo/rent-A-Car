package spring.example.business.abstracts;

import java.util.List;

import spring.example.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();//response

}

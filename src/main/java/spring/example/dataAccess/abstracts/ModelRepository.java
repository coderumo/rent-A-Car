package spring.example.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.example.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> 
{

}

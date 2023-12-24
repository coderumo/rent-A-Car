package spring.example.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="brands")
@Getter //sadece getter olmasını istemezsek @Data yazarız
@Setter
@AllArgsConstructor
@NoArgsConstructor//parametresiz constructor
@Entity //db varlığı tablo karşılığı
public class Brand { //tabloya karşılık gelecek class
	
	@Id//db de PK olduğunu belirtir
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Id otomatik artık
	@Column(name="id")
	private int id;
	
	@Column(name="name")// db de name'e karşılık geliyor
	private String name;
	
	@Column(name="lastName")
	private String lastName;
	
	
}



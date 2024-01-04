package spring.example.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="models")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor//parametresiz constructor
@Entity //db varlığı tablo karşılığı
public class Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Id otomatik artık
	@Column(name="id")
	private int id;
	
	@Column(name="marka")
	private String marka;

	@ManyToOne
	@JoinColumn(name = "brand_id")//db'ye brand_id colonu koyacak, brand_is ile brand arasında fiziksel ilişki olacak
	private Brand brand;//1'e n'in 1'i
	
	@OneToMany(mappedBy = "model")
	private List<Car> cars;
}

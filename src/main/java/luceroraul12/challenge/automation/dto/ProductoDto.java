package luceroraul12.challenge.automation.dto;

import lombok.Getter;
import lombok.Setter;
import luceroraul12.challenge.automation.entity.Producto;

@Getter
@Setter
public class ProductoDto {
	private Integer id;
	private String nombre;
	private Double precio;
}

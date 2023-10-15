package luceroraul12.challenge.automation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDto {
	private Integer id;
	private String nombre;
	private Double precio;
	private TipoProductoDto tipo;
}

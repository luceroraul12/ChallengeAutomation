package luceroraul12.challenge.automation.dto;

import lombok.Data;

@Data
public class ProductoStockDto {
	private Integer id;
	private ProductoDto producto;
	private Integer cantidad;
}

package luceroraul12.challenge.automation.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import luceroraul12.challenge.automation.dto.ProductoStockDto;
import luceroraul12.challenge.automation.entity.StockProducto;

@Component
public class ProductoStockConverter extends GenericConverter<StockProducto, ProductoStockDto>{

	@Autowired
	private ProductoConverter productoConverter;

	@Override
	public StockProducto toEntidad(ProductoStockDto c) {
		StockProducto e = new StockProducto();
		e.setCantidad(c.getCantidad());
		e.setId(c.getId());
		e.setProducto(productoConverter.toEntidad(c.getProducto()));
		return e;
	}

	@Override
	public ProductoStockDto toContrato(StockProducto e) {
		ProductoStockDto c = new ProductoStockDto();
		c.setId(e.getId());
		c.setCantidad(e.getCantidad());
		c.setProducto(productoConverter.toContrato(e.getProducto()));
		return c;
	}
	

	
}

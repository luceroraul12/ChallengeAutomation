package luceroraul12.challenge.automation.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import luceroraul12.challenge.automation.dto.ProductoDto;
import luceroraul12.challenge.automation.entity.Producto;

@Component
public class ProductoConverter extends GenericConverter<Producto, ProductoDto>{
	
	@Autowired
	private TipoProductoConverter tipoProductoConverter;

	@Override
	public Producto toEntidad(ProductoDto c) {
		Producto e = new Producto();
		e.setId(c.getId());
		e.setNombre(c.getNombre());
		e.setPrecio(c.getPrecio());
		e.setTipoProducto(tipoProductoConverter.toEntity(c.getTipo()));
		return e;
	}

	@Override
	public ProductoDto toContrato(Producto e) {
		ProductoDto dto = new ProductoDto();
		dto.setId(e.getId());
		dto.setNombre(e.getNombre());
		dto.setPrecio(e.getPrecio());
		dto.setTipo(tipoProductoConverter.toDto(e.getTipoProducto()));
		return dto;
	}
}

package luceroraul12.challenge.automation.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import luceroraul12.challenge.automation.dto.ProductoDto;
import luceroraul12.challenge.automation.entity.Producto;

@Component
public class ProductoConverter {
	public ProductoDto toDto(Producto p) {
		ProductoDto dto = new ProductoDto();
		dto.setId(p.getId());
		dto.setNombre(p.getNombre());
		dto.setPrecio(p.getPrecio());
		dto.setTipo(p.getTipoProducto().getDescripcion());
		return dto;
	}
	
	public Producto toEntity(ProductoDto dto) {
		Producto e = new Producto();
		e.setId(dto.getId());
		e.setNombre(dto.getNombre());
		e.setPrecio(dto.getPrecio());
		return e;
	}
	
	public List<ProductoDto> toDtoList(List<Producto> productos){
		return productos.stream().map(p -> toDto(p)).toList();
	}
	
	public List<Producto> toEntityList(List<ProductoDto> dtos){
		return dtos.stream().map(dto -> toEntity(dto)).toList();
	}
}

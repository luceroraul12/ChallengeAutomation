package luceroraul12.challenge.automation.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import luceroraul12.challenge.automation.dto.TipoProductoDto;
import luceroraul12.challenge.automation.entity.TipoProducto;

@Component
public class TipoProductoConverter {
	public TipoProductoDto toDto(TipoProducto p) {
		TipoProductoDto dto = new TipoProductoDto();
		dto.setId(p.getId());
		dto.setDescripcion(p.getDescripcion());
		return dto;
	}
	
	public TipoProducto toEntity(TipoProductoDto dto) {
		TipoProducto e = new TipoProducto();
		e.setId(dto.getId());
		e.setDescripcion(dto.getDescripcion());
		return e;
	}
	
	public List<TipoProductoDto> toDtoList(List<TipoProducto> productos){
		return productos.stream().map(p -> toDto(p)).toList();
	}
	
	public List<TipoProducto> toEntityList(List<TipoProductoDto> dtos){
		return dtos.stream().map(dto -> toEntity(dto)).toList();
	}
}

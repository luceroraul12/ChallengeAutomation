package luceroraul12.challenge.automation.service;

import java.util.List;

import luceroraul12.challenge.automation.dto.ProductoDto;
import luceroraul12.challenge.automation.dto.ProductoStock;
import luceroraul12.challenge.automation.dto.TipoProductoDto;

public interface ProductoService {
	public List<ProductoDto> obtenerProductos();
	
	public ProductoDto crearProducto(ProductoDto dto) throws Exception;
	
	public ProductoDto actualizarProducto(ProductoDto dto) throws Exception;

	public Integer eliminarProducto(Integer idProducto) throws Exception;
	
	public List<ProductoStock> obtenerStockProductos();

	public List<TipoProductoDto> obtenerTipoProductos();
}

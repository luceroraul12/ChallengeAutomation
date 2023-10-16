package luceroraul12.challenge.automation.service;

import java.util.List;

import luceroraul12.challenge.automation.dto.ProductoDto;
import luceroraul12.challenge.automation.dto.ProductoStockDto;
import luceroraul12.challenge.automation.dto.TipoProductoDto;

public interface ProductoService {
	public List<ProductoDto> obtenerProductos();
	
	public ProductoDto crearProducto(ProductoDto dto) throws Exception;
	
	public ProductoDto actualizarProducto(ProductoDto dto) throws Exception;

	public Integer eliminarProducto(Integer idProducto) throws Exception;
	
	public List<ProductoStockDto> obtenerStockProductos();

	public List<TipoProductoDto> obtenerTipoProductos();

	public ProductoStockDto actualizarStockProducto(ProductoStockDto dto) throws Exception;
}

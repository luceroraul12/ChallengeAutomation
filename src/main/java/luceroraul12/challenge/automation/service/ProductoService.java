package luceroraul12.challenge.automation.service;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.websocket.server.PathParam;
import luceroraul12.challenge.automation.dto.ProductoDto;
import luceroraul12.challenge.automation.dto.ProductoStock;

public interface ProductoService {
	public List<ProductoDto> obtenerProductos();
	
	public ProductoDto crearProducto(ProductoDto dto);
	
	public ProductoDto actualizarProducto(ProductoDto dto);

	public Integer eliminarProducto(Integer idProducto);
	
	public List<ProductoStock> obtenerStockProductos();
}

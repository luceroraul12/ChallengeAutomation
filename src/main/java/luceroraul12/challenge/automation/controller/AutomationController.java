package luceroraul12.challenge.automation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import luceroraul12.challenge.automation.dto.ProductoDto;
import luceroraul12.challenge.automation.dto.ProductoStock;

@RestController
@RequestMapping("/automation")
public class AutomationController {
	
	@GetMapping("/producto")
	public List<ProductoDto> obtenerProductos() {
		
		return null;
	}
	
	@PostMapping("/producto")
	public ProductoDto crearProducto(@RequestBody ProductoDto dto) {
		
		return null;
	}
	
	@PutMapping("/producto")
	public ProductoDto actualizarProducto(@RequestBody ProductoDto dto) {
		
		return null;
	}

	@DeleteMapping("/producto/{idProducto}")
	public Integer eliminarProducto(@PathParam(value = "idProducto") Integer idProducto) {
		
		return null;
	}
	
	@GetMapping("/stock")
	public List<ProductoStock> obtenerStockProductos() {
		
		return null;
	}
	
}

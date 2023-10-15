package luceroraul12.challenge.automation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import luceroraul12.challenge.automation.dto.TipoProductoDto;
import luceroraul12.challenge.automation.service.ProductoService;

@CrossOrigin
@RestController
@RequestMapping("/automation")
public class AutomationController {
	
	@Autowired
	ProductoService service;
	
	@GetMapping("/producto")
	public List<ProductoDto> obtenerProductos() {
		return service.obtenerProductos();
	}
	
	@PostMapping("/producto")
	public ProductoDto crearProducto(@RequestBody ProductoDto dto) {
		return service.crearProducto(dto);
	}
	
	@PutMapping("/producto")
	public ProductoDto actualizarProducto(@RequestBody ProductoDto dto) {
		return service.actualizarProducto(dto);
	}

	@DeleteMapping("/producto/{idProducto}")
	public Integer eliminarProducto(@PathParam(value = "idProducto") Integer idProducto) {
		return service.eliminarProducto(idProducto);
	}
	
	@GetMapping("/stock")
	public List<ProductoStock> obtenerStockProductos() {
		return service.obtenerStockProductos();
	}
	
	@GetMapping("/tipoProducto")
	public List<TipoProductoDto> obtenerTipoProductos() {
		return service.obtenerTipoProductos();
	}
	
}

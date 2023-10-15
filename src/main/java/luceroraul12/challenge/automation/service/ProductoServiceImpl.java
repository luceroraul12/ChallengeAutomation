package luceroraul12.challenge.automation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luceroraul12.challenge.automation.converter.ProductoConverter;
import luceroraul12.challenge.automation.converter.TipoProductoConverter;
import luceroraul12.challenge.automation.dto.ProductoDto;
import luceroraul12.challenge.automation.dto.ProductoStock;
import luceroraul12.challenge.automation.dto.TipoProductoDto;
import luceroraul12.challenge.automation.entity.Producto;
import luceroraul12.challenge.automation.repository.ProductoRepository;
import luceroraul12.challenge.automation.repository.TipoProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private TipoProductoRepository tipoProductoRepository;
	
	@Autowired
	private ProductoConverter productoConverter;
	
	@Autowired
	private TipoProductoConverter tipoProductoConverter;
	
	

	@Override
	public List<ProductoDto> obtenerProductos() {
		return productoConverter.toDtoList(productoRepository.findAll());
	}

	@Override
	public ProductoDto crearProducto(ProductoDto dto) throws Exception {
		// Valido
		validarProductoDto(dto);
		// Convierto
		Producto producto = productoConverter.toEntity(dto);
		// Persisto
		producto = productoRepository.save(producto);
		
		return productoConverter.toDto(producto);
	}

	@Override
	public ProductoDto actualizarProducto(ProductoDto dto) throws Exception {
		// Valido
		validarProductoDto(dto);
		// Valido que contenga identificador
		if(dto.getId() == null)
			throw new Exception("Nos debe pasar el identificador del producto a modificar");
		// Convierto
		Producto producto = productoConverter.toEntity(dto);
		// Persisto
		producto = productoRepository.save(producto);
		
		return productoConverter.toDto(producto);
	}

	@Override
	public Integer eliminarProducto(Integer idProducto) throws Exception {
		// Valido identificador
		if(idProducto == null)
			throw new Exception("Nos debe pasar el identificador del producto a modificar");
		productoRepository.deleteById(idProducto);
		return idProducto;
	}

	@Override
	public List<ProductoStock> obtenerStockProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoProductoDto> obtenerTipoProductos() {
		return tipoProductoConverter.toDtoList(tipoProductoRepository.findAll());
	}

	
	private void validarProductoDto(ProductoDto dto) throws Exception{
		// Validaciones
		if(dto == null)
			throw new Exception("Nos debe pasar el producto a crear");
		
		if(dto.getNombre() == null)
			throw new Exception("Nos debe pasar el nombre del producto");
		
		if(dto.getPrecio() == null)
			throw new Exception("Nos debe pasar el precio del producto");
		
		if(dto.getTipo() == null)
			throw new Exception("Nos debe pasar el tipo de producto");
	}
}

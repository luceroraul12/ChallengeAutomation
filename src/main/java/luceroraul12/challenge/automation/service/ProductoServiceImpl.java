package luceroraul12.challenge.automation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luceroraul12.challenge.automation.converter.ProductoConverter;
import luceroraul12.challenge.automation.converter.ProductoStockConverter;
import luceroraul12.challenge.automation.converter.TipoProductoConverter;
import luceroraul12.challenge.automation.dto.ProductoDto;
import luceroraul12.challenge.automation.dto.ProductoStockDto;
import luceroraul12.challenge.automation.dto.TipoProductoDto;
import luceroraul12.challenge.automation.entity.Producto;
import luceroraul12.challenge.automation.entity.StockProducto;
import luceroraul12.challenge.automation.repository.ProductoRepository;
import luceroraul12.challenge.automation.repository.StockProductoRepository;
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
	
	@Autowired
	private StockProductoRepository stockProductoRepository;
	
	@Autowired
	private ProductoStockConverter productoStockConverter;
	
	

	@Override
	public List<ProductoDto> obtenerProductos() {
		return productoConverter.toContratoList(productoRepository.findAll());
	}

	@Override
	public ProductoDto crearProducto(ProductoDto dto) throws Exception {
		// Valido
		validarProductoDto(dto);
		// Convierto
		Producto producto = productoConverter.toEntidad(dto);
		// Persisto
		producto = productoRepository.save(producto);
		
		return productoConverter.toContrato(producto);
	}

	@Override
	public ProductoDto actualizarProducto(ProductoDto dto) throws Exception {
		// Valido
		validarProductoDto(dto);
		// Valido que contenga identificador
		if(dto.getId() == null)
			throw new Exception("Nos debe pasar el identificador del producto a modificar");
		// Valido que exista en la base de datos
		Producto oldProducto = productoRepository.findById(dto.getId()).orElse(null);
		if(oldProducto == null)
			throw new Exception("El producto que se quiere modificar no existe en la base de datos");
		// Convierto
		Producto producto = productoConverter.toEntidad(dto);
		// Persisto
		producto = productoRepository.save(producto);
		
		return productoConverter.toContrato(producto);
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
	public List<ProductoStockDto> obtenerStockProductos() {
		List<StockProducto> stocks = stockProductoRepository.findAll();
		return productoStockConverter.toContratoList(stocks);
	}
	
	@Override
	public ProductoStockDto actualizarStockProducto(ProductoStockDto dto) throws Exception{
		// Valido dto
		if(dto == null)
			throw new Exception("Nos debe pasar el stock que se quiere actualizar.");
		if(dto.getId() == null)
			throw new Exception("Nos debe pasar el identificador del stock a actualizar");
		if(dto.getCantidad() == null)
			throw new Exception("Nos debe pasar la cantidad de producto a la que se quiere actualizar");
		// Valido que exista
		StockProducto oldStock = stockProductoRepository.findById(dto.getId()).orElse(null);
		if(oldStock == null)
			throw new Exception("El stock que quiere actualizar no existe en la base de datos");
		
		// En la actualizacion solo voy a actualizar las cantidades
		oldStock.setCantidad(dto.getCantidad());
		stockProductoRepository.save(oldStock);
		return productoStockConverter.toContrato(oldStock);
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

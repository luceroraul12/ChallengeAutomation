package luceroraul12.challenge.automation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luceroraul12.challenge.automation.converter.ProductoConverter;
import luceroraul12.challenge.automation.dto.ProductoDto;
import luceroraul12.challenge.automation.dto.ProductoStock;
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
	
	

	@Override
	public List<ProductoDto> obtenerProductos() {
		return productoConverter.toDtoList(productoRepository.findAll());
	}

	@Override
	public ProductoDto crearProducto(ProductoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDto actualizarProducto(ProductoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer eliminarProducto(Integer idProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoStock> obtenerStockProductos() {
		// TODO Auto-generated method stub
		return null;
	}

}

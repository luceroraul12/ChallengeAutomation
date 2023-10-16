package luceroraul12.challenge.automation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import luceroraul12.challenge.automation.dto.ProductoStock;

public interface StockProductoRepository extends JpaRepository<ProductoStock, Integer>{

}

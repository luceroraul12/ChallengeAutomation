package luceroraul12.challenge.automation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class StockProducto {
	@Id
	private Integer id;
	@Column
	private Integer cantidad;
	@ManyToOne
	@JoinColumn(columnDefinition = "id_producto")
	private Producto producto;

}

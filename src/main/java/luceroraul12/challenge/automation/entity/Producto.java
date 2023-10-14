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
public class Producto {
	@Id
	private Integer id;
	@Column
	private String nombre;
	@Column
	private Double precio;
	@ManyToOne
	@JoinColumn(columnDefinition = "id_tipo_producto")
	private TipoProducto tipoProducto;
}

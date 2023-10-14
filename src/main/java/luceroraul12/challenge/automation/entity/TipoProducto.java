package luceroraul12.challenge.automation.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class TipoProducto {
	@Id
	private Integer id;
	@Column
	private String descripcion;
}

package luceroraul12.challenge.automation.converter;

import java.util.List;

/**
 * Clase encargada de hacer conversiones entre una entidad y un contrato y viceversa
 * @param <Entidad>
 * @param <Contrato>
 */
public abstract class GenericConverter<Entidad, Contrato>{
	/**
	 * Encargado de convertir un contrato en una entidad
	 * @param c
	 * @return
	 */
	public abstract Entidad toEntidad(Contrato c);
	/**
	 * Encargado de convertir una entidad en un contrato
	 * @param e
	 * @return
	 */
	public abstract Contrato toContrato(Entidad e);
	
	/**
	 * Aplica {@link #toEntidad(Object)} a una lista de contratos
	 * @param contratos
	 * @return
	 */
	public List<Entidad> toEntidadList(List<Contrato> contratos){
		return contratos.stream().map(this::toEntidad).toList();
	}
	
	/**
	 * Aplica {@link #toContrato(Object)} a una lista de entidades
	 * @param entidades
	 * @return
	 */
	public List<Contrato> toContratoList(List<Entidad> entidades){
		return entidades.stream().map(this::toContrato).toList();
	}
}

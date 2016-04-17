package com.daloz.mycv.business;

import java.util.List;

/**
 * Esta interfaz define la declaraci�n basica
 * de los metodos CRUD para su posterior implementaci�n.
 * <T> esta definici�n me permite trabajar con clases genericas
 * 
 * @author Mandraque
 *
 * @param <T> permite trabajar con clases genericas.
 */
public interface IGenericDAO<T>
{
	/**
	 * Esta funci�n me permite seleccionar un registro de una determinda
	 * tabla de la bd.
	 * 
	 * @param id: representa el Id de un registro de una determinada tabla
	 *            de una bd.
	 * @return La entidad en contexto, como respuesta al registro obtenido.
	 * 
	 */
	T selectOne(Long id);
	
	/**
     * Esta funci�n me permite seleccionar un registro de una determinda
	 * tabla de la bd.
	 * 
	 * @param entity: Representa la entidad en contexto que contendra los valores
	 *                que se usaran para la condici�n.
	 *                
	 * @param condition: Contiene la definici�n de la condicion(WHERE)
	 * 
	 * @return La entidad en contexto, devolvera al registro obtenido.
	 */
	T selectOne(T entity, String condition);
	
	/**
	 * Esta funci�n me permite seleccionar todos los registro de una 
	 * determinada tabla de la bd.
	 * 
	 * @return Una lista de la clase en contexto que sera obtenidos como 
	 *         registros.
	 */
	List<T> selectAll();
	
	
	/**
	 * Esta funci�n permite seleccionar todos los registros 
	 * de la tabla(Entidad en contexto) de la bd.
	 * 
	 * @param entity: Representa la entidad en contexto, que contendra
	 *                los valores que se usaran para la condici�n.
	 *                
	 * @param condition: Contiene la definicion de la condicion (WHERE)
	 * @return Una lista de la Entidad en contexto que sera obtenidos como 
	 *         registros.
	 */
	List<T> selectAll(T entity, String condition);
	
	
	/**
	 * Esta funci�n me permite realizar la insercci�n
	 * de un registro en una determinada tabla de la bd.
	 * 
	 * @param entity: Representa una entidad generica que va a estar
	 *                en contexto.
	 *                
	 * @return Un Boolean como respuesta del proceso.
	 */
	Boolean insertInto(T entity);
	
	/**
	 * Esta funci�n me permite actualizar un registro de
	 * una determinada tabla de la bd.
	 * 
	 * @param entity: Representa una entidad generica que va estar en contexto.
	 * @return Un Boolean como respuesta del proceso.
	 */
	Boolean update(T entity);
	
	/**
	 * Esta funci�n realiza el proceso de eliminar un 
	 * registro(Entidad en contexto) de la bd.
	 * 
	 * @param entity - Representa un registro(Entidad en contexto).
	 * @return Un Boolean como respuesta del proceso.
	 */
	Boolean delete(T entity);
	
	/**
	 * Funci�n que sirve para eliminar registros de una tabla(Entidad en contexto)
	 * de la bd.
	 * 
	 * @param id - Representa la id del registro a eliminar.
	 * @return Un Boolean como respuesta del proceso.
	 */
	Boolean delete(Long id);
}

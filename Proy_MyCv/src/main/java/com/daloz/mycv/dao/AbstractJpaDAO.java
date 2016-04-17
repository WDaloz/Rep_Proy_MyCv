package com.daloz.mycv.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.EmptyResultDataAccessException;

import com.daloz.mycv.business.IGenericDAO;
import com.daloz.mycv.dao.helper.BagItemCondition;
import com.daloz.mycv.dao.helper.ReaperConditions;

/**
 * Es una clase asbtracta, ya que nos permite si queremos desarrollar los
 * metodos a implementar y ademas de que evita su instancia.
 * 
 * @author Mandraque.
 * @version 1.0
 * @param <T>:
 *            Representa la entidad o clase a pasar como parametro para pasarlo
 *            en contexto y debe extender de Serializable ya que esto obliga
 *            serializar los domain. Por ultimo, cuando la clase entra en
 *            contexto reemplazara todo los T Genericos.
 */
public abstract class AbstractJpaDAO<T extends Serializable> implements IGenericDAO<T>
{
	@PersistenceContext
	protected EntityManager entityManager;

	// Declaramos una clase generica.
	private Class<T> clazz;

	/**
	 * Constructor para definir el tipo de clase a la clase generica.
	 * 
	 * @param clazz:
	 *            representa la clase que se pasa como parametro a travez del
	 *            constructor. Es necesario pasarlo como parametro para su
	 *            contexto. Funciona igual sin el final.
	 */
	public final void setClazz(final Class<T> clazz)
	{
		this.clazz = clazz;
	}

	/**
	 * Este metodo me permite generar querys con condiciones para usarlo en los
	 * metodos implementados (CRUD).
	 * 
	 * @param entity:
	 *            Es la clase instanciada en objeto. ademas, contiene los
	 *            valores para usarlos en la condici�n.
	 * 
	 * @param condition:
	 *            Es declaraci�n de la condici�n.
	 * 
	 * @return el query con todo los valores asignado a los parametros.
	 */
	private Query getQueryParameter(T entity, String condition)
	{
		// Creamos un query, lo preparamos para la consulta hql asginando la
		// condici�n.
		Query query = entityManager.createQuery("FROM " + clazz.getSimpleName() + " WHERE " + condition);

		// Creamos la bolsa de items, luego invocamos el helper que nos
		// devolvera una lista
		// con la bolsa de items que contendra los elementos necesarios para
		// asignar los
		// parametros al query.
		BagItemCondition bagItems = new ReaperConditions(condition, entity).getBagItems();

		// Recorremos la bolsa de items
		for (int i = 0; i < bagItems.size(); i++)
		{
			// Por cada recorrido asignamos los parametros necesarios al query.
			query.setParameter(bagItems.get(i).getAttributeName(), bagItems.get(i).getValueAttribute());
		}

		return query;
	}

	@Override
	public T selectOne(Long id)
	{
		// find(Class<?> class, Object object): Metodo que busca un registro en
		// la tabla
		// tomando como argumentos el tipo de clase y su identificador.
		return entityManager.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T selectOne(T entity, String condition)
	{
		try
		{
			return (T) getQueryParameter(entity, condition).getSingleResult();
		} 
		catch (EmptyResultDataAccessException | NoResultException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectAll()
	{
		return entityManager.createQuery("FROM " + clazz.getSimpleName()).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectAll(T entity, String condition)
	{
		return getQueryParameter(entity, condition).getResultList();
	}

	@Override
	public Boolean insertInto(T entity)
	{
		try
		{
			//
			entityManager.persist(entity);
			return true;
		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean update(T entity)
	{
		try
		{
			entityManager.merge(entity);
			return true;
		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean delete(T entity)
	{
		try
		{
			/**
			 * Metodo que se encarga de remover un registro de la bd, se le pasa
			 * como parametro la entidad en contexto que sera a liminar.
			 */
			entityManager.remove(entity);
			return true;
		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean delete(Long id)
	{
		try
		{
			/**
			 * remove(Object object): elimina un registro de la tabla tomando
			 * como argumento el objeto.
			 * 
			 * Se busca un objeto(de tipo clase en contexto) mediante Id Y luego
			 * se procede a removero.
			 */
			T entity = selectOne(id);
			entityManager.remove(entity);
			return true;
		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}

	}

}

package otc.tech.base.service;

import java.util.List;

public interface IBaseService<T> {

	/**
	 * 添加一条记录
	 * @param t
	 * @return 
	 */
	public int insert(T t);
	
	/**
	 * 批量添加多条记录
	 * @param t
	 * @return 
	 */
	public int insertAll(List<T> t);
	
	/**
	 * 插入一条记录，忽略null值
	 * @param t
	 * @return 
	 */
	public int insertSelective(T t);
	
	/**
	 * 根据实体信息删除
	 * @param t
	 * @return 
	 */
	public int delete(T t);
	
	/**
	 * 根据主键删除
	 * @param key
	 * @return 
	 */
	public int deleteByPrimaryKey(Object key);
	
	/**
	 * 根据example删除信息
	 * @param example
	 */
	public int deleteByExample(Object example);
	
	/**
	 * 根据实体对象查询单个对象
	 * @param t
	 * @return
	 */
	public T selectOne(T t);
	
	/**
	 * 根据实体对象查询list
	 * @param t
	 * @return
	 */
	public List<T> select(T t);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> selectAll();
	
	/**
	 * 根据条件example查询
	 * @param example
	 * @return
	 */
	public List<T> selectByExample(Object example);
	
	/**
	 * 根据主键查询
	 * @param key
	 * @return
	 */
	public T selectByPrimaryKey(Object key);
	
	/**
	 * 根据Example条件更新实体`record`包含的全部属性，null值会被更新
	 * @param t
	 * @param example
	 */
	public int updateByExample(T t, Object example);
	
	/**
	 * 根据Example条件更新实体`record`包含的不是null的属性值
	 * @param t
	 * @param example
	 */
	public int updateByExampleSelective(T t, Object example);
	
	/**
	 * 根据主键更新实体全部字段，null值会被更新
	 * @param t
	 */
	public int updateByPrimaryKey(T t);
	
	/**
	 * 根据主键更新属性不为null的值
	 * @param t
	 */
	public int updateByPrimaryKeySelective(T t);
	
//	/**
//	 * 根据Example条件更新实体`record`包含的不是null的属性值
//	 * @param t
//	 * @return 
//	 */
//	public int updateByPrimaryKeySelective(T t, Object example);

	
}

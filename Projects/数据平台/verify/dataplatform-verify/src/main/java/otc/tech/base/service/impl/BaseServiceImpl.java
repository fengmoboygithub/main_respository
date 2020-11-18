package otc.tech.base.service.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import otc.tech.base.mapper.BaseMapper;
import otc.tech.base.service.IBaseService;
import otc.tech.model.Template;

public class BaseServiceImpl<T> implements IBaseService<T>{

	@Autowired
	private BaseMapper<T> mapper;
	
	private Class<T> clazz;
	
	public BaseServiceImpl() {
		// 获取父类的type
		Type type = this.getClass().getGenericSuperclass();

		// 强转为ParameterizedType，可以使用获取泛型类型的方法
		ParameterizedType pType = (ParameterizedType) type;

		// 获取泛型的class
		this.clazz = (Class<T>) pType.getActualTypeArguments()[0];
	}

//	private BaseMapper<T> mapper;
//
//	/**
//	 * 描述: 子类重写方法
//	 * 
//	 * @param:
//	 * @return: IBaseDao<T>
//	 * @author: wangshiping
//	 * @date: 2015年11月2日 下午3:19:50
//	 */
//	public BaseMapper<T> getMapper() {
//		return mapper;
//	}
	@Override
	public int insert(T t) {
		return mapper.insert(t);
	}
	
	@Override
	public int insertAll(List<T> t) {
		return mapper.insertList(t);
		
	}

	@Override
	public int insertSelective(T t) {
		return mapper.insertSelective(t);
	}

	@Override
	public int delete(T t) {
		return mapper.delete(t);
	}

	@Override
	public int deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int deleteByExample(Object example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public List<T> select(T t) {
		return mapper.select(t);
	}

	@Override
	public List<T> selectAll() {
		return mapper.selectAll();
	}
	
	@Override
	public T selectOne(T t) {
		return mapper.selectOne(t);
	}
	
	@Override
	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example);
	}

	@Override
	public T selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public int updateByExample(T t, Object example) {
		return mapper.updateByExample(t, example);
	}

	@Override
	public int updateByExampleSelective(T t, Object example) {
		return mapper.updateByExampleSelective(t, example);
	}

	@Override
	public int updateByPrimaryKey(T t) {
		return mapper.updateByPrimaryKey(t);
	}

//	@Override
//	public int updateByPrimaryKeySelective(T t, Object example) {
//		return mapper.updateByExampleSelective(t, example);
//	}

	@Override
	public int updateByPrimaryKeySelective(T t) {
		return mapper.updateByPrimaryKeySelective(t);
	}

	
}

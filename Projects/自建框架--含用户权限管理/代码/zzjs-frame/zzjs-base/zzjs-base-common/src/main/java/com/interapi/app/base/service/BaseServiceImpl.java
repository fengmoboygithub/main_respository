package com.interapi.app.base.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.exception.BaseException;
import com.interapi.app.base.model.BaseModel;

/**
 * @author yangyanchao
 * 基类Service实现类
 * @param <T>
 * @param <E>
 */
public class BaseServiceImpl<T extends BaseModel,E extends BaseExample> implements IBaseService<T,E>{
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private IBaseDao<T,E> mapper;
	
	/**
	 * 描述: 子类重写方法
	 * @param: 
	 * @return: IBaseDao<T,E>  
	 */
	public IBaseDao<T,E> getMapper(){
		return mapper;
	}

	public Logger getLogger() {
		return logger;
	}

	@Override
	public T get(Long id) throws BaseException {
		T model = getMapper().selectByPrimaryKey(id);
        if (model == null) {
            logger.error("获取实体数据错误，查询参数：{}", id);
            throw new BaseException("获取实体数据错误");
        }
        return model;
	}

	@Override
	public void save(T model) throws BaseException {
		
		int success = getMapper().insertSelective(model);
        if (success <= 0) {
            logger.error("新增实体错误{}",  model.toString());
            throw new BaseException("新增实体错误");
        }
        return;
	}

	@Override
	public void update(T model) throws BaseException {
		
		int success = getMapper().updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("更新实体错误{}",  model.toString());
            throw new BaseException("更新实体错误");
        }
        return;
		
	}

	@Override
	public void deleteByPrimaryKey(Long id) throws BaseException {
		int success = getMapper().deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("根据主键删除实体错误{}", id);
            throw new RuntimeException("删除实体错误");
        }
        return;
		
	}

	@Override
	public void deleteByExample(E example) throws BaseException {
		
		int success = getMapper().deleteByExample(example);
        if (success <= 0) {
            logger.error("根据查询条件删除实体错误{}", example);
            throw new RuntimeException("删除实体错误");
        }
        return;
		
	}

	@Override
	public long countByExample(E example) throws BaseException {

		return getMapper().countByExample(example);
		
	}

	@Override
	public PageInfo<T> getListByPage(int currentPage, int itemsPerPage, E example) throws BaseException {

        List<T> list = null;
        PageInfo<T> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = getMapper().selectByExample(example);
			page = new PageInfo<T>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
			throw new BaseException("分页查询失败");
		}
		return page;
		
	}

	@Override
	public List<T> getList(E example) throws BaseException {

		 return getMapper().selectByExample(example);
	
	}
}
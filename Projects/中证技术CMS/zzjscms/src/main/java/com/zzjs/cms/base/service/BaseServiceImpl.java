package com.zzjs.cms.base.service;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zzjs.cms.base.dao.IBaseDao;
import com.zzjs.cms.base.entity.BaseModel;
import com.zzjs.cms.entity.vo.PageVo;
import com.zzjs.cms.exception.BaseException;
import com.zzjs.cms.json.PageJson;
/**
 * 
 * @author otc
 *
 * @param <T>
 */
public class BaseServiceImpl<T extends BaseModel> implements IBaseService<T>{
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	private IBaseDao<T> dao;
	
	/**
	 * 描述: 子类重写方法
	 * @param: 
	 * @return: IBaseDao<T>  
	 * @author:  
	 * @date: 2015年11月2日 下午3:19:50
	 */
	public IBaseDao<T> getDao(){
		return dao;
	}
	
	 

	/**
	 * 描述: 主键查询
	 * @param:
	 * @return: 
	 * @author:  
	 * @date: 2015年11月2日 下午3:21:15
	 * @see com.otc.uc.base.service.IBaseService#selectByPrimaryKey(java.lang.Object)  
	*/ 
	public T selectByPrimaryKey(Object key) throws BaseException {
		return getDao().selectByPrimaryKey(key);
	}
	
	/**
	 * 描述: 主键查询
	 * @param:
	 * @return: 
	 * @author:  
	 * @date: 2015年11月2日 下午3:21:15
	 * @see com.otc.uc.base.service.IBaseService#selectByPrimaryKey(java.lang.Object)  
	*/ 
	public List<T> selectByPrimaryKeys(Object key) throws BaseException {
		return getDao().selectByPrimaryKeys(key);
	}
	
	/**
	 * 描述: 最大值查询
	 * @param:
	 * @return: 
	 * @author:  
	 * @date: 2015年11月2日 下午3:21:15
	 * @see com.otc.uc.base.service.IBaseService#selectByPrimaryKey(java.lang.Object)  
	*/ 
	public T selectByMaxKey(Object key) throws BaseException {
		return getDao().selectByMaxKey(key);
	}
    
	/**
	 * 描述: 主键修改
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:21:37
	 * @see com.otc.uc.base.service.IBaseService#updateByPrimaryKey(java.lang.Object)  
	*/ 
	public Integer updateByPrimaryKey(T t) throws BaseException {
		return getDao().updateByPrimaryKey(t);
	}

	/**
	 * 描述: 主键删除
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:21:58
	 * @see com.otc.uc.base.service.IBaseService#deleteByPrimaryKeys(java.lang.Object[])  
	*/ 
	public Integer deleteByPrimaryKeys(Object... keys) throws BaseException {
		int i=0;
		for(Object key:keys){
			i+=getDao().deleteByPrimaryKey(key);
		}
		return i;
	}
	/**
	 * 描述: 选取最大ID
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:22:20
	 * @see com.otc.uc.base.service.IBaseService#insert(java.lang.Object)  
	*/ 
    public Integer selectMaxId()throws BaseException{
    	return getDao().selectMaxId();
    }
	/**
	 * 描述: 插入数据
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:22:20
	 * @see com.otc.uc.base.service.IBaseService#insert(java.lang.Object)  
	*/ 
	public Integer insert(T t) throws BaseException {
		return getDao().insert(t);
	}
   
	/**
	 * 描述: 查询总行数
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:23:06
	 * @see com.otc.uc.base.service.IBaseService#selectByModelPagingCount(java.lang.Object)  
	*/ 
	public Integer selectByModelPagingCount(T model) throws BaseException {
		return getDao().selectByModelPagingCount(model);
	}
   
	/**
	 * 描述: 查询Map总行数
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:23:37
	 * @see com.otc.uc.base.service.IBaseService#selectByMapCount(java.util.Map)  
	*/ 
	public Integer selectByMapCount(Map<?, ?> map) throws BaseException {
		return getDao().selectByMapCount(map);
	}
    
	/**
	 * 描述: 模型分页查询
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:23:56
	 * @see com.otc.uc.base.service.IBaseService#selectByModelPaging(java.lang.Object)  
	*/ 
	public List<T> selectByModelPaging(T model) throws BaseException {
		return getDao().selectByModelPaging(model);
	}
  
	/**
	 * 描述: Map查询
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:24:26
	 * @see com.otc.uc.base.service.IBaseService#selectByMap(java.util.Map)  
	*/ 
	public List<T> selectByMap(Map<?, ?> map) throws BaseException {
		return getDao().selectByMap(map);
	}
	
	/**
	 * 描述: 实体查询
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:24:48
	 * @see com.otc.uc.base.service.IBaseService#selectByEntiry(java.lang.Object)  
	*/ 
	public List<T> selectByEntiry(T entity) throws BaseException{
		return getDao().selectByEntiry(entity);
	}
	 
	/**
	 * 描述: 实体删除
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:25:08
	 * @see com.otc.uc.base.service.IBaseService#deleteByEntity(java.lang.Object)  
	*/ 
	public Integer deleteByEntity(T entity) throws BaseException{
		  return getDao().deleteByEntity(entity);
	}
	
	/**
	 * 描述: SQL查询
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:25:24
	 * @see com.otc.uc.base.service.IBaseService#selectBySql(java.lang.String)  
	*/ 
	public List<T> selectBySql(String sql) throws BaseException{
		return getDao().selectBySql(sql);
	}
	 
	/**
	 * 描述: SQL修改
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:25:41
	 * @see com.otc.uc.base.service.IBaseService#updateBySql(java.lang.String)  
	*/ 
	public Integer updateBySql(String sql) throws BaseException{
		return getDao().updateBySql(sql);
	}
	
	
	/**
	 * 描述: SQL删除
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:25:58
	 * @see com.otc.uc.base.service.IBaseService#deleteBySql(java.lang.String)  
	*/ 
	public Integer deleteBySql(String sql) throws BaseException{
		return getDao().deleteBySql(sql);
	}
	

	/**
	 * 描述: SQL增加
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:26:20
	 * @see com.otc.uc.base.service.IBaseService#insertBySql(java.lang.String)  
	*/ 
	public Integer insertBySql(String sql) throws BaseException{
		return getDao().insertBySql(sql);
	}
	
	
	/**
	 * 描述: 查询分页数
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:26:35
	 * @see com.otc.uc.base.service.IBaseService#selectByMapPagingCount(java.util.Map)  
	*/ 
	public Integer selectByMapPagingCount(Map<?,?> map) throws BaseException{
		return getDao().selectByMapPagingCount(map);
	}
	
	/**
	 * 描述: 查询分页
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:26:49
	 * @see com.otc.uc.base.service.IBaseService#selectByMapPaging(java.util.Map)  
	*/ 
	public List<T> selectByMapPaging(Map map) throws BaseException{
	    BaseModel model= (BaseModel)map.get("basemModel");
	    map.put("basemModel", model);
		return getDao().selectByMapPaging(map);
	}
	
	
	/**
	 * 描述: 根据主键删除一条记录
	 * @param:
	 * @return: 
	 * @author: 
	 * @date: 2015年11月2日 下午3:27:18
	 * @see com.otc.uc.base.service.IBaseService#deleteByPrimaryKey(java.lang.Object)  
	*/ 
	public Integer deleteByPrimaryKey(Object key) throws BaseException {
		return getDao().deleteByPrimaryKey(key);
	}
	/**
	 * 获得分页VO
	 * @return PageVo<Admin>
	 * @throws BaseException 
	 */
	public PageVo<T> getAllListPage(int pageNum, T model) throws BaseException {
		PageVo<T> pageVo = new PageVo<T>(pageNum);
		model.setOffset(pageVo.getOffset());
		model.setRows(pageVo.getRows());
		pageVo.setList(this.selectByModelPaging(model));
		pageVo.setCount(this.selectByModelPagingCount(model));
		pageVo.getPageNumHtml();
		return pageVo;
	}
	
	/**
	 * 获得分页VO
	 * @return PageVo<Admin>
	 * @throws BaseException 
	 */
	public PageJson<T> getAllListJsonPage(int pageNum, T model) throws BaseException {
		PageVo<T> pageVo = new PageVo<T>(pageNum);
		model.setOffset(pageVo.getOffset());
		model.setRows(pageVo.getRows());
		PageJson<T> pageJsonVo = new PageJson<T>(pageNum, pageVo.getRows());
		try{
			pageJsonVo.setResultSet(this.selectByModelPaging(model));
			pageJsonVo.setMatchedTotal(this.selectByModelPagingCount(model));
			pageJsonVo.setStatus(0);
			pageJsonVo.setMsg("分页信息获取成功。");
		} catch(BaseException e){
			pageJsonVo.setResultSet(null);
			pageJsonVo.setMatchedTotal(0);
			pageJsonVo.setStatus(1);
			pageJsonVo.setMsg("分页信息获取失败。");
		}
		return pageJsonVo;
	}
}
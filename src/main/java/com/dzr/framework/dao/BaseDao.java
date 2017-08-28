
package com.dzr.framework.dao;


import com.dzr.framework.entity.BaseEntity;
import com.dzr.framework.mybatis.BaseProvider;
import com.dzr.framework.mybatis.Sort;
import com.dzr.framework.mybatis.complexQuery.CustomQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface BaseDao<T extends BaseEntity> {
	
	@SelectProvider(type = BaseProvider.class, method = "getAll")
	@Options(flushCache = false,useCache = true)
	@ResultMap("getMap")
	public List<T> getAll();

	@SelectProvider(type = BaseProvider.class, method = "getById")
	@Options(flushCache = false,useCache = true)
	@ResultMap("getMap")
	public T getById(String id);

	@SelectProvider(type = BaseProvider.class, method = "count")
	@Options(flushCache = false,useCache = true)
	public int count(T params);

	@SelectProvider(type = BaseProvider.class, method = "countLike")
	@Options(flushCache = false,useCache = true)
	public int countLike(T findParams);

	@SelectProvider(type = BaseProvider.class, method = "countQuery")
	@Options(flushCache = false,useCache = true)
	public int countQuery(@Param("queryParams") List<CustomQueryParam> customQueryParams);
	
	@SelectProvider(type = BaseProvider.class, method = "get")
	@Options(flushCache = false,useCache = true)
	@ResultMap("getMap")
	public T getOne(T findParams);
	
	@SelectProvider(type = BaseProvider.class, method = "query")
	@Options(flushCache = false,useCache = true)
	@ResultMap("getMap")
	public List<T> query(@Param("queryParams") List<CustomQueryParam> customQueryParams, @Param("sortList") List<Sort> sortList);

	@SelectProvider(type = BaseProvider.class, method = "get")
	@Options(flushCache = false,useCache = true)
	@ResultMap("getMap")
	public List<T> get(T findParams);

	@SelectProvider(type = BaseProvider.class, method = "find")
	@Options(flushCache = false,useCache = true)
	@ResultMap("getMap")
	public List<T> find(T findParams);

	@InsertProvider(type = BaseProvider.class, method = "insert")
	@Options(keyProperty = "id",flushCache = true)
	public int insert(T t);

	@InsertProvider(type = BaseProvider.class, method = "insertBatch")
	@Options(keyProperty = "id",flushCache = true)
	public int insertBatch(@Param("list") List<T> list);
	
	@DeleteProvider(type = BaseProvider.class, method = "delete")
	@Options(flushCache = true)
	public int delete(String id);

	@DeleteProvider(type = BaseProvider.class, method = "deleteByPrimaryKey")
	@Options(flushCache = true)
	public int deleteByPrimaryKey(T t);

	@UpdateProvider(type = BaseProvider.class, method = "update")
	@Options(flushCache = true)
	public int update(T t);

    @DeleteProvider(type = BaseProvider.class,method = "deleteAll")
	@Options(flushCache = true)
    public int deleteAll();

}

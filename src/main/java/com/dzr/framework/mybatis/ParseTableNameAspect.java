package com.dzr.framework.mybatis;


import com.dzr.framework.entity.BaseEntity;
import org.apache.ibatis.binding.MapperProxy;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

@Aspect
@Component
public class ParseTableNameAspect {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Around("execution(* com.dzr.framework.dao.BaseDao.*(..))")
	public Object invoke(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		parseTableName(proceedingJoinPoint);
		
		return proceedingJoinPoint.proceed();
	}
	
	private void parseTableName(ProceedingJoinPoint proceedingJoinPoint)
			throws NoSuchFieldException, IllegalAccessException,
			ClassNotFoundException {
		// 将modelClass添加到线程变量
		if(proceedingJoinPoint.getArgs()!=null
				&&proceedingJoinPoint.getArgs().length>0
				&&proceedingJoinPoint.getArgs()[0] instanceof BaseEntity){
			BaseProvider.setModelClass(proceedingJoinPoint.getArgs()[0].getClass());
		}else{
			// 获取代理目标对象
			Field h = Proxy.class.getDeclaredField("h");
			h.setAccessible(true);
			Object proxyTarget = h.get(proceedingJoinPoint.getTarget());
			// 获取dao类
			Field mapperInterface = MapperProxy.class
					.getDeclaredField("mapperInterface");
			mapperInterface.setAccessible(true);
			Class<?> cl = (Class<?>) mapperInterface.get(proxyTarget);

			// 获取model类
			String modelName = cl.getName().replace(".dao.", ".entity.").replace("Dao", "");
			BaseProvider.setModelClass(Class.forName(modelName));
		}
	}

}

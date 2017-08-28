/**
 * 营运系统
 * com.ane56.aneos.entity
 * BaseEntity.java
 * 1.0
 * 2014年10月28日-下午1:23:18
 *  2014安能物流-版权所有
 *
 */
package com.dzr.framework.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * 类名称：BaseEntity
 * 类描述：
 * @version 1.0.0
 *
 */
@Data
public class BaseEntity implements Serializable{

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 4089285837632643882L;

	public static final String CREATE_DATE_PROPERTY_NAME = "createTime";// "创建日期"属性名称
	public static final String MODIFY_DATE_PROPERTY_NAME = "updateTime";// "修改日期"属性名称
	@Id
	protected String id;// ID
	protected Date createTime;// 创建日期
//	protected String createUser;// 创建人
	protected Date updateTime;// 修改日期
//	protected String updateUser;// 修改人
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BaseEntity other = (BaseEntity) obj;
		if (id == null || other.getId() == null) {
			return false;
		} else {
			return (id.equals(other.getId()));
		}
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
}

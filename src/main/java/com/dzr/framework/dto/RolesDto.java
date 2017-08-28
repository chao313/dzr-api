package com.dzr.framework.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Package Name: com.sdxd.framework.dto Description: Author: qiuyangjun
 * Create Date:2015/2/3
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class RolesDto {
	
	private String roleName;

	private String code;

	private String description;
}

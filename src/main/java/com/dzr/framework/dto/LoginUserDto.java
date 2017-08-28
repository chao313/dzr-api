package com.dzr.framework.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by qiuyangjun on 2015/1/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class LoginUserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

    private Long userId;

    private String userName;

    private String realName;

    private Date loginTime;

    private String loginIp;

    List<ResourcesDto> resourcesList;
    List<RolesDto> rolesList;
}

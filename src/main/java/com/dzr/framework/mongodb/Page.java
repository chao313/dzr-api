package com.dzr.framework.mongodb;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
@Setter
@Getter
public class Page<T> implements Serializable{

	private Long total;
	private Integer pageNumber;
	private Integer pageSize;
	private List<T> rows;
	
	
}

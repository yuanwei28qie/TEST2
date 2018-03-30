package com.microsilver.mrcard.serviceplatform.model.query;

import java.io.Serializable;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.model.query.BaseQuery
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月4日 下午12:59:22
 * @Copyright Micro Silver
 *
 */
public class BaseQuery implements Serializable, Cloneable {
	private int page;                   //第几页
    private int rows;                   //每页大小
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
    
    
}

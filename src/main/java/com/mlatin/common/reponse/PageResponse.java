package com.mlatin.common.reponse;

import java.util.List;

public class PageResponse<T> extends BaseResponse<List<T>> {

	@SuppressWarnings("unused")
	private int size;
	private int total;
	private int pageNo;
	private int pageSize = 10;

	public int getSize() {
		if (pageNo == 0) {
			return 1;
		}
		return total == 0 ? 1 : this.total % this.pageSize == 0 ? total / pageSize : total / pageSize + 1;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}

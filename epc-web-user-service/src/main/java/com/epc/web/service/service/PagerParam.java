package com.epc.web.service.service;


import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;


public class PagerParam implements Serializable {

  public static final int FIRST_CRITERIA_INDEX = 0;

  /**
   * 从第几页记录开始查询
   */
  private Integer page;

  /**
   * 限制返回记录数
   */
  private Integer rows;

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getRows() {
    return rows;
  }

  public void setRows(Integer rows) {
    this.rows = rows;
  }

  public RowBounds getRowBounds() {
    if (this.getRows() == null || this.getPage() == null) {
      return new RowBounds();
    } else {
      return new RowBounds(
          this.getPage() == null ? FIRST_CRITERIA_INDEX : (this.getPage() - 1) * this.getRows(),
          this.getRows());
    }
  }

}

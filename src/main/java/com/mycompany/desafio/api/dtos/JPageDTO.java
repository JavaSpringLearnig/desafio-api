package com.mycompany.desafio.api.dtos;

import com.mycompany.desafio.api.base.util.ETipoOrdenacao;

public class JPageDTO {

    private Integer pageSize;
    private Integer pageNumber;
    private String pageOrderBy;
    private ETipoOrdenacao pageDirection;

    public JPageDTO(Integer pageSize, Integer pageNumber, String pageOrderBy, ETipoOrdenacao pageDirection) {
        super();
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.pageOrderBy = pageOrderBy;
        this.pageDirection = pageDirection;
    }

    public JPageDTO() {
        super();
        this.pageSize = 20;
        this.pageNumber = 0;
        this.pageOrderBy = null;
        this.pageDirection = null;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageOrderBy() {
        return pageOrderBy;
    }

    public void setPageOrderBy(String pageOrderBy) {
        this.pageOrderBy = pageOrderBy;
    }

    public ETipoOrdenacao getPageDirection() {
        return pageDirection;
    }

    public void setPageDirection(ETipoOrdenacao pageDirection) {
        this.pageDirection = pageDirection;
    }

}

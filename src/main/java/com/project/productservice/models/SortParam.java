package com.project.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortParam {
    private String sortType;
    private String sortDirection; //ASC or DSC
}

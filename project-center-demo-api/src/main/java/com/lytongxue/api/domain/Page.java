package com.lytongxue.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> implements Serializable {

    private Integer total;

    private List<T> rows = new ArrayList<>();

}

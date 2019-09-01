package com.lytongxue.domain;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagination<T> {

    private Integer total;

    private List<T> rows = new ArrayList<>();

    public static <T> Pagination<T> from(Page<T> page) {
        return new Pagination<>((int) page.getTotal(), page.getRecords());
    }

}


/*
 * Copyright (c) 2017 Redlink GmbH.
 */
package com.rbmhtechnology.vind.report.model.request;

import com.rbmhtechnology.vind.api.query.division.Page;
import com.rbmhtechnology.vind.api.query.division.ResultSubset;
import com.rbmhtechnology.vind.api.query.division.Slice;

/**
 * Created on 03.10.17.
 */
public class Paging {

    private long index;
    private long size;
    private ResultSubset.DivisionType type;

    public Paging(ResultSubset resultSet) {
        this.type = resultSet.getType();
        switch (resultSet.getType()) {
            case page:
                index = ((Page)resultSet).getPage();
                size = ((Page)resultSet).getPagesize();
                break;

            case slice:
                index= ((Slice)resultSet).getOffset();
                size = ((Slice)resultSet).getSliceSize();
                break;

            default: break;
        }
    }
}

package com.rudolfs.rxjava.migration.basetypes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateResult {
    private Long modifiedCount;
    private String updatedId;
}

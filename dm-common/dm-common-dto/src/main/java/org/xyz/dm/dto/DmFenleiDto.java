package org.xyz.dm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 第七个不同分类排行
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DmFenleiDto {

    private Integer id;
    private String itemName;
    private Integer areaId;
    private String areaName;

}

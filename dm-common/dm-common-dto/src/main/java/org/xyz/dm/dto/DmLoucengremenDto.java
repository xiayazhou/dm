package org.xyz.dm.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DmLoucengremenDto {

    private Integer id;
    private String itemName;
    private Integer areaId;
    private String areaName;
    private String address;
    private String startDate;
    private String endDate;
    private String imgUrl;
    private String minPrice;
}

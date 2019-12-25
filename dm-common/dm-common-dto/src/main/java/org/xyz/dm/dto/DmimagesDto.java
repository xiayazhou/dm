package org.xyz.dm.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 轮播图
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DmimagesDto {

    private Integer id;
    private String itemName;
    private Double minPrice;
    private String imgUrl;

}

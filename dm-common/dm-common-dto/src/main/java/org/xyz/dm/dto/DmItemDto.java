package org.xyz.dm.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 热门节目Dao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DmItemDto {

    private Integer id;
    private String itemName;
    private Double minPrice;
    private String imgUrl;


}

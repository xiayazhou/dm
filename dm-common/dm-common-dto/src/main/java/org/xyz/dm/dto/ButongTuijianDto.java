package org.xyz.dm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/27 8:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ButongTuijianDto {
    private Integer id;
    private String itemName;
    private String areaId;
    private String areaName;
}

package org.xyz.dm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/26 12:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class childrenDto {

             private Integer id;
             private String itemType;
             private Integer level;
             private Integer parent;
             private String aliasName;
}

package org.xyz.dm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/26 10:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DmDaohangDto {
    private Integer id;
    private String itemType;
    private Integer level;
    private String aliasName;
    private String key;
}

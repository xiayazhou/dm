package org.xyz.dm.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/26 16:39
 */
public class ShangPinLeiDto {
    private Long id;
    private String aliasName;
    private List<childrenDto> children = new ArrayList();
    //    private List<DmItem> hotItems = new ArrayList<>();
    private String itemType;
    private String level;
    private Integer parent;
    private List<DmItemDto> hotItems=new ArrayList();
}

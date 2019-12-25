package org.xyz.dm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DmItemTypeDto {

    private Long id;
    private String aliasName;
    private List<DmItemTypeDto> children = new ArrayList();
//    private List<DmItem> hotItems = new ArrayList<>();
    private String itemType;
    private String level;
    private Integer parent;
    private List<DmItemDto> hotItems=new ArrayList();

}

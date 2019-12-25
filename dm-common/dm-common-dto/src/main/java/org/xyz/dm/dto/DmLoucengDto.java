package org.xyz.dm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DmLoucengDto {

    private Integer floor;//楼层
    private String itemTypeName;//楼层名称
    private Integer itemTypeId;//剧目分类id
    private List<DmLoucengremenDto> louceng=new ArrayList<DmLoucengremenDto>();
}

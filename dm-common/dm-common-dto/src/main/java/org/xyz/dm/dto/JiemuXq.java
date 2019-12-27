package org.xyz.dm.dto;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/27 9:24
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 节目详情
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JiemuXq {

    private Integer id;
    private String abstractMessage;
    private String itemName;
    private Integer itemType1Id;
    private String itemType1Name;
    private Integer itemType2Id;
    private String itemType2Name;
    private Integer areaId;
    private String areaName;
    private Date startTime;
    private Date endTime;
    private Integer state;
    private String basicDescription;
    private String projectDescription;
    private String reminderDescription;
    private String imgUrl;
    private Integer cinemaId;
    private String adress;
    private String latitude;
    private String longitude;
    private Double avgScore;
    private Integer commentCount;
}

package org.xyz.dm.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dm_item",schema = "dm_item")
public class DmItem extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String itemName;
  private String abstractMessage;
  private Integer itemType1Id;
  private String itemType1Name;
  private Integer itemType2Id;
  private String itemType2Name;
  private Integer state;
  private String basicDescription;
  private String projectDescription;
  private String reminderDescription;
  private String longitude;
  private String latitude;
  private Integer isBanner;
  private Integer isRecommend;
  private Double avgScore;
  private Integer commentCount;
  private Integer cinemaId;
  private Date startTime;
  private Date endTime;
  private Double minPrice;
  private Double maxPrice;
  private Integer ageGroup;





}

package org.xyz.dm.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dm_cinema",schema = "dm_item")
public class DmCinema extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String address;
  private Integer areaId;
  private String areaName;
  private Integer xLength;
  private Integer yLength;
  private String latitude;
  private String longitude;




}

package org.xyz.dm.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.xyz.dm.entity.BaseEntity;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dm_image",schema = "dm_base")
public class DmImage extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String imgUrl;
  private Integer targetId;
  private Integer sort;
  private Integer type;
  private Integer category;


}

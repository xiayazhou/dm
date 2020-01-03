package org.xyz.dm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/28 17:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dm_area",schema = "dm_base")
public class DmArea extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String parent;
    private Integer level;
    private Integer isHot;
}

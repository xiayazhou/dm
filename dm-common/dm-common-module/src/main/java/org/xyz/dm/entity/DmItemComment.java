package org.xyz.dm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/27 10:06
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dm_item_comment",schema = "dm_item")
public class DmItemComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer itemId;
    private Integer userId;
    private Integer score;
    private String content;
}

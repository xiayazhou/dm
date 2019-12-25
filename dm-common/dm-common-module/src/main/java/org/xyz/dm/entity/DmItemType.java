package org.xyz.dm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "dm_item", name = "dm_item_type")
public class DmItemType extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemType;
    private String level;
    private Integer parent;
    private String aliasName;
    private String key;
}

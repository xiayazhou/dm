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
@Table(schema = "dm_user", name = "dm_user")
public class DmUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String phone;
  private String password;
  private String wxUserId;
  private String realName;
  private String nickName;
  private Integer sex;
  private String hobby;
  private String idCard;
  private Date birthday;
  private Date createdTime;
  private Date updatedTime;




}

package org.xyz.dm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DmUserDto {
    private Integer userId;
    private String phone;
    private String password;
    private String wxUserId;
    private String realName;
    private String nickName;
    private Integer sex;
    private String hobby;
    private String idCard;
    private String birthday;
    private String createdTime;
    private String updatedTime;
    private Integer imageId;
    private String imageUrl;

    private String token;
    private Integer expTime;//有效期
    private Long genTime;//Token创建时间
}

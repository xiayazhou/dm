package org.xyz.dm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/27 10:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JupingDto {

    private Integer itemId;
    private Integer userId;
    private String imgUrl;
    private Integer score;
    private String content;
    private String createdTime;


}

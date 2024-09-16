package com.weijin.recruitment.model.vo.position;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/9 15:52
 */
@Data
public class PositionDetailVO {
    private Integer id;

    private String name;

    private Integer number;

    private Integer miniSalary;

    private Integer maxSalary;

    private String jobPlace;

    private Integer education;

    private String jobRequire;

    private Integer status;

    private String postName;

    private String companyName;

    private String address;

    private String logo;

    private String intro;
    /**
     * 投递id，用于判断求职者是否投递了该职位
     */
    private Integer rdId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}

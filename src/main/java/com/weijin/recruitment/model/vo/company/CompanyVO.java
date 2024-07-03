package com.weijin.recruitment.model.vo.company;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/3 17:00
 */
@Data
public class CompanyVO {
    private Integer id;
    private String name;
    private String address;
    private String logo;
    private String intro;
    private Integer status;
}

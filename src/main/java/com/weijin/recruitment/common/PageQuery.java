package com.weijin.recruitment.common;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/9/8 14:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageQuery {
    private Integer pageNum = 1;
    private Integer pageSize = 20;
    @Nullable
    private HashMap<String,Object> params;
}

package com.weijin.recruitment.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import jakarta.validation.constraints.NotBlank;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/10/19 16:01
 */
public class CodeUtil {
    private CodeUtil() {
    }

    /**
     * 检验验证码
     *
     * @param rightCode 正确的验证码
     * @param code      用户传入的验证码
     * @return 结果
     */
    public static boolean verityCode(@NotBlank String rightCode, @NotBlank String code) {
        if (StringUtils.isBlank(rightCode)) {
            return false;
        }
        if (!rightCode.equalsIgnoreCase(code)) {
            return false;
        }
        return true;
    }
}

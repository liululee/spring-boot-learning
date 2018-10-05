package com.developlee.errorhandle.controller;

import com.developlee.errorhandle.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

/**
 * @author Lensen
 * @desc
 * @since 2018/10/5 11:00
 */
@Controller
public class DemoController {

    /**
     * 关于@ModelAttribute,
     * 可以使用ModelMap以及@ModelAttribute()来获取参数值。
     */

    @GetMapping("/one")
    public String testError(ModelMap modelMap ) {
        throw new CustomException(500L, "系统发生500异常！" + modelMap.get("attribute"));
    }

    @GetMapping("/two")
    public String testTwo(@ModelAttribute("attribute") String attribute) {
        throw new CustomException(500L, "系统发生500异常！" + attribute);
    }
}

package cn.sixlab.minesite.controller;

import cn.sixlab.minesite.utils.ResultUtils;
import cn.sixlab.minesite.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.PermitAll;

@PermitAll
@Controller
@RequestMapping("")
public class IndexController {

    @ResponseBody
    @RequestMapping(value = {"/", "/index"})
    public Result index() {
        return ResultUtils.success();
    }
}

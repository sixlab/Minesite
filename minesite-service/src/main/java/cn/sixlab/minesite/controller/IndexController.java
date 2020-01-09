package cn.sixlab.minesite.controller;

import cn.sixlab.minesite.utils.ResultUtils;
import cn.sixlab.minesite.vo.Result;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class IndexController {

    @ResponseBody
    @RequestMapping(value = {"/", "/index"})
    public Result index() {
        return ResultUtils.success();
    }

    @PostAuthorize("denyAll")
    @ResponseBody
    @RequestMapping(value = {"/test/login"})
    public Result login() {
        return ResultUtils.success();
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    @RequestMapping(value = {"/test/auth"})
    public Result auth() {
        return ResultUtils.success();
    }

    @PreAuthorize("isAnonymous()")
    @ResponseBody
    @RequestMapping(value = {"/test/index"})
    public Result test() {
        return ResultUtils.success();
    }

    @PreAuthorize("hasRole('admin')")
    @ResponseBody
    @RequestMapping(value = {"/test/test"})
    public Result test2() {
        return ResultUtils.success();
    }
}

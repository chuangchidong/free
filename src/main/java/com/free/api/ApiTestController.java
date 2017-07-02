package com.free.api;

import com.free.entity.UserEntity;
import com.free.utils.R;
import com.free.utils.annotation.IgnoreAuth;
import com.free.utils.annotation.LoginUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangzhidong on 2017/7/2.
 */
@RestController
@RequestMapping("api")
@Api("测试接口")
public class ApiTestController {

    /**
     * 获取用户信息
     * @param user
     * @return
     */
    @GetMapping("userInfo")
    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "token", required = true)
    public R userInfo(@LoginUser UserEntity user) {

        return  R.ok().put("user",user);
    }

    @IgnoreAuth
    @GetMapping("notToken")
    @ApiOperation(value = "忽略token验证测试")
    public R notToken() {
        return R.ok().put("msg","无需token也能访问");
    }
}

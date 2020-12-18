package zhanweikai.com.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import zhanweikai.com.common.RestResult;
import zhanweikai.com.service.PeriodService;

import javax.annotation.Resource;

@RestController
@Api(tags = "时间段管理")
public class PeriodController {

    @Resource
    private PeriodService periodService;

    @ApiOperation(value = "时间段查询")
    @ApiImplicitParam(name = "", value = "")
    @PostMapping("/api/period/search")
    public RestResult searchPeriod(){
        return periodService.searchPeriod();
    }

}

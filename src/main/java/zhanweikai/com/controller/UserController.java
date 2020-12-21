package zhanweikai.com.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zhanweikai.com.common.RestResult;
import zhanweikai.com.pojo.User;
import zhanweikai.com.service.UserService;
import zhanweikai.com.vo.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@Api(tags = "用户管理")
public class UserController {
    @Resource
    private UserService userService;




    @ApiOperation(value = "用户查询")
    @ApiImplicitParam(name = "userId", value = "用户id信息")
    @PostMapping("/api/user/searchById")
    public RestResult search(@RequestBody Map<String, Long> userId){
        Long id = userId.get("id");
        User user = userService.selectById(id);
        return null;
    }

    @ApiOperation(value = "根据用户的名字和手机进行模糊查询")
    @ApiImplicitParam(name = "searchInfo", value = "用户查询信息")
    @PostMapping("/api/user/searchByPhoneAndName")
    public RestResult searchByPhoneAndName(@RequestBody Map<String, UserQueryDTO> searchInfo){

        UserQueryDTO userQueryDTO = searchInfo.get("userQueryDTO");



        return userService.searchByPhoneAndName(userQueryDTO);
    }


    @ApiOperation(value = "用户启用")
    @ApiImplicitParam(name = "userId", value = "用户id信息")
    @PostMapping("/api/user/enable")
    public RestResult enable(@RequestBody Map<String, Long> userId){
        Long id = userId.get("id");
        int  result = userService.updateTypeEnabled(id);
        if(result > 0){
            return RestResult.success("启用成功");
        }else{
            return RestResult.error(402,"启用失败");
        }

    }


    @ApiOperation(value = "用户禁用")
    @ApiImplicitParam(name = "userId", value = "用户id信息")
    @PostMapping("/api/user/disable")
    public RestResult disable(@RequestBody Map<String, Long> userId){
        Long id = userId.get("id");
        int  result = userService.updateTypeDisabled(id);
        if(result > 0){
            return RestResult.success("禁用成功");
        }else{
            return RestResult.error(402,"禁用成功");
        }
    }

    @ApiOperation(value = "用户添加")
    @ApiImplicitParam(name = "user", value = "用户信息")
    @PostMapping("/api/user/save")
    //
    public RestResult save(@RequestBody Map<String, User> userInfo){
        User user = userInfo.get("userInfo");
        if("初级".equals(user.getLevel())){
            user.setLevel(User.LEVEL_LOW);
        }else if ("中级".equals(user.getLevel())){
            user.setLevel(User.LEVEL_MIDDLE);
        }else if ("高级".equals(user.getLevel())){
            user.setLevel(User.LEVEL_HIGH);
        }else {
            user.setLevel(User.LEVEL_NO_LEVEL);
        }
        return  userService.save(user);

    }


    @ApiOperation(value = "用户添加")
    @ApiImplicitParam(name = "user", value = "用户信息")
    @PostMapping("/api/user/culculateDiscount")
    public RestResult culculate(@RequestBody Map<String, CulculateDTO> reduceInfo){
        CulculateDTO info = reduceInfo.get("reduceInfo");
        Long userId = info.getUserId();
        Double reduceBalance = info.getReduceBalance();

        return  userService.culculateReduce(userId,reduceBalance);
    }


//    @ApiOperation(value = "用户添加")
////    @ApiImplicitParam(name = "user", value = "用户信息")
////    @PostMapping("/api/user/updateBalance")
////    public RestResult updateBalance(@RequestBody Map<String, Double> actualBalanceInfo){
////        Double actualBalance = actualBalanceInfo.get("actualBalance");
////
////
////        return  null;
////    }
        @ApiOperation(value = "用户扣费")
        @ApiImplicitParam(name = "user", value = "用户信息")
        @PostMapping("/api/user/reduceBalance")
        public RestResult reduceBalance(@RequestBody JSONObject jsonObject){
            String actualBalance_ = (String)jsonObject.get("actualBalance");
            String userId = (String) jsonObject.get("userId");
            Long id = Long.parseLong(userId);
            Double actualBalance = Double.parseDouble(actualBalance_);


            return  userService.reduceBalance(id,actualBalance);
        }


    @ApiOperation(value = "用户充值")
    @ApiImplicitParam(name = "user", value = "用户信息")
    @PostMapping("/api/user/rechargeBalance")
    public RestResult rechargeBalance(@RequestBody JSONObject jsonObject){
        String rechargeMoney_ = (String)jsonObject.get("rechargeMoney");
        String userId = (String) jsonObject.get("userId");
        Long id = Long.parseLong(userId);
        Double rechargeMoney = Double.parseDouble(rechargeMoney_);


        return  userService.rechargeBalance(id,rechargeMoney);
    }

    @ApiOperation(value = "根据手机查询用户信息")
    @ApiImplicitParam(name = "phone", value = "手机信息")
    @PostMapping("/api/user/searchUserType")
    public RestResult searchUserType(@RequestBody JSONObject jsonObject){
        String phone = (String) jsonObject.get("userPhone");

        return userService.searchUserType(phone);
    }


    @ApiOperation(value = "根据充值金额确定会员级别")
    @ApiImplicitParam(name = "balance", value = "充值金额")
    @PostMapping("/api/user/culculateLevel")
    public RestResult getType(@RequestBody JSONObject jsonObject){
        String balance = (String) jsonObject.get("userBalance");
        Double balance_ = Double.parseDouble(balance);
        return userService.getTypeByBalance(balance_);
    }





}

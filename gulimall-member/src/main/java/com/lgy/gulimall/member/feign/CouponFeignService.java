package com.lgy.gulimall.member.feign;

import com.lgy.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gulimall-coupon") //说明这是一个远程调用客户端，调用的是gulimall-coupon这个远程服务
public interface CouponFeignService {

    /**
     * 1.复制的是另一个服务的全部信息，注意路径一定要全，尤其是类上面的路径别忘记.
     * 2. 当我们以后调用这个方法，这个就会去 注册中心找远程服务gulimall-coupon 然后调用的下面路径的方法
     * @return
     */
    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();


}

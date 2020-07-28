package com.zhk.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 赵洪苛
 * @date 2020/7/28 19:28
 * @description 负载均衡
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);



}

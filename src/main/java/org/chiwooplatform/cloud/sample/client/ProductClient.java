package org.chiwooplatform.cloud.sample.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "product-service", fallback = ProductClientFallback.class)
public interface ProductClient
{
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    String greeting();
}

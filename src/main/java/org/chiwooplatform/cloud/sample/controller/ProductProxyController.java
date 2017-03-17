package org.chiwooplatform.cloud.sample.controller;

import org.chiwooplatform.cloud.sample.message.MessageWrapper;
import org.chiwooplatform.cloud.sample.proxy.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductProxyController {
    private static Logger logger = LoggerFactory.getLogger(ProductProxyController.class);

    @Autowired
    private ProductClient productClient;

    @RequestMapping(value = "/proxy/product/greeting", method = RequestMethod.GET)
    public MessageWrapper<String> greeting() {
        logger.debug("Reading customer using feign client.");
        String result = productClient.greeting();
        return new MessageWrapper<>(result, "server called using eureka with feign");

    }

}

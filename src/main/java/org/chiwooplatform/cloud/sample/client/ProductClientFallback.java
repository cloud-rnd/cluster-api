package org.chiwooplatform.cloud.sample.client;

import org.springframework.stereotype.Component;

@Component
public class ProductClientFallback
    implements ProductClient
{
    @Override
    public String greeting()
    {
        return "Hello, This message is made by Fallback";
    }
}

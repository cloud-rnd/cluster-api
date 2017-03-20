package org.chiwooplatform.cloud.sample.client;

import org.chiwooplatform.cloud.sample.message.MessageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * <pre>
 * You can simply implement remote call procedure like this
 * <code>
    public MessageWrapper<Customer> getCustomer(int id) {
        Customer customer = restTemplate
                .exchange("http://customer-service/customers/{id}", HttpMethod.GET, null,
                        new ParameterizedTypeReference<Customer>() {
                        }, id)
                .getBody();

        return new MessageWrapper<>(customer,
                "server called using eureka withrest template");
    }
</code>
 * </pre>
 * 
 * @author seonbo.shim
 */
@Component
public class CustomerClient
{
    @Autowired
    private RestTemplate restTemplate;

    /**
     * MessageWrapper m = customerClient.greeting();
     * 
     * @return
     */
    public MessageWrapper<String> greeting()
    {
        String result = restTemplate.exchange( "http://customer-service/greeting", HttpMethod.GET, null, String.class )
                                    .getBody();
        return new MessageWrapper<>( result, "server called using eureka with RestTemplate(ribbon)" );
    }
}

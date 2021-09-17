package com.horidream.test.testgraphql.resolver;

import com.horidream.test.testgraphql.domain.bank.BankAccount;
import com.horidream.test.testgraphql.domain.bank.Client;
import com.horidream.test.testgraphql.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {
    public BankAccount bankAccount(UUID id){
        log.info("retrieving bank account id: {}", id);

        Client a = Client.builder()
                .id(UUID.randomUUID())
                .firstName("Leon")
                .lastName("Cao")
                .build();
        Client b = Client.builder()
                .id(UUID.randomUUID())
                .firstName("Baoli")
                .lastName("Zhai")
                .build();
        a.setClient(b);
        b.setClient(a);
        return BankAccount.builder()
                .id(id)
                .currency(Currency.RMB)
                .client(a)
                .build();
    }


}

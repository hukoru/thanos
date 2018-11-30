package com.thanos.api.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Optional;


public class AccountResponse  {

    @Getter
    public static class Response {

        private String providerId = "";
        private String loginId = "";
        private String password = "";
        private @NotNull ProviderType providerType = ProviderType.NOT_DEFINED;

        public Response (Optional<Account> account) {

            account.ifPresent(value -> {
                this.providerId = value.getLoginId();
                this.loginId = value.getLoginId();
                this.password = value.getPassword();
                this.providerType = value.getProviderType();
            });

        }

    }

}

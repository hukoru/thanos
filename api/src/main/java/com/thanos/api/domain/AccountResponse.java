package com.thanos.api.domain;

import com.thanos.api.result.ResultBody;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Optional;


public class AccountResponse extends ResultBody {

    @Getter
    public static class Response {

        private String providerId = "";
        private String loginId = "";
        private String password = "";
        private @NotNull ProviderType providerType = ProviderType.NOT_DEFINED;

        public Response (Account account) {

            this.providerId = account.getProviderId();
            this.loginId = account.getLoginId();
            this.password = account.getPassword();
            this.providerType = account.getProviderType();

           /* account.ifPresent(value -> {
                this.providerId = value.getLoginId();
                this.loginId = value.getLoginId();
                this.password = value.getPassword();
                this.providerType = value.getProviderType();
            });*/

        }

    }

}

package com.thanos.api.result;

import com.thanos.api.domain.Account;
import com.thanos.api.domain.ProviderType;
import lombok.*;
import javax.validation.constraints.NotNull;

public class AccountResponse extends ResultBody {

    @Getter
    public static class Response {

        private String displaySetName;
        private String loginId;
        private String password;
        private @NotNull ProviderType providerType;

        public Response (Account account) {

            this.displaySetName = account.getDisplaySetName();
            this.loginId = account.getLoginId();
            this.password = account.getPassword();
            this.providerType = account.getProviderType();
        }

    }

}

package com.fastcampus.newboardproject.config;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import com.fastcampus.newboardproject.domain.UserAccount;
import com.fastcampus.newboardproject.repository.UserAccountRepository;
import java.util.Optional;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

@Import(SecurityConfig.class)
public class TestSecurityConfig {
    @MockBean private UserAccountRepository userAccountRepository;

    @BeforeTestMethod
    public void SecuritySetUp() {
        given(userAccountRepository.findById(anyString())).willReturn(Optional.of(UserAccount.of(
                "wndgnTest",
                "pw",
                "wndgn-test@email.com",
                "wndgn-test",
                "test memo"
        )));
    }
}

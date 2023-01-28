package com.tolmachevsv.tests.properties;

import com.tolmachevsv.config.CredentialsConfig;
import com.tolmachevsv.tests.TestBase;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;

import static java.lang.String.format;

@Tag("properties")
public class OwnerTest extends TestBase {

    public CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    void ReadCredentialsTest() {
        String login = credentials.login();
        String password = credentials.password();

        String selenoidUrl = format("https://%s:%s@selenoid.autotests.cloud/wd/hub", login, password);
    }
}

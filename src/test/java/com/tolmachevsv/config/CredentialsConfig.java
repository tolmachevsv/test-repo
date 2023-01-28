package com.tolmachevsv.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public interface CredentialsConfig extends Config {

    String login();
    String password();
}

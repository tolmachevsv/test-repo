package com.tolmachevsv.config;

import org.aeonbits.owner.Config;

public interface CredentialsConfig extends Config {

    String login();
    String password();
}

/* (c) 2018 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.security.config;

public class KeycloakSecurityServiceConfig extends BaseSecurityNamedServiceConfig {

    private String serverURL;
    private String idOfClient;
    private String clientSecret;

    public KeycloakSecurityServiceConfig() {}

    public KeycloakSecurityServiceConfig(KeycloakSecurityServiceConfig other) {
        super(other);
        serverURL = other.getServerURL();
        idOfClient = other.getIdOfClient();
        clientSecret = other.getClientSecret();
    }

    public String getServerURL() {
        return serverURL;
    }

    public void setServerURL(String serverURL) {
        this.serverURL = serverURL;
    }

    public String getIdOfClient() {
        return idOfClient;
    }

    public void setIdOfClient(String idOfClient) {
        this.idOfClient = idOfClient;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}

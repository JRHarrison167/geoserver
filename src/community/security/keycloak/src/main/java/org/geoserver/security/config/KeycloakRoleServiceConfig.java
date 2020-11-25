/* (c) 2018 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.security.config;

public class KeycloakRoleServiceConfig extends KeycloakSecurityServiceConfig
        implements SecurityRoleServiceConfig {

    protected String adminRoleName;
    protected String groupAdminRoleName;

    public KeycloakRoleServiceConfig() {}

    public KeycloakRoleServiceConfig(KeycloakRoleServiceConfig other) {
        super(other);
        adminRoleName = other.getAdminRoleName();
        groupAdminRoleName = other.getGroupAdminRoleName();
    }

    @Override
    public String getAdminRoleName() {
        return adminRoleName;
    }

    @Override
    public void setAdminRoleName(String name) {
        adminRoleName = name;
    }

    public String getGroupAdminRoleName() {
        return groupAdminRoleName;
    }

    public void setGroupAdminRoleName(String groupAdminRoleName) {
        this.groupAdminRoleName = groupAdminRoleName;
    }
}

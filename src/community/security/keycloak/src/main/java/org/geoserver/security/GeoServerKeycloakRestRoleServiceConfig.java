/* (c) 2016 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.security;

import org.geoserver.security.config.BaseSecurityNamedServiceConfig;
import org.geoserver.security.config.SecurityRoleServiceConfig;

public class GeoServerRestRoleServiceConfig extends BaseSecurityNamedServiceConfig
        implements SecurityRoleServiceConfig {

    private String adminGroup;

    private String groupAdminGroup;

    @Override
    public String getAdminRoleName() {
        return adminGroup;
    }

    @Override
    public void setAdminRoleName(String adminRoleName) {
        this.adminGroup = adminRoleName;
    }

    @Override
    public String getGroupAdminRoleName() {
        return groupAdminGroup;
    }

    @Override
    public void setGroupAdminRoleName(String adminRoleName) {
        this.groupAdminGroup = adminRoleName;
    }
}
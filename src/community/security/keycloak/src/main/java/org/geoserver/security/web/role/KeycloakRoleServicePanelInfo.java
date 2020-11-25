/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.security.web.role;

import org.geoserver.security.config.KeycloakRoleServiceConfig;
import org.geoserver.security.impl.KeycloakRoleService;

/** Configuration panel extension for {@link KeycloakRoleService}. */
public class KeycloakRoleServicePanelInfo
        extends RoleServicePanelInfo<KeycloakRoleServiceConfig, KeycloakRoleServicePanel> {

    public KeycloakRoleServicePanelInfo() {
        setComponentClass(KeycloakRoleServicePanel.class);
        setServiceClass(KeycloakRoleService.class);
        setServiceConfigClass(KeycloakRoleServiceConfig.class);
        setPriority(0);
    }
}

/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.security.web.role;

import org.geoserver.security.config.GeoServerKeycloakRoleServiceConfig;
import org.geoserver.security.impl.GeoServerKeycloakRoleService;

/** Configuration panel extension for {@link GeoServerKeycloakRoleService}. */
public class KeycloakRoleServicePanelInfo
        extends RoleServicePanelInfo<GeoServerKeycloakRoleServiceConfig, KeycloakRoleServicePanel> {

    public KeycloakRoleServicePanelInfo() {
        setComponentClass(KeycloakRoleServicePanel.class);
        setServiceClass(GeoServerKeycloakRoleService.class);
        setServiceConfigClass(GeoServerKeycloakRoleServiceConfig.class);
        setPriority(0);
    }
}

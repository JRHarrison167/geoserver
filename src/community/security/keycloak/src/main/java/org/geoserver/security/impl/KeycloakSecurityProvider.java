/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.security.impl;

import java.io.IOException;
import org.geoserver.config.util.XStreamPersister;
import org.geoserver.security.GeoServerRoleService;
import org.geoserver.security.GeoServerSecurityManager;
import org.geoserver.security.GeoServerSecurityProvider;
import org.geoserver.security.config.GeoServerKeycloakRoleServiceConfig;
import org.geoserver.security.config.SecurityNamedServiceConfig;
import org.geoserver.security.validation.SecurityConfigValidator;

/** Security provider for Keycloak security implementations. */
public class KeycloakSecurityProvider extends GeoServerSecurityProvider {

    @Override
    public void configure(XStreamPersister xp) {
        super.configure(xp);
        xp.getXStream().alias("keycloakRoleService", GeoServerKeycloakRoleServiceConfig.class);
    }

    @Override
    public Class<? extends GeoServerRoleService> getRoleServiceClass() {
        return GeoServerKeycloakRoleService.class;
    }

    @Override
    public GeoServerRoleService createRoleService(SecurityNamedServiceConfig config)
            throws IOException {
        return new GeoServerKeycloakRoleService();
    }

    @Override
    public SecurityConfigValidator createConfigurationValidator(
            GeoServerSecurityManager securityManager) {
        return new SecurityConfigValidator(securityManager);
    }
}

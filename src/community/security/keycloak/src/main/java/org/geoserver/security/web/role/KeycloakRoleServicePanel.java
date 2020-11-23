/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.security.web.role;

import org.apache.wicket.model.IModel;
import org.geoserver.security.config.GeoServerKeycloakRoleServiceConfig;

/** Configuration panel for {@link GeoServerKeycloakRoleService}. */
public class KeycloakRoleServicePanel extends RoleServicePanel<GeoServerKeycloakRoleServiceConfig> {

    public KeycloakRoleServicePanel(String id, IModel<GeoServerKeycloakRoleServiceConfig> model) {
        super(id, model);
    }
}

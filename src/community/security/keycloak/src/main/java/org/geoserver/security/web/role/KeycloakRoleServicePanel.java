/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.security.web.role;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.geoserver.security.config.KeycloakRoleServiceConfig;

/** Configuration panel for {@link KeycloakRoleService}. */
public class KeycloakRoleServicePanel extends RoleServicePanel<KeycloakRoleServiceConfig> {

    public KeycloakRoleServicePanel(String id, IModel<KeycloakRoleServiceConfig> model) {
        super(id, model);

        add(new TextField<String>("serverURL").setRequired(true));
        add(new TextField<String>("idOfClient").setRequired(true));
        add(new TextField<String>("clientSecret").setRequired(true));
    }
}

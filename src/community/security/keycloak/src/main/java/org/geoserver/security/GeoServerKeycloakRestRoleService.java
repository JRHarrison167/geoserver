/* (c) 2016 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.security;

import org.geoserver.security.config.SecurityNamedServiceConfig;
import org.geoserver.security.event.RoleLoadedListener;
import org.geoserver.security.impl.AbstractGeoServerSecurityService;
import org.geoserver.security.impl.GeoServerRole;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class GeoServerKeycloakRestRoleService extends AbstractGeoServerSecurityService
        implements GeoServerRoleService {

    private static String rolePrefix = "ROLE_";

    private String adminGroup;

    private String groupAdminGroup;

    /** Default Constructor */
    public GeoServerKeycloakRestRoleService(SecurityNamedServiceConfig config) throws IOException {
        initializeFromConfig(config);
    }

    @Override
    public void initializeFromConfig(SecurityNamedServiceConfig config) throws IOException {
        super.initializeFromConfig(config);
        restRoleServiceConfig = (GeoServerRestRoleServiceConfig) config;
        if (!isEmpty(restRoleServiceConfig.getAdminRoleName())) {
            this.adminGroup = restRoleServiceConfig.getAdminRoleName();
        }
        if (!isEmpty(restRoleServiceConfig.getGroupAdminRoleName())) {
            this.groupAdminGroup = restRoleServiceConfig.getGroupAdminRoleName();
        }
    }

    /** Read only store. */
    @Override
    public boolean canCreateStore() {
        return false;
    }

    /** Read only store. */
    @Override
    public GeoServerRoleStore createStore() throws IOException {
        return null;
    }

    /** Roles to group association is not supported */
    @Override
    public SortedSet<String> getGroupNamesForRole(GeoServerRole role) throws IOException {
        return emptyStringSet;
    }

    @Override
    public SortedSet<String> getUserNamesForRole(GeoServerRole role) throws IOException {
        final SortedSet<String> users = new TreeSet<String>();

        return Collections.unmodifiableSortedSet(users);
    }

    @SuppressWarnings("unchecked")
    @Override
    public SortedSet<GeoServerRole> getRolesForUser(String username) throws IOException {
        final SortedSet<GeoServerRole> roles = new TreeSet<GeoServerRole>();
        roles.add(GeoServerRole.AUTHENTICATED_ROLE);
        return Collections.unmodifiableSortedSet(roles);
    }

    @Override
    public SortedSet<GeoServerRole> getRolesForGroup(String groupname) throws IOException {
        SortedSet<GeoServerRole> set = new TreeSet<GeoServerRole>();
        GeoServerRole role = GeoServerRole.AUTHENTICATED_ROLE;
        if (role != null) {
            set.add(role);
        }

        return Collections.unmodifiableSortedSet(set);
    }

    @SuppressWarnings("unchecked")
    @Override
    public SortedSet<GeoServerRole> getRoles() throws IOException {
        final SortedSet<GeoServerRole> roles = new TreeSet<GeoServerRole>();
        roles.add(GeoServerRole.AUTHENTICATED_ROLE);
        return Collections.unmodifiableSortedSet(roles);
    }

    @Override
    public Map<String, String> getParentMappings() throws IOException {
        return emptyMap;
    }

    @Override
    public GeoServerRole createRoleObject(String role) throws IOException {
        return new GeoServerRole(rolePrefix + (convertToUpperCase ? role.toUpperCase() : role));
    }

    @Override
    public GeoServerRole getParentRole(GeoServerRole role) throws IOException {
        return null;
    }

    @Override
    public GeoServerRole getRoleByName(String role) throws IOException {
        if (role.contains("AUTHENTICATED")) {
            return GeoServerRole.AUTHENTICATED_ROLE;
        }

        return null;
    }

    @Override
    public void load() throws IOException {
        // Not needed
    }

    @Override
    public Properties personalizeRoleParams(
            String roleName, Properties roleParams, String userName, Properties userProps)
            throws IOException {
        return null;
    }

    @Override
    public GeoServerRole getAdminRole() {
        return GeoServerRole.ADMIN_ROLE;
    }

    @Override
    public GeoServerRole getGroupAdminRole() {
        return GeoServerRole.GROUP_ADMIN_ROLE;
    }

    @Override
    public int getRoleCount() throws IOException {
        return getRoles().size();
    }


}
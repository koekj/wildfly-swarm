/**
 * Copyright 2015-2016 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wildfly.swarm.datasources.runtime.drivers;

import javax.inject.Singleton;

import org.jboss.modules.ModuleIdentifier;
import org.wildfly.swarm.config.datasources.DataSource;
import org.wildfly.swarm.config.datasources.JDBCDriver;
import org.wildfly.swarm.datasources.runtime.DriverInfo;

/**
 * Auto-detection for EnterpriseDB.
 *
 * @author Bob McWhirter
 */
@Singleton
public class EnterpriseDBDriverInfo extends DriverInfo {
    public static final String DEFAULT_CONNECTION_URL = "jdbc:edb://localhost:5444/test";

    public static final String DEFAULT_USER_NAME = "enterprisedb";

    public static final String DEFAULT_PASSWORD = "enterprisedb";

    public EnterpriseDBDriverInfo() {
        super("edb", ModuleIdentifier.create("com.edb"), "com.edb.Driver");
    }

    @Override
    protected void configureDriver(JDBCDriver driver) {
        driver.xaDatasourceClass("com.edb.xa.PGXADataSource");
    }

    @Override
    protected void configureDefaultDS(DataSource datasource) {
        datasource.connectionUrl(DEFAULT_CONNECTION_URL);
        datasource.userName(DEFAULT_USER_NAME);
        datasource.password(DEFAULT_PASSWORD);
    }
}

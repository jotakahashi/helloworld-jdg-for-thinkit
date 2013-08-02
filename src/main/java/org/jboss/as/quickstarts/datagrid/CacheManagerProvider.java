package org.jboss.as.quickstarts.datagrid;

import org.infinispan.manager.DefaultCacheManager;

/**
 * @author Red Hat K.K.
 */
public interface CacheManagerProvider {

    public DefaultCacheManager getCacheManager();

}
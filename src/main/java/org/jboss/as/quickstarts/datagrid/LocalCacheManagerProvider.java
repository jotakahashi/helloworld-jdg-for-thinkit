package org.jboss.as.quickstarts.datagrid;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Named;

import org.infinispan.manager.DefaultCacheManager;

/**
 * @author Red Hat K.K.
 */
@Named
@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class LocalCacheManagerProvider implements CacheManagerProvider {

    // ---------------------------------------------------- Instance Variables

    private DefaultCacheManager _cacheManager;

    // ====---------------------------------------------------- Public Methods

    @PostConstruct
    public void createCacheManager() {
        try {
            _cacheManager = new DefaultCacheManager("infinispan-local.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DefaultCacheManager getCacheManager() {
        return _cacheManager;
    }

    @PreDestroy
    public void stopCacheManager() {
        _cacheManager.stop();
    }

}

package org.elasticsearch.plugin.skeleton;

import org.elasticsearch.common.collect.Lists;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.plugins.AbstractPlugin;

import java.util.Collection;

/**
 *
 */
public class SkeletonPlugin extends AbstractPlugin {

    @Inject
    public SkeletonPlugin() {
    }

    @Override
    public String name() {
        return "elasticsearch-skeleton-plugin";
    }

    @Override
    public String description() {
        return "Elasticsearch Skeleton Plugin";
    }

    @Override
    public Collection<Class<? extends Module>> modules() {
        Collection<Class<? extends Module>> modules = Lists.newArrayList();
        modules.add(ExampleRestModule.class);
        return modules;
    }

}
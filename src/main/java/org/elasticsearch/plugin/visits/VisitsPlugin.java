package org.elasticsearch.plugin.visits;

import org.elasticsearch.common.collect.Lists;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.plugins.AbstractPlugin;

import java.util.Collection;

/**
 *
 */
public class VisitsPlugin extends AbstractPlugin {

    @Inject
    public VisitsPlugin() {
    }

    @Override
    public String name() {
        return "visits-plugin";
    }

    @Override
    public String description() {
        return "Elasticsearch Visits Plugin";
    }

    @Override
    public Collection<Class<? extends Module>> modules() {
        Collection<Class<? extends Module>> modules = Lists.newArrayList();
        modules.add(ExampleRestModule.class);
        return modules;
    }

}
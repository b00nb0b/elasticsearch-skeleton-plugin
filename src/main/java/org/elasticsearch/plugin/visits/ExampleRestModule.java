package org.elasticsearch.plugin.visits;



import org.elasticsearch.common.inject.AbstractModule;

public class ExampleRestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(HelloRestHandler.class).asEagerSingleton();
    }
}
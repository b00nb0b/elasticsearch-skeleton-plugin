package org.elasticsearch.plugin.skeleton;



import org.elasticsearch.common.inject.AbstractModule;

public class HelloWorldRestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(HelloRestHandler.class).asEagerSingleton();
    }
}
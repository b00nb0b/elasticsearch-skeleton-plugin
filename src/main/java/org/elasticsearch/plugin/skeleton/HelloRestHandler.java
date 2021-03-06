package org.elasticsearch.plugin.skeleton;


import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.bytes.BytesReference;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestChannel;
import org.elasticsearch.rest.BytesRestResponse;
import org.elasticsearch.rest.RestStatus;

import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.rest.action.search.RestSearchAction;
import org.elasticsearch.rest.action.support.RestStatusToXContentListener;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.rest.RestRequest.Method.GET;

public class HelloRestHandler extends BaseRestHandler {

    @Inject
    public HelloRestHandler(Settings settings, Client client, RestController restController) {
        super(settings, client);
        restController.registerHandler(GET, "/{index}/{type}/_hello", this);
        restController.registerHandler(GET, "/{index}/_hello", this);
        restController.registerHandler(GET, "/_hello", this);
    }

    @Override
    public void handleRequest(final RestRequest request, final RestChannel channel) throws Exception {
        String who = request.param("who");
        String whoSafe = (who!=null) ? who : "world";


        XContentBuilder doc = null;

        doc = jsonBuilder()
                .startObject()
                .field("Hello ", whoSafe)
                .endObject();

        channel.sendResponse(new BytesRestResponse(RestStatus.OK, doc));

    }


}
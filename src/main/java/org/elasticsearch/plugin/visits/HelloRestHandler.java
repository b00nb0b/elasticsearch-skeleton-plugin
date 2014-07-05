package org.elasticsearch.plugin.visits;


import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.rest.*;

import org.elasticsearch.common.inject.Inject;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.rest.RestRequest.Method.GET;

public class HelloRestHandler implements RestHandler {
    @Inject
    public HelloRestHandler(RestController restController) {
        restController.registerHandler(GET, "/_hello", this);
    }

    @Override
    public void handleRequest(final RestRequest request, final RestChannel channel) throws IOException {
        String who = request.param("who");
        String whoSafe = (who!=null) ? who : "world";
//        channel.sendResponse(new StringRestResponse(OK, "Hello, " + whoSafe + "!"));

        XContentBuilder doc = jsonBuilder()
                .startObject()
                .field("Hello, ", whoSafe)
                .endObject();

        channel.sendResponse(new BytesRestResponse(RestStatus.OK, doc));

    }
}
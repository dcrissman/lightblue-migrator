package com.redhat.lightblue.migrator.consistency;

import static com.redhat.lightblue.util.test.AbstractJsonNodeTest.loadJsonNode;
import static org.junit.Assert.assertFalse;

import org.junit.Ignore;

import com.fasterxml.jackson.databind.JsonNode;
import com.redhat.lightblue.client.request.data.DataInsertRequest;
import com.redhat.lightblue.client.response.LightblueResponse;

@Ignore
public class ITCaseMigrationJobTest extends AbstractMigratorController {

    public ITCaseMigrationJobTest() throws Exception {
        super();

        LightblueResponse response = getLightblueClient().data(new DataInsertRequest("customer", "1.0.0"));
        assertFalse(response.hasError());
    }

    @Override
    protected JsonNode[] getMetadataJsonNodes() throws Exception {
        return new JsonNode[]{
                loadJsonNode("/migrationJob.json"),
                loadJsonNode("/migrationConfiguration.json"),
                loadJsonNode("/test/metadata/source-customer.json"),
                loadJsonNode("/test/metadata/destination-customer.json")
        };
    }

}

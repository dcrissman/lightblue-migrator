package com.redhat.lightblue.migrator.consistency;

import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.BeforeClass;

import com.redhat.lightblue.client.request.AbstractLightblueDataRequest.Operation;
import com.redhat.lightblue.client.request.data.SimpleDataRequest;
import com.redhat.lightblue.client.response.LightblueResponse;
import com.redhat.lightblue.test.utils.AbstractCRUDControllerWithRest;

public abstract class AbstractMigratorController extends AbstractCRUDControllerWithRest {

    @BeforeClass
    public static void prepareMetadataDatasources() {
        System.setProperty("mongo.datasource", "mongodata");
    }

    public AbstractMigratorController() throws Exception {
        super();
    }

    protected LightblueResponse loadData(String entityName, String entityVersion, String resourcePath) throws IOException {
        SimpleDataRequest request = new SimpleDataRequest(entityName, entityVersion, Operation.INSERT, loadResource(resourcePath, false));
        LightblueResponse response = getLightblueClient().data(request);
        assertFalse(response.getText(), response.hasError());

        return response;
    }

}

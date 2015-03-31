package com.redhat.lightblue.migrator.consistency;

import static com.redhat.lightblue.util.test.AbstractJsonNodeTest.loadJsonNode;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

public class ITCaseConsistencyCheckerTest extends AbstractMigratorController {

    public ITCaseConsistencyCheckerTest() throws Exception {
        super();

        loadData("migrationConfiguration", "0.1.0-SNAPSHOT", "./test/data/load-migration-configurations.json");
        loadData("migrationJob", "0.1.4-SNAPSHOT", "./test/data/load-migration-jobs.json");
    }

    @Override
    protected JsonNode[] getMetadataJsonNodes() throws Exception {
        return new JsonNode[]{
                loadJsonNode("./migrationJob.json"),
                loadJsonNode("./migrationConfiguration.json"),
        };
    }

    @Test
    public void test() {
        assertTrue(false);
    }

}

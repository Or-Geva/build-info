/*
 * Copyright (C) 2011 JFrog Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jfrog.build.api;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Tests the behavior of the module class
 *
 * @author Noam Y. Tenne
 */
@Test
public class ModuleTest {

    /**
     * Validates the module values after initializing the default constructor
     */
    public void testEmptyConstructor() {
        Module module = new Module();

        assertNull(module.getType(), "Module type should have not been initialized.");
        assertNull(module.getId(), "Module ID should have not been initialized.");
        assertNull(module.getRepository(), "Module repo should have not been initialized.");
        assertNull(module.getSha1(), "Module sha1 should have not been initialized.");
        assertNull(module.getMd5(), "Module md5 should have not been initialized.");
        assertNull(module.getArtifacts(), "Module artifacts should have not been initialized.");
        assertNull(module.getDependencies(), "Module dependencies should have not been initialized.");
    }

    /**
     * Validates the module values after using the module setters
     */
    public void testSetters() {
        String id = "moo";
        String repo = "test-repo";
        String type = "build";
        String sha1 = "1234";
        String md5 = "5678";
        List<Artifact> artifacts = new ArrayList<>();
        List<Dependency> dependencies = new ArrayList<>();

        Module module = new Module();
        module.setId(id);
        module.setRepository(repo);
        module.setType(type);
        module.setSha1(sha1);
        module.setMd5(md5);
        module.setArtifacts(artifacts);
        module.setDependencies(dependencies);

        assertEquals(module.getId(), id, "Unexpected module ID.");
        assertEquals(module.getRepository(), repo, "Unexpected module repository.");
        assertEquals(module.getType(), type, "Unexpected module type.");
        assertEquals(module.getSha1(), sha1, "Unexpected module sha1.");
        assertEquals(module.getMd5(), md5, "Unexpected module md5.");
        assertEquals(module.getArtifacts(), artifacts, "Unexpected module artifacts.");
        assertTrue(module.getArtifacts().isEmpty(), "Module artifact list should not have been populated.");
        assertEquals(module.getDependencies(), dependencies, "Unexpected module dependencies.");
        assertTrue(module.getDependencies().isEmpty(), "Module dependencies list should not have been populated.");
    }
}
/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package root;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static void test1() {
        Level1 level1 = new Level1();
        {
            level1.setProperty1("level1_property1");
        }
        Level2 level2 = new Level2();
        level2.setProperty1(level1);
        level2.setProperty2("level2_property2");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(level2);
        } catch (Exception e) {
            LOGGER.error("objectMapper.writeValueAsString failed.", e);
            return;
        }
        System.out.println(json);
    }

    private static void test2() {
        String json =
            "{\n" +
            "    \"property1\" :\n" +
            "    {\n" +
            "        \"property1\" : \"level1_property1\"\n" +
            "    },\n" +
            "    \"property2\" : \"level2_property2\"\n" +
            "}\n";
        ObjectMapper objectMapper = new ObjectMapper();
        Level2 level2 = null;
        try {
            level2 = objectMapper.readValue(json, Level2.class);
        } catch (Exception e) {
            LOGGER.error("objectMapper.readValue failed.", e);
            return;
        }
        System.out.println(level2);
    }

    private static void test3() {
        String json =
            "{\n" +
            "    \"property1\" :\n" +
            "    {\n" +
            "        \"property1\" : \"level1_property1\"\n" +
            "    },\n" +
            "    \"property2\" : \"level2_property2\"\n" +
            "}\n";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(json);
        } catch (Exception e) {
            LOGGER.error("objectMapper.readTree failed.", e);
            return;
        }
        System.out.println(jsonNode.get("property1"));
    }

    private static void test4() {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode arrayNode = objectMapper.createArrayNode();
        {
            ObjectNode level1 = objectMapper.createObjectNode();
            level1.put("property1", "level1_property1");
            ObjectNode level2 = objectMapper.createObjectNode();
            level2.put("property1", level1);
            level2.put("property2", "level2_property2");
            arrayNode.add(level2);
        }
        {
            ObjectNode level1 = objectMapper.createObjectNode();
            level1.put("property1", "level1_property1");
            ObjectNode level2 = objectMapper.createObjectNode();
            level2.put("property1", level1);
            level2.put("property2", "level2_property2");
            arrayNode.add(level2);
        }
        String json = null;
        try {
            json = objectMapper.writeValueAsString(arrayNode);
        } catch (Exception e) {
            LOGGER.error("objectMapper.writeValueAsString failed.", e);
            return;
        }
        System.out.println(json);
        List<Level2> list = null;
        try {
            list = objectMapper.readValue(json, new TypeReference<List<Level2>>() {});
        } catch (Exception e) {
            LOGGER.error("objectMapper.readValue failed.", e);
            return;
        }
        System.out.println(list);
    }

    public static void main(String[] stringArray) {
        test1();
        test2();
        test3();
        test4();
    }
}

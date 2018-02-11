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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Test {
    TERMINATOR("terminator") {
        public boolean process(Map<String, String> context, String string, Object object) {
            return true;
        }

        public Object handle(String string) {
            return string;
        }
    },

    NON_TERMINATOR("non_terminator") {
        public boolean process(Map<String, String> context, String string, Object object) {
            List<String> list1 = Test.doDirtyWork1(string);
            if (list1 == null || list1.size() < 1) {
                return false;
            }
            List<Tuple> list2 = (List<Tuple>)object;
            if (list2 == null || list2.size() < 1) {
                return false;
            }
            if (list1.size() != list2.size()) {
                return false;
            }
            System.out.println("list1:" + list1);
            System.out.println("list2:" + list2);
            for (int i = 0; i < list1.size(); ++ i) {
                String a = list1.get(i);
                Test b = (Test)(list2.get(i).getProperty1());
                Object c = list2.get(i).getProperty2();
                if (b.process(context, a, c)) {
                    return false;
                }
            }
            return true;
        }

        public Object handle(String string) {
            return Test.doDirtyWork2(string);
        }
    };

    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    private String value;

    private Test(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public abstract boolean process(Map<String, String> context, String string, Object object);

    public abstract Object handle(String string);

    public static Test get(String string) {
        Test[] array = values();
        for (int i = 0; i < array.length; ++ i) {
            if (array[i].name().equals(string)) {
                return array[i];
            }
        }
        return null;
    }

    private static List<String> doDirtyWork1(String string) {
        List<String> result = new ArrayList<String>();
        if (string == null || string.length() < 1) {
            return result;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(string);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
        if (jsonNode == null) {
            return result;
        }
        if (! jsonNode.isArray()) {
            return result;
        }
        for (JsonNode item : jsonNode) {
            if (item.isContainerNode()) {
                result.add(item.toString());
            } else if (item.isValueNode()) {
                result.add(item.asText());
            } else {
                System.out.println("invalid node type." + item.getNodeType());
            }
        }
        return result;
    }

    private static List<Tuple> doDirtyWork2(String string) {
        List<Tuple> result = new ArrayList<Tuple>();
        if (string == null || string.length() < 1) {
            return result;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(string);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
        if (jsonNode == null) {
            return result;
        }
        if (! jsonNode.isArray()) {
            return result;
        }
        for (JsonNode item : jsonNode) {
            JsonNode property1 = item.get("property1");
            if (property1 == null) {
                continue;
            }
            JsonNode property2 = item.get("property2");
            if (property2 == null) {
                continue;
            }
            Tuple tuple = new Tuple();
            Test test = get(property1.asText());
            tuple.setProperty1(test);
            if (property2.isContainerNode()) {
                tuple.setProperty2(test.handle(property2.toString()));
            } else if (property2.isValueNode()) {
                tuple.setProperty2(test.handle(property2.asText()));
            } else {
                System.out.println("invalid node type." + property1.getNodeType());
            }
            result.add(tuple);
        }
        return result;
    }

    public static void main(String[] stringArray) {
        {
            String json1 =
               "[\n" +
               "    \"a\",\n" +
               "    \"b\"\n" +
               "]\n";
            String json2 =
               "[\n" +
               "    {\n" +
               "        \"property1\" : \"TERMINATOR\",\n" +
               "        \"property2\" : \"dummy1\"\n" +
               "    },\n" +
               "    {\n" +
               "        \"property1\" : \"TERMINATOR\",\n" +
               "        \"property2\" : \"dummy2\"\n" +
               "    }\n" +
               "]\n";
            System.out.println(json1);
            System.out.println(json2);
            Map<String, String> context = new HashMap<String, String>();
            Test.NON_TERMINATOR.process(context, json1, Test.NON_TERMINATOR.handle(json2));
        }
        {
            String json1 =
                "[\n" +
                "    [\n" +
                "        \"a\",\n" +
                "        \"b\"\n" +
                "    ],\n" +
                "    [\n" +
                "        \"c\",\n" +
                "        \"d\"\n" +
                "    ]\n" +
                "]\n";
            String json2 =
                "[\n" +
                "    {\n" +
                "        \"property1\" : \"NON_TERMINATOR\",\n" +
                "        \"property2\" :\n" +
                "        [\n" +
                "            {\n" +
                "                \"property1\" : \"TERMINATOR\",\n" +
                "                \"property2\" : \"dummy1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"property1\" : \"TERMINATOR\",\n" +
                "                \"property2\" : \"dummy2\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"property1\" : \"NON_TERMINATOR\",\n" +
                "        \"property2\" :\n" +
                "        [\n" +
                "            {\n" +
                "                \"property1\" : \"TERMINATOR\",\n" +
                "                \"property2\" : \"dummy3\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"property1\" : \"TERMINATOR\",\n" +
                "                \"property2\" : \"dummy4\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]\n";
            System.out.println(json1);
            System.out.println(json2);
            Map<String, String> context = new HashMap<String, String>();
            Test.NON_TERMINATOR.process(context, json1, Test.NON_TERMINATOR.handle(json2));
        }
    }
}

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Autowired
    private Entity entity;

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Entity entity = (Entity)applicationContext.getBean("entity");
        LOGGER.info("" + entity);
    }

    public static void main(String[] stringArray) {
        Main main = new Main();
        main.test();
    }
}

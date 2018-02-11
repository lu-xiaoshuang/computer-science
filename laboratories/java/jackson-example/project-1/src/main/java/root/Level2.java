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

public class Level2 {
    private Level1 property1;

    private String property2;

    public Level1 getProperty1() {
        return property1;
    }

    public void setProperty1(Level1 property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Level2");
        stringBuilder.append("(");
        stringBuilder.append("property1 = ");
        stringBuilder.append(this.property1);
        stringBuilder.append(", ");
        stringBuilder.append("property2 = ");
        stringBuilder.append(this.property2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

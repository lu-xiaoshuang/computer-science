/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root;

public class Entity {
    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Entity");
        stringBuilder.append("{");
        stringBuilder.append("value=");
        stringBuilder.append("\'");
        stringBuilder.append(value);
        stringBuilder.append("\'");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

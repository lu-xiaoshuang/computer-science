/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.expression;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public List<TreeNode> children = new ArrayList<TreeNode>();

    /**
     * possible values:
     */
    public String operator;

    public String key;

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}

package com.nzt.gdx.test.tester.selector;

import java.util.ArrayList;

//can be a group or a screen
//displayed in StSelector
public class CaseST {

    public CaseST parent;
    public String name;
    public Class classTest;

    public boolean isGroup;
    public ArrayList<CaseST> childs;

    public CaseST(CaseST parent, String name, Class classTest) {
        this.parent = parent;
        this.name = name;
        this.classTest = classTest;
    }

    public CaseST(CaseST parent, String groupName) {
        this.parent = parent;
        this.isGroup = true;
        this.name = groupName;
        this.childs = new ArrayList<>();
    }

    public String getDisplayedName() {
        if (name.toLowerCase().startsWith("st")) {
            return name.substring(2);
        }
        return name;
    }
}

package com.nzt.gdx.test.tester.selector;

import java.util.ArrayList;

//can be a group or a screen
public class CaseTestScreen {

    public String name;
    public Class classTest;

    public boolean isGroup;
    public ArrayList<CaseTestScreen> childs;

    public CaseTestScreen(String name, Class classTest) {
        this.name = name;
        this.classTest = classTest;
    }

    public CaseTestScreen(String groupName) {
        this.isGroup = true;
        this.name = groupName;
        this.childs = new ArrayList<>();
    }
}

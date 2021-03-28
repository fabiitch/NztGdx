package com.nzt.gdx.test.tester.selector;

import com.nzt.gdx.test.tester.TestScreen;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Set;

public class TestScreenScanner {

    public static ArrayList<CaseTestScreen> scanTestScreens() {
        Reflections reflections = new Reflections("com.nzt.gdx.test");
        Set<Class<?>> allTestScreenClasses = reflections.getTypesAnnotatedWith(TestScreen.class);

        ArrayList<CaseTestScreen> treeCaseScreen = new ArrayList<>();

        for (Class<?> classTest : allTestScreenClasses) {
            TestScreen annotationTest = classTest.getAnnotation(TestScreen.class);
            String[] groupName = annotationTest.groupName();
            if (groupName.length == 0) {
                treeCaseScreen.add(getForClass(classTest, annotationTest));
            } else {
                ArrayList<CaseTestScreen> groupCase = findGroupInTree(annotationTest, treeCaseScreen);
                groupCase.add(getForClass(classTest, annotationTest));
            }
        }
        return treeCaseScreen;
    }

    public static ArrayList<CaseTestScreen> findGroupInTree(TestScreen annotationTest, ArrayList<CaseTestScreen> treeCaseScreen) {
        for (String groupName : annotationTest.groupName()) {
            for (CaseTestScreen caseT : treeCaseScreen) {
                if (caseT.isGroup && caseT.name.equals(groupName)) {
                    return caseT.childs;
                }
            }
            CaseTestScreen groupCreated = new CaseTestScreen(groupName);
            treeCaseScreen.add(groupCreated);
            treeCaseScreen = groupCreated.childs;
        }
        return treeCaseScreen;
    }


    public static CaseTestScreen getForClass(Class testScreen, TestScreen annotationTest) {
        String name = annotationTest.name();
        if (name.equals(TestScreen.DEFAULT_NAME))
            name = testScreen.getSimpleName();
        return new CaseTestScreen(name, testScreen);
    }
}

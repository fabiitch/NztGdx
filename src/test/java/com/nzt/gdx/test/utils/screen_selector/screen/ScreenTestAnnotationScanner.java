package com.nzt.gdx.test.utils.screen_selector.screen;

import com.nzt.gdx.test.utils.screen_selector.TestScreen;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.Set;

public class ScreenTestAnnotationScanner {

    /**
     * Scan all class with @TestScreen annotation
     */
    public static synchronized CaseST scanTestScreens(String packagePath) {
        Reflections reflections = new Reflections(packagePath);
        Set<Class<?>> allTestScreenClasses = reflections.getTypesAnnotatedWith(TestScreen.class);

        CaseST rootCaseTest = new CaseST(null, "root");
        rootCaseTest.parent = rootCaseTest;

        for (Class<?> classTest : allTestScreenClasses) {
            if (Modifier.isAbstract(classTest.getModifiers()))
                continue;
            TestScreen annotationTest = classTest.getAnnotation(TestScreen.class);
            String[] groupName = annotationTest.group().split(TestScreen.SEPARATOR);
            if (groupName.length == 0 || annotationTest.group().equals("")) { // 1er groupe
                rootCaseTest.childs.add(getForClass(rootCaseTest, classTest, annotationTest));
            } else {
                CaseST groupCase = findParent(annotationTest, rootCaseTest);
                groupCase.childs.add(getForClass(groupCase, classTest, annotationTest));
            }
        }
        return rootCaseTest;
    }

    /**
     * cherche les group de la classes, si il existe pas ils sont crée
     */
    private static CaseST findParent(TestScreen annotationTest, CaseST root) {
        for (String groupName : annotationTest.group().split(TestScreen.SEPARATOR)) {
            CaseST group = searchInChildOrCreate(root, groupName);
            root = group;
        }
        return root;
    }

    private static CaseST searchInChildOrCreate(CaseST root, String groupName) {
        for (CaseST caseT : root.childs) {
            if (caseT.isGroup && caseT.name.equals(groupName)) {
                return caseT;
            }
        }
        CaseST groupCreated = new CaseST(root, groupName);
        root.childs.add(groupCreated);
        return groupCreated;
    }

    private static CaseST getForClass(CaseST parent, Class testScreen, TestScreen annotationTest) {
        String name = testScreen.getSimpleName();
        return new CaseST(parent, name, testScreen);
    }

    public static String getNameOfGroupAndParent(CaseST caseST) {
        String display = caseST.name;
        while (true) {
            if (caseST.parent == caseST)
                break;
            caseST = caseST.parent;
            display = caseST.name + " | " + display;

        }
        return display;

    }
}

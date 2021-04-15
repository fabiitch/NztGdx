package com.nzt.gdx.test.trials.tester.selector;

import org.reflections.Reflections;

import java.util.Set;

public class STScanner {

	/**
	 * Scan all class with @TestScreen annotation
	 *
	 * @return
	 */
	public static synchronized CaseST scanTestScreens() {
		Reflections reflections = new Reflections("com.nzt.gdx.test");
		Set<Class<?>> allTestScreenClasses = reflections.getTypesAnnotatedWith(TestScreen.class);

		CaseST rootCaseTest = new CaseST(null, "root");
		rootCaseTest.parent = rootCaseTest;

		for (Class<?> classTest : allTestScreenClasses) {
			TestScreen annotationTest = classTest.getAnnotation(TestScreen.class);
			String[] groupName = annotationTest.group().split(TestScreen.SEPARATOR);
			if (groupName.length == 0) { // 1er groupe
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
		String name = annotationTest.group();
		name = testScreen.getSimpleName();
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

package com.nzt.gdx.test.trials.tester.archi.utils;


//TODO a reprendre un jour
//viré les lib de lwlgj qui empeche lvlwj3 de fonctionner
public class Lwjgl3TestConfiguration {

    private static final String toRemove = "gdx-backend-lwjgl/"
            + "lwjgl_util/"
            + "lwjgl/"
            + "lwjgl-platform/"
            + "jinput/"
            + "jutils/"
            + "jinput-platform";

    public static boolean isOne(String path) {
        final String[] split = toRemove.split("/");
        for (String s : split) {
            if (path.contains("/" + s + "/"))
                return true;
        }
        return false;
    }

    public static void removeConfigLwjgl() {
//        try {
//            URLClassLoader urlClassLoader = (URLClassLoader)
//                    ClassLoader.getSystemClassLoader();
//            Class<?> urlClass = URLClassLoader.class;
//            Field ucpField = urlClass.getDeclaredField("ucp");
//            ucpField.setAccessible(true);
//            URLClassPath ucp = (URLClassPath) ucpField.get(urlClassLoader);
//
//            Class<?> ucpClass = URLClassPath.class;
//            Field urlsField = ucpClass.getDeclaredField("path");
//            urlsField.setAccessible(true);
//
//            ArrayList<URL> urls = (ArrayList<URL>) urlsField.get(ucp);
//            ArrayList<URL> urlsToRemove = new ArrayList<>();
//            System.out.println("aaa" + urls.size());
//            for (URL url : urls) {
//                if (isOne(url.getFile()))
//                    urlsToRemove.add(url);
//            }
//            for (URL url : urlsToRemove) {
//                urls.remove(url);
//            }
//            System.out.println("bb" + urls.size());
//        } catch (Exception e) {
//
//        }
    }
}

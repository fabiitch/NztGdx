package com.nzt.gdx.test.java_test;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * But de voir comment se comporte la redefinition
 * d'un attribut sur une classe enfant
 */
public class JavaT_AttributeRedefine {
    @Test
    public void testRedefine() {
        CameraContainer container = new CameraContainer();
        Assertions.assertTrue(container.camera instanceof Camera);
        Assertions.assertTrue(container.camera instanceof PerspectiveCamera);
        Assertions.assertTrue(container.orthoCam instanceof Camera);
        Assertions.assertTrue(container.orthoCam instanceof OrthographicCamera);
        Assertions.assertEquals(2, container.getClass().getDeclaredFields().length);


        CameraContainerOrtho containerOrtho = new CameraContainerOrtho();
        Assertions.assertTrue(containerOrtho.camera instanceof FakeCamera);
        Assertions.assertTrue(containerOrtho.orthoCam instanceof FakeOrthoCamera);
        Assertions.assertEquals(2, containerOrtho.getClass().getDeclaredFields().length);
    }

    private static class CameraContainer {
        public Camera camera;
        public OrthographicCamera orthoCam;

        public CameraContainer() {
            this.camera = new PerspectiveCamera();
            this.orthoCam = new OrthographicCamera();
        }
    }

    private static class CameraContainerOrtho extends CameraContainer {
        public FakeCamera camera;
        public FakeOrthoCamera orthoCam;

        public CameraContainerOrtho() {
            this.camera = new FakeCamera();
            this.orthoCam = new FakeOrthoCamera();
        }
    }

    private static class FakeCamera extends Camera {
        public String fakeCam = "FakeCam";

        @Override
        public void update() {

        }

        @Override
        public void update(boolean updateFrustum) {

        }
    }

    private static class FakeOrthoCamera extends OrthographicCamera {
        public String fakeOrtho = "fakeOrtho";
    }
}

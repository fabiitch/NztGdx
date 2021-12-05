- Pools utilisation ... la méthode free n'est pas appelé

- allocate memory test, doivent tous passé sans up

GL error vient de com.badlogic.gdx.tests.utils.GdxTestWrapper

	if(logGLErrors){
			Gdx.app.log("GLProfiler", "profiler enabled");
			GLProfiler profiler = new GLProfiler(Gdx.graphics);
			profiler.setListener(new GLErrorListener() {
				@Override
				public void onError (int error) {
					Gdx.app.error("GLProfiler", "error " + error);
				}
			});
			profiler.enable();
		}


- gdx-lwjgl3-angle a faite  
  https://github.com/libgdx/libgdx/pull/6672


icone NZT !

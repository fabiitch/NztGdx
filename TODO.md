- Pools utilisation ...  la méthode free n'est pas appelé


- sous projet pour b2D

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

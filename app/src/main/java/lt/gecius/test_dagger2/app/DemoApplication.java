package lt.gecius.test_dagger2.app;

import android.app.Application;


public class DemoApplication extends Application {
	private ApplicationComponent component;

	@Override
	public void onCreate() {
		super.onCreate();
		component = DaggerApplicationComponent.builder()
				.applicationModule(new ApplicationModule(this))
				.build();
	}

	public ApplicationComponent getComponent() {
		return component;
	}
}

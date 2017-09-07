package lt.gecius.test_dagger2.app;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;

@Singleton  // Constraints this component to one-per-application or unscoped bindings.
@Component (modules = {ApplicationModule.class})
public interface ApplicationComponent {
	void inject(DemoApplication app);

	SharedPreferences getSharedPreferences();
}

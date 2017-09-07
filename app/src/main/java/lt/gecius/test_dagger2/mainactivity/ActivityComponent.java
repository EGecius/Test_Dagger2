package lt.gecius.test_dagger2.mainactivity;

import android.app.Activity;

import dagger.Component;
import lt.gecius.test_dagger2.app.ApplicationComponent;

/**
 * Activity-specific Dagger 2 component, similar to ObjectGraph in Dagger 1
 */
@Component (modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

	Activity getActivity();

	void inject(MainActivity activity);
}

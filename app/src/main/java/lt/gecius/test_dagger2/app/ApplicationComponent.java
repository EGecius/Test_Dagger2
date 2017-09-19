package lt.gecius.test_dagger2.app;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import lt.gecius.test_dagger2.mainactivity.ActivityComponent;
import lt.gecius.test_dagger2.mainactivity.ActivityModule;

@Singleton  // Constraints this component to one-per-application or unscoped bindings.
@Component (modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(DemoApplication app);

	SharedPreferences getSharedPreferences();

    ActivityComponent plus(ActivityModule activityModule);
}

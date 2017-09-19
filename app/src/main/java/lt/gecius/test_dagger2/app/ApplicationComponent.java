package lt.gecius.test_dagger2.app;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import lt.gecius.test_dagger2.mainactivity.MainActivity;

@Singleton  // Constraints this component to one-per-application or unscoped bindings.
@Component (modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(DemoApplication app);

    void inject(MainActivity mainActivity);

	SharedPreferences getSharedPreferences();
}

package lt.gecius.test_dagger2.di;

import android.content.SharedPreferences;

import dagger.Component;
import lt.gecius.test_dagger2.app.DemoApplication;
import lt.gecius.test_dagger2.services.MyIntentService;

//@Singleton  // Constraints this component to one-per-application or unscoped bindings.
@Component (modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(DemoApplication app);

    void inject(MyIntentService service);

	SharedPreferences getSharedPreferences();

    ActivityComponent plus(ActivityModule activityModule);
}

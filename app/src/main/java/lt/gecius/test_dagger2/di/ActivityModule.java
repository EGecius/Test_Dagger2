package lt.gecius.test_dagger2.di;

import android.app.Activity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import lt.gecius.test_dagger2.app.MyDependency;
import lt.gecius.test_dagger2.app.Message;

@Module
//@ActivityScope annotating whole module instead of individual method does not work
public class ActivityModule {

    public static final String ACTIVITY_MSG = "ACTIVITY_MSG";
    private final Activity activity;

    public ActivityModule(final Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    // adding this custom @ActivityScope means that same instance will be provided when asked
    // multiple times to be injected from same Component
    @ActivityScope
    @Named(ACTIVITY_MSG)
    Message providesString(MyDependency myDependency) {
        return new Message("Injected string: ACTIVITY_MSG", myDependency);
    }
}

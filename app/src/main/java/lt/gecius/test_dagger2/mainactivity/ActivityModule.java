package lt.gecius.test_dagger2.mainactivity;

import android.app.Activity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    public static final String ACTIVITY_STRING = "ACTIVITY_STRING";
    private final Activity activity;

    ActivityModule(final Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @Named(ACTIVITY_STRING)
    String providesString() {
        return "Injected string: ACTIVITY_STRING";
    }
}

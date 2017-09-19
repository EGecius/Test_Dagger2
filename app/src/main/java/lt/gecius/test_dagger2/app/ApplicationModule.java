package lt.gecius.test_dagger2.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    public static final String APP_STRING = "app string";

    private Application application;

	ApplicationModule(Application application) {
		this.application = application;
	}

	@Provides
	@Singleton
	SharedPreferences provideSharedPrefs() {
		return PreferenceManager.getDefaultSharedPreferences(application);
	}

	@Provides
	@Singleton
    @Named(APP_STRING)
	String providesString() {
		return "Injected string: APP_STRING";
	}
}

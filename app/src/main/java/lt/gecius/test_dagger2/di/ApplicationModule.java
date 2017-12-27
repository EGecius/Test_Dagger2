package lt.gecius.test_dagger2.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import lt.gecius.test_dagger2.app.Message;
import lt.gecius.test_dagger2.app.MyDependency;
import lt.gecius.test_dagger2.app.ProvidesAnnotatedDependency;

@Module
public class ApplicationModule {

    public static final String APP_MSG = "APP_MSG";

    private Application application;

	public ApplicationModule(Application application) {
		this.application = application;
	}

	@Provides
	@Singleton
	SharedPreferences provideSharedPrefs() {
		return PreferenceManager.getDefaultSharedPreferences(application);
	}

	@Provides
	@Singleton
    @Named(APP_MSG)
    Message providesString(MyDependency myDependency) {
		return new Message("Injected string: APP_MSG", myDependency);
	}

    @Provides
    ProvidesAnnotatedDependency provideProvidesAnnotatedDependency() {
        return new ProvidesAnnotatedDependency();
    }

}

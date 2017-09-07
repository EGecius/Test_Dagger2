package lt.gecius.test_dagger2;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class ApplicationModule {

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
	String providesString() {
		return "Injected string";
	}
}

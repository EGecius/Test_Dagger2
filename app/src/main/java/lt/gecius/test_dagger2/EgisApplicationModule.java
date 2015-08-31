package lt.gecius.test_dagger2;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class EgisApplicationModule {
	private Application mApp;

	public EgisApplicationModule(Application app) {
		mApp = app;
	}

	@Provides
	@Singleton
	SharedPreferences provideSharedPrefs() {
		return PreferenceManager.getDefaultSharedPreferences(mApp);
	}

	@Provides
	@Singleton
	String providesString() {
		return "EgisTest";
	}
}

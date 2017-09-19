package lt.gecius.test_dagger2.mainactivity;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

	private final Activity activity;

	ActivityModule(final Activity activity) {
		this.activity = activity;
	}

	@Provides Activity provideActivity() {
		return activity;
	}
}

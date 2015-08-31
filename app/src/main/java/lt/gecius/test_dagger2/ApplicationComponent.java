package lt.gecius.test_dagger2;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {EgisApplicationModule.class})
public interface ApplicationComponent {
	void inject(DemoApplication app);
	void inject(MainActivity activity);
}

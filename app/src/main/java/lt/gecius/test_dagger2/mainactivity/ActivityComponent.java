package lt.gecius.test_dagger2.mainactivity;

import dagger.Subcomponent;

@Subcomponent (modules = ActivityModule.class)
@ActivityScope
public interface ActivityComponent {

    void inject(MainActivity activity);
}

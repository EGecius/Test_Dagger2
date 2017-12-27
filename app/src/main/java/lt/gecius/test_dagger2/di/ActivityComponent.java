package lt.gecius.test_dagger2.di;

import dagger.Subcomponent;
import lt.gecius.test_dagger2.app.MainActivity;

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
}

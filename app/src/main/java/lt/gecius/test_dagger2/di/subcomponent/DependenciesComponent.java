package lt.gecius.test_dagger2.di.subcomponent;

import dagger.Component;
import lt.gecius.test_dagger2.app.DetailActivity;
import lt.gecius.test_dagger2.di.ApplicationComponent;

@Component(modules = DependenciesModule.class, dependencies = ApplicationComponent.class)
public interface DependenciesComponent {

    void inject(DetailActivity detailActivity);
}

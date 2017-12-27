package lt.gecius.test_dagger2.di.subcomponent;

import dagger.Component;
import lt.gecius.test_dagger2.app.DetailActivity;

@Component (modules = MySubcomponentModule.class)
public interface MySubcomponent {

    void inject (DetailActivity detailActivity);
}

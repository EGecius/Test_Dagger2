package lt.gecius.test_dagger2.di.subcomponent;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class DependenciesModule extends DependenciesModuleParent {

    public static final String TAG_1 = "DependenciesModule";
    public static final String TAG_2 = "DependenciesModule_2";

    @Provides
    @Named(TAG_2)
    String provideStringTag2() {
        return "from DependenciesModule - TAG_2";
    }

}

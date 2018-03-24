package lt.gecius.test_dagger2.di.subcomponent;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
class DependenciesModuleParent {

    @Provides
    @Named(DependenciesModule.TAG_1)
    String provideStringTag1() {
        return "from DependenciesModuleParent - TAG_1";
    }
}

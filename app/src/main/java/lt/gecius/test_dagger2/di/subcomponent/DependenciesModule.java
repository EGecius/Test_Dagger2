package lt.gecius.test_dagger2.di.subcomponent;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class DependenciesModule {

    public static final String TAG = "DependenciesModule";

    @Provides
    @Named(TAG)
    String provideString() {
        return "from DependenciesModule";
    }

}

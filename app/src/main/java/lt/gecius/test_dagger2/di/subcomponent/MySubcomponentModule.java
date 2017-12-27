package lt.gecius.test_dagger2.di.subcomponent;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MySubcomponentModule {

    public static final String TAG = "MySubcomponentModule";

    @Provides
    @Named(TAG)
    String provideString() {
        return "from MySubcomponentModule";
    }

}

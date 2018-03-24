package lt.gecius.test_dagger2.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import lt.gecius.test_dagger2.R;
import lt.gecius.test_dagger2.di.ApplicationComponent;
import lt.gecius.test_dagger2.di.subcomponent.DaggerDependenciesComponent;
import lt.gecius.test_dagger2.di.subcomponent.DependenciesModule;

public class DetailActivity extends AppCompatActivity {

    @Inject
    @Named(DependenciesModule.TAG_1)
    String stringFromMySubcomponentModule;

    @Inject
    @Named(DependenciesModule.TAG_2)
    String stringFromMySubcomponentModule2;

    @Inject
    SharedPreferences mSharedPreferences;
    /* You can also request Provider for same dependency, without declaring another Provides
    method for it*/
    @Inject
    Provider<SharedPreferences> mSharedPreferencesProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        injectDependencies();
    }

    private void injectDependencies() {
        ApplicationComponent appComponent = ((DemoApplication) getApplication()).getComponent();
        DaggerDependenciesComponent.builder()
                .applicationComponent(appComponent)
                .build().inject(this);

        printDependencies();
    }

    private void printDependencies() {

        Log.d("Eg:DetailActivity:48", "printDependencies stringFromMySubcomponentModule " +
                stringFromMySubcomponentModule);
        Log.d("Eg:DetailActivity:53", "printDependencies stringFromMySubcomponentModule2 " +
                stringFromMySubcomponentModule2);


//        Log.i("Eg:DetailActivity:41", "injectDependencies mSharedPreferences " + mSharedPreferences);
//        SharedPreferences sharedPreferencesFromProvider = mSharedPreferencesProvider.get();
//        Log.i("Eg:DetailActivity:46", "injectDependencies sharedPreferencesFromProvider " + sharedPreferencesFromProvider);
    }
}

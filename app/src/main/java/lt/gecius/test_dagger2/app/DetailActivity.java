package lt.gecius.test_dagger2.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

import lt.gecius.test_dagger2.R;
import lt.gecius.test_dagger2.di.ApplicationComponent;
import lt.gecius.test_dagger2.di.subcomponent.DaggerDependenciesComponent;
import lt.gecius.test_dagger2.di.subcomponent.DependenciesModule;

public class DetailActivity extends AppCompatActivity {

    @Inject
    @Named(DependenciesModule.TAG)
    String stringFromMySubcomponentModule;

    @Inject
    SharedPreferences mSharedPreferences;

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

        Log.i("Eg:DetailActivity:29", "injectDependencies stringFromMySubcomponentModule " + stringFromMySubcomponentModule);
        Log.i("Eg:DetailActivity:39", "injectDependencies mSharedPreferences " + mSharedPreferences);
    }
}

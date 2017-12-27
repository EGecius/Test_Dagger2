package lt.gecius.test_dagger2.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Named;

import lt.gecius.test_dagger2.R;
import lt.gecius.test_dagger2.di.subcomponent.DaggerMySubcomponent;
import lt.gecius.test_dagger2.di.subcomponent.MySubcomponentModule;

public class DetailActivity extends AppCompatActivity {

    @Inject
    @Named(MySubcomponentModule.TAG)
    String stringFromMySubcomponentModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        injectDependencies();
    }

    private void injectDependencies() {
        DaggerMySubcomponent.builder().build().inject(this);
    }
}

package lt.gecius.test_dagger2.mainactivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Named;

import lt.gecius.test_dagger2.R;
import lt.gecius.test_dagger2.app.ApplicationComponent;
import lt.gecius.test_dagger2.app.ApplicationModule;
import lt.gecius.test_dagger2.app.DemoApplication;


public class MainActivity extends ActionBarActivity {

    @Named(ApplicationModule.APP_STRING)
	@Inject String appString;


    @Named(ActivityModule.ACTIVITY_STRING)
    @Inject String activityString;

    private ActivityComponent mActivityComponent;
    private TextView mTextViewAppString;
    private TextView mTextViewActivityString;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        findViews();

        setupInjectButton();

        initComponent();
		injectDependencies();
		demoComponentCapabilities();
		setTextViews();
	}

    private void findViews() {
        mTextViewAppString = (TextView) findViewById(R.id.application_component_string);
        mTextViewActivityString = (TextView) findViewById(R.id.activity_component_string);
    }

    private void setupInjectButton() {
        findViewById(R.id.inject_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                injectDependencies();
                setTextViews();
            }
        });
    }

    private void initComponent() {
        ApplicationComponent appComponent = ((DemoApplication) getApplication()).getComponent();
        mActivityComponent = appComponent.plus(new ActivityModule(this));
    }

    private void injectDependencies() {
        mActivityComponent.inject(this);
    }

    private void setTextViews() {
        String hashCodeAppString = String.valueOf(appString.hashCode());
        mTextViewAppString.setText(hashCodeAppString);

        String hashCodeActivityString = String.valueOf(activityString.hashCode());
        mTextViewActivityString.setText(hashCodeActivityString);
	}

	@SuppressWarnings("unused")
	private void demoComponentCapabilities() {
		ApplicationComponent component = ((DemoApplication) getApplication()).getComponent();
		//this show how instantiated objects can be directly accessed from component
		SharedPreferences sharedPreferences = component.getSharedPreferences();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}

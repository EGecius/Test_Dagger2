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
import lt.gecius.test_dagger2.app.Message;


public class MainActivity extends ActionBarActivity {

    @Named(ApplicationModule.APP_MSG)
	@Inject Message appMessage;


    @Named(ActivityModule.ACTIVITY_MSG)
    @Inject Message activityMessage;

    private ActivityComponent mActivityComponent;
    private TextView mTextViewAppStringName;
    private TextView mTextViewAppStringHashcode;
    private TextView mTextViewActivityStringName;
    private TextView mTextViewActivityStringHashcode;

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
        mTextViewAppStringName = (TextView) findViewById(R.id.application_component_string_name);
        mTextViewAppStringHashcode = (TextView) findViewById(R.id.application_component_string_hashcode);
        mTextViewActivityStringName = (TextView) findViewById(R.id.activity_component_string_name);
        mTextViewActivityStringHashcode = (TextView) findViewById(R.id.activity_component_string_hashcode);
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
        mTextViewAppStringName.setText(appMessage.stringMsg);

        String hashCodeAppString = String.valueOf(appMessage.hashCode());
        mTextViewAppStringHashcode.setText(hashCodeAppString);

        mTextViewActivityStringName.setText(activityMessage.stringMsg);

        String hashCodeActivityString = String.valueOf(activityMessage.hashCode());
        mTextViewActivityStringHashcode.setText(hashCodeActivityString);
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

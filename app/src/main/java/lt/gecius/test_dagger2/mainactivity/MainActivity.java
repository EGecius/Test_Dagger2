package lt.gecius.test_dagger2.mainactivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import lt.gecius.test_dagger2.R;
import lt.gecius.test_dagger2.app.ApplicationComponent;
import lt.gecius.test_dagger2.app.DemoApplication;


public class MainActivity extends ActionBarActivity {

//	@Inject SharedPreferences mSharedPrefs;
	@Inject String injectedString;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        setupInjectButton();

		injectDependencies();
		demoComponentCapabilities();
//		mSharedPrefs.edit().putString("status", "success!").apply();

		setTextView();
	}

    private void setupInjectButton() {
        findViewById(R.id.inject_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                injectDependencies();
            }
        });
    }

    private void injectDependencies() {
        ApplicationComponent appComponent = ((DemoApplication) getApplication()).getComponent();
        ActivityComponent activityComponent = appComponent.plus(new ActivityModule(this));
        activityComponent.inject(this);
    }

    private void setTextView() {
		TextView textView = (TextView) findViewById(R.id.application_component_string);


        String hashCode = String.valueOf(injectedString.hashCode());
        Log.i("Eg:MainActivity:44", "setTextView injectedString " + hashCode);

		textView.setText(hashCode);
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

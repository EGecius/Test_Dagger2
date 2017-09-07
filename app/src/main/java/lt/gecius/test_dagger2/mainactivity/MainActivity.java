package lt.gecius.test_dagger2.mainactivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
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

		injectDependencies();
		demoComponentCapabilities();
//		mSharedPrefs.edit().putString("status", "success!").apply();

		setTextView();
	}

	private void setTextView() {
		TextView textView = (TextView) findViewById(R.id.test_string);
		textView.setText(injectedString);
	}

	@SuppressWarnings("unused")
	private void demoComponentCapabilities() {
		ApplicationComponent component = ((DemoApplication) getApplication()).getComponent();
		//this show how instantiated objects can be directly accessed from component
		SharedPreferences sharedPreferences = component.getSharedPreferences();
	}

	private void injectDependencies() {
		ApplicationComponent component = ((DemoApplication) getApplication()).getComponent();
		component.inject(this);
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

package lt.gecius.test_dagger2.services;

import static lt.gecius.test_dagger2.app.ApplicationModule.APP_MSG;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

import lt.gecius.test_dagger2.app.DemoApplication;
import lt.gecius.test_dagger2.app.Message;

public class MyIntentService extends IntentService {

    public static final String TAG = MyIntentService.class.getSimpleName();

    @Inject
    @Named(APP_MSG)
    Message mMessage;

    public MyIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        injectDependencies();
        print();
    }

    private void print() {
        Log.i("Eg:MyIntentService:36", "print mMessage " + mMessage);
    }

    private void injectDependencies() {
        if (mMessage != null) {
            return;
        }

        DemoApplication application = (DemoApplication) getApplication();
        application.getComponent().inject(this);
    }
}

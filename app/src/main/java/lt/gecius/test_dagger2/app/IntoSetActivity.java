package lt.gecius.test_dagger2.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Set;

import javax.inject.Inject;

import lt.gecius.test_dagger2.R;
import lt.gecius.test_dagger2.di.IntoSetInterface;
import lt.gecius.test_dagger2.di.intoset.DaggerIntoSetComponent;

public class IntoSetActivity extends AppCompatActivity {

    @Inject
    Set<IntoSetInterface> mIntoSetInterfaces;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intoset);
        injectDependencies();
    }

    @Override
    protected void onResume() {
        super.onResume();
        emitUpdates();
    }

    private void emitUpdates() {
        for (IntoSetInterface intoSetInterface : mIntoSetInterfaces) {
            intoSetInterface.onUpdate("Egis update");
        }
    }

    private void injectDependencies() {
        DaggerIntoSetComponent.builder().build().injectInto(this);
    }

}

package lt.gecius.test_dagger2.di.intoset;

import android.util.Log;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import lt.gecius.test_dagger2.di.IntoSetInterface;

@Module
public class IntoSetModule {

    @Provides
    @IntoSet
    IntoSetInterface providesIntoSetInterface1() {
        return new IntoSetInterface() {
            @Override
            public void onUpdate(String update) {
                Log.i("Eg:IntoSetModule:17", "onUpdate update " + update);
            }
        };
    }

    @Provides
    @IntoSet
    IntoSetInterface providesIntoSetInterface2() {
        return new IntoSetInterface() {
            @Override
            public void onUpdate(String update) {
                Log.i("Eg:IntoSetModule:30", "onUpdate update " + update);
            }
        };
    }
}

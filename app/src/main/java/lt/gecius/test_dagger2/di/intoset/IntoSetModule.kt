package lt.gecius.test_dagger2.di.intoset

import android.util.Log

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import lt.gecius.test_dagger2.di.IntoSetInterface

@Module
class IntoSetModule {

    /* Using @IntoSet tells tagger to add all implementations of the same type into a Set<T> and
    inject it when required. */

    @Provides
    @IntoSet
    internal fun providesIntoSetInterface1(): IntoSetInterface {
        return IntoSetInterface { update -> Log.i("Eg:IntoSetModule:17", "onUpdate update " + update) }
    }

    @Provides
    @IntoSet
    internal fun providesIntoSetInterface2(): IntoSetInterface {
        return IntoSetInterface { update -> Log.i("Eg:IntoSetModule:30", "onUpdate update " + update) }
    }
}

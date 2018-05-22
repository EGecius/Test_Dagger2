package lt.gecius.test_dagger2.di.intoset

import dagger.Component
import lt.gecius.test_dagger2.app.IntoSetActivity

@Component(modules = arrayOf(IntoSetModule::class))
interface IntoSetComponent {

    fun injectInto(activity: IntoSetActivity)
}

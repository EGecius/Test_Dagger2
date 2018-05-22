package lt.gecius.test_dagger2.app

import android.app.Application

import lt.gecius.test_dagger2.di.ApplicationComponent
import lt.gecius.test_dagger2.di.ApplicationModule
import lt.gecius.test_dagger2.di.DaggerApplicationComponent


class DemoApplication : Application() {

    lateinit var component: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}

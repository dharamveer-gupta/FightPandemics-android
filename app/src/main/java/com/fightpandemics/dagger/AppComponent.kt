package com.fightpandemics.dagger

import android.app.Application
import android.content.Context
import com.fightpandemics.dagger.scope.AppScope
import com.fightpandemics.login.dagger.LoginComponent
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [AppModule::class, AppSubcomponentsModule::class],
    dependencies = [CoreComponent::class]
)
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // with @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context, coreComponent: CoreComponent): AppComponent
    }

    fun loginComponent(): LoginComponent.Factory

    fun inject(application: Application)
}

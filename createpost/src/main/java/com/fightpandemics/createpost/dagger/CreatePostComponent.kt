package com.fightpandemics.createpost.dagger

import com.fightpandemics.core.dagger.scope.ActivityScope
import com.fightpandemics.createpost.data.api.NetworkApi
import com.fightpandemics.createpost.domain.repository.CreatePostRepository
import com.fightpandemics.createpost.ui.CreatePostFragment
import dagger.Subcomponent
import kotlinx.coroutines.InternalCoroutinesApi

/**
 * Component binding injections for the [:createpost] module.
 */
@ActivityScope
@Subcomponent(
    modules = [
        CreatePostModule::class,
        CreatePostViewModelModule::class,
        CreatePostNetworkModule::class,
        CreatePostDataModule::class,
        CreatePostRemoteModule::class
    ]
)
interface CreatePostComponent {

    // Factory that is used to create instances of the createPostComponent subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): CreatePostComponent
    }

    @InternalCoroutinesApi
    fun inject(createPostFragment: CreatePostFragment)

    fun provideCreatePostRepository(): CreatePostRepository
    fun provideNetworkApi(): NetworkApi
}
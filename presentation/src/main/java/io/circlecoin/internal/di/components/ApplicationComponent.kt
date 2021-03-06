/**
 * Copyright (C) 2017 Javier Tarazaga Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.circlecoin.internal.di.components

import android.content.Context
import android.content.SharedPreferences

import io.circlecoin.domain.executor.PostExecutionThread
import io.circlecoin.domain.executor.ThreadExecutor
import io.circlecoin.internal.di.modules.ApplicationModule
import io.circlecoin.view.BaseActivity
import javax.inject.Singleton

import dagger.Component

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
  fun inject(baseActivity: BaseActivity)

  //Exposed to sub-graphs.
  fun context(): Context

  fun threadExecutor(): ThreadExecutor
  fun postExecutionThread(): PostExecutionThread
  fun sharedPreferences(): SharedPreferences
}

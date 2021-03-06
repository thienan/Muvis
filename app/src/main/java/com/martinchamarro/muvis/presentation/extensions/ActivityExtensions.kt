/*
 * Copyright 2017 Martin Chamarro (@martinchamarro)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.martinchamarro.muvis.presentation.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import com.martinchamarro.muvis.AndroidApplication
import com.martinchamarro.muvis.presentation.di.ActivityComponent
import com.martinchamarro.muvis.presentation.di.ActivityModule
import com.martinchamarro.muvis.presentation.di.DaggerActivityComponent


fun Activity.fullScreen() {
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
}

val Activity.context: Context
    get() = this

val Activity.activityComponent: ActivityComponent
    get() = DaggerActivityComponent.builder()
            .applicationComponent((application as AndroidApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
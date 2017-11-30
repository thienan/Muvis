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

package com.martinchamarro.muvis.presentation.views.splash

import com.martinchamarro.muvis.presentation.base.BasePresenter
import com.martinchamarro.muvis.presentation.navigation.Navigator
import com.martinchamarro.muvis.threading.async
import javax.inject.Inject


class SplashPresenter @Inject constructor(private val navigator: Navigator) : BasePresenter {

    companion object {
        private val SPLASH_DELAY = 1500L
    }

    var view: View? = null

    override fun initialize() {
        async(SPLASH_DELAY) {
            navigator.navigateToHome()
            view?.finish()
        }
    }

    override fun onDestroy() {
        view = null
    }

    interface View {
        fun finish()
    }
}

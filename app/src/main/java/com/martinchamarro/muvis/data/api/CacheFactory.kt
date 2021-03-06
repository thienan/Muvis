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

package com.martinchamarro.muvis.data.api

import android.content.Context
import okhttp3.Cache
import java.io.File

class CacheFactory {

    companion object {

        const val DEFAULT_SIZE: Long = 10 * 1024 * 1024 // 10 MB
        const val DEFAULT_DIR: String = "cache"

        fun create(
                context: Context,
                size: Long = DEFAULT_SIZE,
                directory: File = File(context.cacheDir, DEFAULT_DIR)): Cache {
            return Cache(directory, size)
        }

    }
}
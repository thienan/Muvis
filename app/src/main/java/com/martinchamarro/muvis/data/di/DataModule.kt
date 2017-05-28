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

package com.martinchamarro.muvis.data.di

import com.martinchamarro.muvis.data.api.*
import com.martinchamarro.muvis.data.cache.*
import com.martinchamarro.muvis.data.repository.MoviesRepositoryImpl
import com.martinchamarro.muvis.domain.repository.MoviesRepository

import dagger.Module
import dagger.Provides

@Module class DataModule {

    @Provides fun provideRepository(repository: MoviesRepositoryImpl): MoviesRepository = repository

    @Provides fun provideApi(api: RetrofitApi): Api = api

    @Provides fun provideCache(cache: MoviesCacheImpl): MoviesCache = cache
}
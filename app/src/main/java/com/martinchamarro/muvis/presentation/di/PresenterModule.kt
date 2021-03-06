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

package com.martinchamarro.muvis.presentation.di

import com.martinchamarro.muvis.domain.usecase.*
import com.martinchamarro.muvis.globalutils.logger.Logger
import com.martinchamarro.muvis.presentation.navigation.Navigator
import com.martinchamarro.muvis.presentation.ui.detail.*
import com.martinchamarro.muvis.presentation.ui.favorites.*
import com.martinchamarro.muvis.presentation.ui.movies.*
import com.martinchamarro.muvis.presentation.ui.search.*
import com.martinchamarro.muvis.presentation.ui.splash.*

import dagger.Module
import dagger.Provides

@Module class PresenterModule {

    @Provides fun provideSplashPresenter(navigator: Navigator): SplashContract.Presenter {
        return SplashPresenter(navigator)
    }

    @Provides fun provideMoviesPresenter(getFeatured: GetFeatured): MoviesContract.Presenter {
        return MoviesPresenter(getFeatured)
    }

    @Provides fun provideDetailPresenter(getMovie: GetMovie, getDetail: GetDetail, getCredits: GetCredits, getTrailer: GetTrailer, setFavorite: SetFavorite, navigator: Navigator, logger: Logger): DetailContract.Presenter {
        return DetailPresenter(getMovie, getDetail, getCredits, getTrailer, setFavorite, navigator, logger)
    }

    @Provides fun provideFavoritesPresenter(getFavorites: GetFavorites): FavoritesContract.Presenter {
        return FavoritesPresenter(getFavorites)
    }

    @Provides fun provideSearchPresenter(searchMovies: SearchMovies, logger: Logger): SearchContract.Presenter {
        return SearchPresenter(searchMovies, logger)
    }

}

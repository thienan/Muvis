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

package com.martinchamarro.muvis.presentation.views.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.martinchamarro.muvis.R;
import com.martinchamarro.muvis.presentation.base.BaseActivity;
import com.martinchamarro.muvis.presentation.views.utils.MenuVisibilityChanger;

import butterknife.BindView;
import butterknife.OnPageChange;


public class HomeActivity extends BaseActivity {

    @BindView(R.id.toolbar) protected Toolbar toolbar;
    @BindView(R.id.pager) protected ViewPager pager;
    @BindView(R.id.bottom_navigation) protected BottomNavigationView bottomNavigation;
    private MenuVisibilityChanger menuVisibility;

    public static void start(Context context) {
        context.startActivity(new Intent(context, HomeActivity.class));
    }

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        configureToolbar();
        configurePager();
        configureNavigation();
    }

    @Override protected int getLayoutResource() {
        return R.layout.activity_home;
    }

    private void injectDependencies() {
        getActivityComponent().inject(this);
    }

    private void configureToolbar() {
        toolbar.inflateMenu(R.menu.home_menu);
        toolbar.setOnMenuItemClickListener(this::onToolbarMenuItemClick);
        menuVisibility = new MenuVisibilityChanger(toolbar.getMenu());
    }

    private void configurePager() {
        pager.setAdapter(new HomePagerAdapter(getSupportFragmentManager()));
    }

    @OnPageChange(R.id.pager) protected void onPageChange(int position) {
        bottomNavigation.getMenu().getItem(position).setChecked(true);
        menuVisibility.setVisible(position == 0);
    }

    private void configureNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener(this::onNavigationItemClick);
    }

    private boolean onNavigationItemClick(MenuItem item) {
        int itemId = item.getItemId();
        pager.setCurrentItem(itemId == R.id.action_films ? 0 : 1);
        menuVisibility.setVisible(itemId == R.id.action_films);
        return true;
    }

    private boolean onToolbarMenuItemClick(MenuItem item) {
        return true;
    }
}
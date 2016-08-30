/*
 * Copyright (c) Joaquim Ley 2016. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.joaquimley.core;

import android.app.Application;

import com.joaquimley.core.data.network.MarvelService;
import com.joaquimley.core.data.network.MarvelServiceFactory;
import com.squareup.leakcanary.LeakCanary;

public class AvengingApplication extends Application {

    private static AvengingApplication sInstance;
    private static MarvelService sMarvelService;
//    private static PresenterCache sPresenterCache;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        sInstance = this;
        sMarvelService = MarvelServiceFactory.makeMarvelService(true);
//        sPresenterCache = PresenterCache.makePresenterCache();
    }

    public static AvengingApplication getInstance() {
        if (sInstance == null) {
            sInstance = new AvengingApplication();
        }
        return sInstance;
    }

    public MarvelService getMarvelService() {
        if (sMarvelService == null) {
            sMarvelService = MarvelServiceFactory.makeMarvelService(BuildConfig.DEBUG);
        }
        return sMarvelService;
    }
}

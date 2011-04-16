/*
 * Copyright 2011 Oleg Elifantiev
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ru.elifantiev.yandex.oauth;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesStorage implements AccessTokenStorage {

    private SharedPreferences prefs;

    public SharedPreferencesStorage(Context ctx) {
        prefs = ctx.getSharedPreferences("tokenStorage", Context.MODE_PRIVATE);
    }

    public AccessToken getToken(String tokenId) {
        String sToken = prefs.getString(tokenId, "");
        if(sToken.equals(""))
            return null;
        else
            return new AccessToken(sToken);
    }

    public void storeToken(AccessToken token, String tokenId) {
        prefs.edit().putString(tokenId, token.toString()).commit();
    }
}
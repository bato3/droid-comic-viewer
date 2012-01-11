/*******************************************************************************
 * Copyright 2009 Robot Media SL
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.robotmedia.acv.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class IntentUtils {

	private final static String MARKET_URI = "market://search?q=pname:";
	
	public static void openMarket(Context context, String packageName) {
		view(context, MARKET_URI + packageName);
	}
	
	public static void view(Context context, String uri) {
		final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
		context.startActivity(intent);
	}
}

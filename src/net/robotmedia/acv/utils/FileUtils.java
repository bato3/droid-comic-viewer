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

import java.io.File;

public class FileUtils {

	private static final String EXTENSION_TTF = "ttf";
	private static final String EXTENSION_HTM = "htm";
	private static final String EXTENSION_HTML = "html";

	private static String getExtension(String fileName) {
		int index = fileName.lastIndexOf(".");
		if (index > 0) {
			return fileName.substring(index + 1, fileName.length());
		} else {
			return "";			
		}
	}

	public static boolean isFont(String fileName) {
		final String extension = getExtension(fileName);
		return EXTENSION_TTF.equalsIgnoreCase(extension);
	}

	public static boolean isHidden(String entryName) {
		final String[] splitPath = entryName.split("/");
		final String fileName = splitPath[splitPath.length - 1];
		return fileName.startsWith(".");
	}

	public static boolean isWebpage(String fileName) {
		final String extension = getExtension(fileName);
		return EXTENSION_HTM.equalsIgnoreCase(extension) || EXTENSION_HTML.equalsIgnoreCase(extension);
	}
	
	public static void deleteDirectory(File directory) {
		String[] files = directory.list();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				File file = new File(directory, files[i]);
				if (file.isDirectory()) {
					deleteDirectory(file);
				} else {
					file.delete();
				}
			}
		}
		directory.delete();
	}
}

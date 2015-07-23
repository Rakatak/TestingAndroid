package com.thalia.xca.aos.prop;

import java.io.File;

public final class AppiumSetup {
	
	public static final int timeOutfirst = 3;
	public static final int timeOutsecond = 35;
	public static File currentDir = new File(System.getProperty("user.dir"));
	public static final String appPath = currentDir + "/app/thalia-debug.apk";
//	public static final String appPath = currentDir + "/app/Thalia-release.apk";
	
	public static final int nexusHeight = 1824;
	public static final int motoHeight = 1184;
	public static final int galaxyHeight = 1920;
}

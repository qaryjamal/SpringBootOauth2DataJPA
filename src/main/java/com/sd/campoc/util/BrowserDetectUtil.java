package com.sd.campoc.util;

/*
 * @author    : irfan
 * @Date      : 23-May-17
 * @version   : ver. 1.0.0
 * 
 * ________________________________________________________________________________________________
 *
 *  Developer				Date		     Version		Operation		Description
 * ________________________________________________________________________________________________ 
 *	
 * 
 * ________________________________________________________________________________________________
 *
 * @Project   : adminportal
 * @Package   : com.sd.campoc.util
 * @FileName  : BrowserDetectUtil
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */

import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;

public class BrowserDetectUtil {

    public static String detectBrowser(HttpServletRequest request) {

        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("user-Agent"));
        String uaString = userAgent.getBrowser() + " / " + userAgent.getBrowserVersion();

        return uaString;
    }

    public static String detectOS(HttpServletRequest request) {

        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("user-Agent"));
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();

        return operatingSystem.getName() + " / " + operatingSystem.getManufacturer();
    }
}

package com.sd.campoc.util;

import java.net.HttpURLConnection;
import java.net.URL;

/*
 * @author    : irfan nasim
 * @Date      : 19-Jul-17
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
 * @FileName  : ResourceCheckUtil
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */
public class ResourceCheckUtil {

    public static boolean urlExists(String Url) {
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection con = (HttpURLConnection) new URL(Url).openConnection();
            con.setRequestMethod("HEAD");
            return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            return false;
        }
    }
}

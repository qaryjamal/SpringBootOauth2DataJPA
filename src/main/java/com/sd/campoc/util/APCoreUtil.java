package com.sd.campoc.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @author    : irfan
 * @Date      : 22-May-17
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
 * @FileName  : APCoreUtil
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */

public class APCoreUtil {

    public static boolean isNull(String checkString) {
        if (null == checkString || checkString.trim().length() == 0 || checkString.trim().equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }

    public static boolean isValidObject(Object object) {
        if (null != object) {
            return true;
        }
        return false;
    }

    public static boolean isListEmpty(List<?> dataList) {
        if (null == dataList || dataList.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isMapEmpty(Map<?, ?> dataMap) {
        if (null == dataMap || dataMap.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isSetEmpty(Set<?> dataSet) {
        if (null == dataSet || dataSet.isEmpty()) {
            return true;
        }
        return false;
    }
}

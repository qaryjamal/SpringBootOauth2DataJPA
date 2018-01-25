package com.sd.campoc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * @author    : irfan nasim
 * @Date      : 16-Aug-17
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
 * @FileName  : DateUtil
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */
public class DateUtil {

    public static String convertDateToUFDateFormat(Date d, long millis) {
        if (!APCoreUtil.isValidObject(d)) {
            d = new Date(millis);
        }

        String str = "";
        if (d != null) {

            Calendar start = Calendar.getInstance();
            start.setTime(d);
            Calendar end = Calendar.getInstance();
            end.setTime(new Date());

            SimpleDateFormat sameYrDateFormat = new SimpleDateFormat(APConstants.DATE_PATTERN_SAME_YEAR),
                    preYrDateFormat = new SimpleDateFormat(APConstants.DATE_FORMATE_ONE),
                    stf = new SimpleDateFormat(APConstants.TIME_PATTERN);

            long diff = end.getTimeInMillis() - start.getTimeInMillis();

            if ((diff / 1000) <= 60) {
                str = "few seconds ago";
            } else if ((diff / 60000) <= 60) {
                str = (diff / 60000) + " minutes ago";
            } else if ((diff / 3600000) <= 24) {
                str = (diff / 3600000) + " hours ago";
            } else if ((diff / 3600000) > 24 && (diff / 3600000) < 48) {
                str = "Yesterday at " + stf.format(d).toLowerCase();
            } else if (start.getTime().getYear() != end.getTime().getYear()) {
                str = preYrDateFormat.format(d) + " at " + stf.format(d).toLowerCase();
            } else if ((diff / 31536000000L) <= 12) {
                str = sameYrDateFormat.format(d) + " at " + stf.format(d).toLowerCase();
            }
            //System.out.println("Date::: " + str);
        }
        return str;
    }

    public static long addDaysInMilliDays(long millisDate, int days) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millisDate);
        c.add(Calendar.DATE, days);

        return c.getTimeInMillis();
    }
}

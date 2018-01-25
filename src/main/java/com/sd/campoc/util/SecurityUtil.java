package com.sd.campoc.util;

import com.sd.campoc.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * @author    : irfan nasim
 * @Date      : 07-Sep-17
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
 * @FileName  : SecurityUtil
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */
public class SecurityUtil {
    public static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

    public static final boolean hasRole(String role, User user) {
        boolean hasRole = false;
        if (role.equalsIgnoreCase(user.getRole().getName())) {
            hasRole = true;
        }
        return hasRole;
    }
}

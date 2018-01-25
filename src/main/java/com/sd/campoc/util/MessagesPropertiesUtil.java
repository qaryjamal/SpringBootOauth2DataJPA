package com.sd.campoc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/*
 * @author    : irfan nasim
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
 * @FileName  : MessagesPropertiesUtil
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */

@Component
public class MessagesPropertiesUtil {
    @Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource);
    }

    public String get(String code) {
        return accessor.getMessage(code);
    }
}

package com.sd.campoc.configuration;

/*
 * @author    : irfan nasim
 * @Date      : 24-May-17
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
 * @Package   : com.sd.campoc.configuration
 * @FileName  : StaticContextAccessor
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StaticContextAccessor {

    private static StaticContextAccessor instance;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void registerInstance() {
        instance = this;
    }

    public static <T> T getBean(Class<T> clazz) {
        return instance.applicationContext.getBean(clazz);
    }
}

package com.sd.campoc.enums;

/*
 * @author    : irfan
 * @Date      : 09-Jun-17
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
 * @Project   : BLCamPOC
 * @Package   : com.sd.campoc.enums
 * @FileName  : UserRoleEnum
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */

public enum UserRoleEnum {

    USER("USER");

    private String value;

    UserRoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}


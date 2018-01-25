package com.sd.campoc.enums;

/*
 * @author    : irfan nasim
 * @Date      : 12-Sep-17
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
 * @Package   : com.sd.campoc.util
 * @FileName  : HTTPContentTypeEnum
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */

public enum HTTPContentTypeEnum {

    APLICATION_JSON("application/json"),
    APLICATION_XML("application/xml");

    private String value;

    HTTPContentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

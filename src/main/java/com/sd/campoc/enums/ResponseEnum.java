package com.sd.campoc.enums;

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
 * @Project   : BLCamPOC
 * @Package   : com.sd.campoc.enums
 * @FileName  : ResponseEnum
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */

public enum ResponseEnum {

    DATA("DATA"),
    STATUS("STATUS"),
    REASON("REASON"),
    ERROR("ERROR"),
    SUCCESS("SUCCESS"),
    INFO("INFO"),
    NOT_FOUND("NOT_FOUND"),
    EXCEPTION("SYS_ERR_01"),
    INSUFFICIENT_PARAMETERS("SYS_ERR_02"),
    NO_ADMINS_FOUND("ADM_ERR_03"),
    ADMINS_FETCHED_SUCCESSFULLY("ADM_SUC_09");

    private String value;

    ResponseEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    }

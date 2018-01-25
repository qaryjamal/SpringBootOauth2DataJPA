package com.sd.campoc.util;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.xml.bind.DatatypeConverter;

/*
 * @author    : irfan nasim
 * @Date      : 08-Jun-17
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
 * @FileName  : EncryptionUtil
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */
public class EncryptionUtil {

    public static String Base64Encode(String str) {
        String encoded = new String(Base64.encodeBase64(str.getBytes()));
        return encoded;
    }

    public static String Base64Decode(byte[] encodedStringBytes) {
        String decoded = new String(Base64.decodeBase64(encodedStringBytes));
        return decoded;
    }

    public static String Base64Decode(String encodedString) {
        String decoded = new String(Base64.decodeBase64(encodedString));
        return decoded;
    }

    public static String[] decodeExpiredPasswordToken(String auth) {
        //Decode the Base64 into byte[]
        byte[] decodedBytes = DatatypeConverter.parseBase64Binary(auth);

        //If the decode fails in any case
        if (decodedBytes == null || decodedBytes.length == 0) {
            return null;
        }

        //Now we can convert the byte[] into a splitted array :
        //  - the first one is userId,
        //  - the second one contactId
        return new String(decodedBytes).split(":", 2);
    }
}

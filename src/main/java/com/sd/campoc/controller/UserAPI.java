package com.sd.campoc.controller;

import com.sd.campoc.enums.ResponseEnum;
import com.sd.campoc.model.User;
import com.sd.campoc.model.wrapper.AdminWrapper;
import com.sd.campoc.response.GenericAPIResponse;
import com.sd.campoc.service.user.UserService;
import com.sd.campoc.util.APCoreUtil;
import com.sd.campoc.util.APIUtil;
import com.sd.campoc.util.MessagesPropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
 * @Project   : BLCamPOC
 * @Package   : com.sd.campoc.controller
 * @FileName  : AdminAPI
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserAPI {

    public static final Logger logger = LoggerFactory.getLogger(UserAPI.class);

    @Autowired
    UserService userService;
    @Autowired
    MessagesPropertiesUtil messages;

    /**
     * @param id
     * @return Response with Admin detail.
     * @author Irfan Nasim
     * @description API will return admin detail.
     * @since 26-05-2017
     */
    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAdminById(HttpServletRequest request,
                                          @PathVariable("id") long id) {

        logger.info("get admin by Id{" + id + "} requested by User Name: " + request.getRemoteUser().toString());

        GenericAPIResponse response = new GenericAPIResponse();
        response.setResponseMessage(messages.get("admin.not.found"));
        response.setResponseCode(ResponseEnum.ADMIN_DOES_NOT_EXIST.getValue());
        response.setResponseStatus(ResponseEnum.ERROR.getValue());
        response.setResponseData(null);

        try {
            User admin = userService.findAdminWithAnyRoleById(id, true, false);

            if (APCoreUtil.isValidObject(admin)) {
                logger.info("Admin Fetched from DB successfully...");
                response.setResponseMessage(messages.get("admin.fetched.success"));
                response.setResponseCode(ResponseEnum.ADMIN_FETCHED_SUCCESSFULLY.getValue());
                response.setResponseStatus(ResponseEnum.SUCCESS.getValue());
                response.setResponseData(admin);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception ex) {
            logger.error("get Admin by Id failed.", ex.fillInStackTrace());
            response.setResponseData("");
            response.setResponseStatus(ResponseEnum.ERROR.getValue());
            response.setResponseCode(ResponseEnum.EXCEPTION.getValue());
            response.setResponseMessage(messages.get("exception.occurs"));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }*/

    /**
     * @return Response with all Admins.
     * @author Irfan Nasim
     * @description API will return detail of all admins.
     * @since 12-07-2017
     */
    @RequestMapping(value = "/admins", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAdmins(HttpServletRequest request) {
        logger.info("get all Admins API called requested by User Name: " + request.getRemoteUser().toString());

        GenericAPIResponse response = new GenericAPIResponse();
        response.setResponseMessage(messages.get("admins.not.found"));
        response.setResponseCode(ResponseEnum.NO_ADMINS_FOUND.getValue());
        response.setResponseStatus(ResponseEnum.ERROR.getValue());
        response.setResponseData(null);

        try {
            List<User> dbAdmins = userService.findAllUsers();
            //List<AdminWrapper> admins = APIUtil.buildAdminWrapper(dbAdmins);

            if (!APCoreUtil.isListEmpty(dbAdmins)) {
                logger.info("Admins Fetched from DB successfully...");
                response.setResponseMessage(messages.get("admins.fetched.success"));
                response.setResponseCode(ResponseEnum.ADMINS_FETCHED_SUCCESSFULLY.getValue());
                response.setResponseStatus(ResponseEnum.SUCCESS.getValue());
                response.setResponseData(dbAdmins);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception ex) {
            logger.error("get all admins failed.", ex.fillInStackTrace());
            response.setResponseData("");
            response.setResponseStatus(ResponseEnum.ERROR.getValue());
            response.setResponseCode(ResponseEnum.EXCEPTION.getValue());
            response.setResponseMessage(messages.get("exception.occurs"));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}

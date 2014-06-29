/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.app.logintrack.service.impl;

import com.app.logintrack.model.LoginData;
import com.app.logintrack.model.impl.LoginDataImpl;
import com.app.logintrack.service.LoginDataLocalServiceUtil;
import com.app.logintrack.service.base.LoginDataLocalServiceBaseImpl;
import com.app.logintrack.service.persistence.LoginDataUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Calendar;
import java.util.List;

/**
 * The implementation of the login data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.app.logintrack.service.LoginDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pankaj Kathiriya
 * @see com.app.logintrack.service.base.LoginDataLocalServiceBaseImpl
 * @see com.app.logintrack.service.LoginDataLocalServiceUtil
 */
public class LoginDataLocalServiceImpl extends LoginDataLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.app.logintrack.service.LoginDataLocalServiceUtil} to access the login data local service.
	 */
	
	/* (non-Javadoc)
	 * @see com.app.logintrack.service.LoginDataLocalService#addLoginData(long)
	 * function for adding LoginDate record
	 */
	public void addLoginData(long userId) throws SystemException{
		Calendar  calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		LoginData loginData=new LoginDataImpl();
		loginData.setUserId(userId);
		loginData.setLoginDate(calendar.getTime());
		LoginDataLocalServiceUtil.updateLoginData(loginData);
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.app.logintrack.service.LoginDataLocalService#findByUserId(long)
	 * fetching LoginData records by UserId
	 */
	public List<LoginData> findByUserId(long userId) throws SystemException{
		return LoginDataUtil.findByUserId(userId);
	}
}
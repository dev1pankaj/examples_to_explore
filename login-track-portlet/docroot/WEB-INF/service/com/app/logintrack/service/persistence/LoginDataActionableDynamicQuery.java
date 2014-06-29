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

package com.app.logintrack.service.persistence;

import com.app.logintrack.model.LoginData;
import com.app.logintrack.service.LoginDataLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Pankaj Kathiriya
 * @generated
 */
public abstract class LoginDataActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public LoginDataActionableDynamicQuery() throws SystemException {
		setBaseLocalService(LoginDataLocalServiceUtil.getService());
		setClass(LoginData.class);

		setClassLoader(com.app.logintrack.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("primaryKey.userId");
	}
}
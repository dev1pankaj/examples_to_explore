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

package com.app.logintrack.model.impl;

import com.app.logintrack.model.LoginData;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LoginData in entity cache.
 *
 * @author Pankaj Kathiriya
 * @see LoginData
 * @generated
 */
public class LoginDataCacheModel implements CacheModel<LoginData>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", loginDate=");
		sb.append(loginDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LoginData toEntityModel() {
		LoginDataImpl loginDataImpl = new LoginDataImpl();

		loginDataImpl.setUserId(userId);

		if (loginDate == Long.MIN_VALUE) {
			loginDataImpl.setLoginDate(null);
		}
		else {
			loginDataImpl.setLoginDate(new Date(loginDate));
		}

		loginDataImpl.resetOriginalValues();

		return loginDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		loginDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);
		objectOutput.writeLong(loginDate);
	}

	public long userId;
	public long loginDate;
}
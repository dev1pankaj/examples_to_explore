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

package com.app.logintrack.model;

import com.app.logintrack.service.persistence.LoginDataPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Pankaj Kathiriya
 * @generated
 */
public class LoginDataSoap implements Serializable {
	public static LoginDataSoap toSoapModel(LoginData model) {
		LoginDataSoap soapModel = new LoginDataSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setLoginDate(model.getLoginDate());

		return soapModel;
	}

	public static LoginDataSoap[] toSoapModels(LoginData[] models) {
		LoginDataSoap[] soapModels = new LoginDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LoginDataSoap[][] toSoapModels(LoginData[][] models) {
		LoginDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LoginDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LoginDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LoginDataSoap[] toSoapModels(List<LoginData> models) {
		List<LoginDataSoap> soapModels = new ArrayList<LoginDataSoap>(models.size());

		for (LoginData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LoginDataSoap[soapModels.size()]);
	}

	public LoginDataSoap() {
	}

	public LoginDataPK getPrimaryKey() {
		return new LoginDataPK(_userId, _loginDate);
	}

	public void setPrimaryKey(LoginDataPK pk) {
		setUserId(pk.userId);
		setLoginDate(pk.loginDate);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getLoginDate() {
		return _loginDate;
	}

	public void setLoginDate(Date loginDate) {
		_loginDate = loginDate;
	}

	private long _userId;
	private Date _loginDate;
}
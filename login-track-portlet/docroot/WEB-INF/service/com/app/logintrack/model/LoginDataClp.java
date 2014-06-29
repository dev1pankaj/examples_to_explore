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

import com.app.logintrack.service.ClpSerializer;
import com.app.logintrack.service.LoginDataLocalServiceUtil;
import com.app.logintrack.service.persistence.LoginDataPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pankaj Kathiriya
 */
public class LoginDataClp extends BaseModelImpl<LoginData> implements LoginData {
	public LoginDataClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LoginData.class;
	}

	@Override
	public String getModelClassName() {
		return LoginData.class.getName();
	}

	@Override
	public LoginDataPK getPrimaryKey() {
		return new LoginDataPK(_userId, _loginDate);
	}

	@Override
	public void setPrimaryKey(LoginDataPK primaryKey) {
		setUserId(primaryKey.userId);
		setLoginDate(primaryKey.loginDate);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new LoginDataPK(_userId, _loginDate);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((LoginDataPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("loginDate", getLoginDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date loginDate = (Date)attributes.get("loginDate");

		if (loginDate != null) {
			setLoginDate(loginDate);
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_loginDataRemoteModel != null) {
			try {
				Class<?> clazz = _loginDataRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_loginDataRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getLoginDate() {
		return _loginDate;
	}

	@Override
	public void setLoginDate(Date loginDate) {
		_loginDate = loginDate;

		if (_loginDataRemoteModel != null) {
			try {
				Class<?> clazz = _loginDataRemoteModel.getClass();

				Method method = clazz.getMethod("setLoginDate", Date.class);

				method.invoke(_loginDataRemoteModel, loginDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLoginDataRemoteModel() {
		return _loginDataRemoteModel;
	}

	public void setLoginDataRemoteModel(BaseModel<?> loginDataRemoteModel) {
		_loginDataRemoteModel = loginDataRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _loginDataRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_loginDataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LoginDataLocalServiceUtil.addLoginData(this);
		}
		else {
			LoginDataLocalServiceUtil.updateLoginData(this);
		}
	}

	@Override
	public LoginData toEscapedModel() {
		return (LoginData)ProxyUtil.newProxyInstance(LoginData.class.getClassLoader(),
			new Class[] { LoginData.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LoginDataClp clone = new LoginDataClp();

		clone.setUserId(getUserId());
		clone.setLoginDate(getLoginDate());

		return clone;
	}

	@Override
	public int compareTo(LoginData loginData) {
		LoginDataPK primaryKey = loginData.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoginDataClp)) {
			return false;
		}

		LoginDataClp loginData = (LoginDataClp)obj;

		LoginDataPK primaryKey = loginData.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", loginDate=");
		sb.append(getLoginDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.app.logintrack.model.LoginData");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loginDate</column-name><column-value><![CDATA[");
		sb.append(getLoginDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private Date _loginDate;
	private BaseModel<?> _loginDataRemoteModel;
}
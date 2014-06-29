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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LoginData}.
 * </p>
 *
 * @author Pankaj Kathiriya
 * @see LoginData
 * @generated
 */
public class LoginDataWrapper implements LoginData, ModelWrapper<LoginData> {
	public LoginDataWrapper(LoginData loginData) {
		_loginData = loginData;
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

	/**
	* Returns the primary key of this login data.
	*
	* @return the primary key of this login data
	*/
	@Override
	public com.app.logintrack.service.persistence.LoginDataPK getPrimaryKey() {
		return _loginData.getPrimaryKey();
	}

	/**
	* Sets the primary key of this login data.
	*
	* @param primaryKey the primary key of this login data
	*/
	@Override
	public void setPrimaryKey(
		com.app.logintrack.service.persistence.LoginDataPK primaryKey) {
		_loginData.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this login data.
	*
	* @return the user ID of this login data
	*/
	@Override
	public long getUserId() {
		return _loginData.getUserId();
	}

	/**
	* Sets the user ID of this login data.
	*
	* @param userId the user ID of this login data
	*/
	@Override
	public void setUserId(long userId) {
		_loginData.setUserId(userId);
	}

	/**
	* Returns the user uuid of this login data.
	*
	* @return the user uuid of this login data
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loginData.getUserUuid();
	}

	/**
	* Sets the user uuid of this login data.
	*
	* @param userUuid the user uuid of this login data
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_loginData.setUserUuid(userUuid);
	}

	/**
	* Returns the login date of this login data.
	*
	* @return the login date of this login data
	*/
	@Override
	public java.util.Date getLoginDate() {
		return _loginData.getLoginDate();
	}

	/**
	* Sets the login date of this login data.
	*
	* @param loginDate the login date of this login data
	*/
	@Override
	public void setLoginDate(java.util.Date loginDate) {
		_loginData.setLoginDate(loginDate);
	}

	@Override
	public boolean isNew() {
		return _loginData.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_loginData.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _loginData.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_loginData.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _loginData.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _loginData.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_loginData.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _loginData.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_loginData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_loginData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_loginData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LoginDataWrapper((LoginData)_loginData.clone());
	}

	@Override
	public int compareTo(com.app.logintrack.model.LoginData loginData) {
		return _loginData.compareTo(loginData);
	}

	@Override
	public int hashCode() {
		return _loginData.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.app.logintrack.model.LoginData> toCacheModel() {
		return _loginData.toCacheModel();
	}

	@Override
	public com.app.logintrack.model.LoginData toEscapedModel() {
		return new LoginDataWrapper(_loginData.toEscapedModel());
	}

	@Override
	public com.app.logintrack.model.LoginData toUnescapedModel() {
		return new LoginDataWrapper(_loginData.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _loginData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _loginData.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_loginData.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoginDataWrapper)) {
			return false;
		}

		LoginDataWrapper loginDataWrapper = (LoginDataWrapper)obj;

		if (Validator.equals(_loginData, loginDataWrapper._loginData)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LoginData getWrappedLoginData() {
		return _loginData;
	}

	@Override
	public LoginData getWrappedModel() {
		return _loginData;
	}

	@Override
	public void resetOriginalValues() {
		_loginData.resetOriginalValues();
	}

	private LoginData _loginData;
}
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

package com.app.logintrack.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LoginData. This utility wraps
 * {@link com.app.logintrack.service.impl.LoginDataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Pankaj Kathiriya
 * @see LoginDataLocalService
 * @see com.app.logintrack.service.base.LoginDataLocalServiceBaseImpl
 * @see com.app.logintrack.service.impl.LoginDataLocalServiceImpl
 * @generated
 */
public class LoginDataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.app.logintrack.service.impl.LoginDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the login data to the database. Also notifies the appropriate model listeners.
	*
	* @param loginData the login data
	* @return the login data that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.app.logintrack.model.LoginData addLoginData(
		com.app.logintrack.model.LoginData loginData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLoginData(loginData);
	}

	/**
	* Creates a new login data with the primary key. Does not add the login data to the database.
	*
	* @param loginDataPK the primary key for the new login data
	* @return the new login data
	*/
	public static com.app.logintrack.model.LoginData createLoginData(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK) {
		return getService().createLoginData(loginDataPK);
	}

	/**
	* Deletes the login data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loginDataPK the primary key of the login data
	* @return the login data that was removed
	* @throws PortalException if a login data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.app.logintrack.model.LoginData deleteLoginData(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLoginData(loginDataPK);
	}

	/**
	* Deletes the login data from the database. Also notifies the appropriate model listeners.
	*
	* @param loginData the login data
	* @return the login data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.app.logintrack.model.LoginData deleteLoginData(
		com.app.logintrack.model.LoginData loginData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLoginData(loginData);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.app.logintrack.model.impl.LoginDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.app.logintrack.model.impl.LoginDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.app.logintrack.model.LoginData fetchLoginData(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLoginData(loginDataPK);
	}

	/**
	* Returns the login data with the primary key.
	*
	* @param loginDataPK the primary key of the login data
	* @return the login data
	* @throws PortalException if a login data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.app.logintrack.model.LoginData getLoginData(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLoginData(loginDataPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the login datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.app.logintrack.model.impl.LoginDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of login datas
	* @param end the upper bound of the range of login datas (not inclusive)
	* @return the range of login datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.app.logintrack.model.LoginData> getLoginDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLoginDatas(start, end);
	}

	/**
	* Returns the number of login datas.
	*
	* @return the number of login datas
	* @throws SystemException if a system exception occurred
	*/
	public static int getLoginDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLoginDatasCount();
	}

	/**
	* Updates the login data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loginData the login data
	* @return the login data that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.app.logintrack.model.LoginData updateLoginData(
		com.app.logintrack.model.LoginData loginData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLoginData(loginData);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void addLoginData(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addLoginData(userId);
	}

	public static java.util.List<com.app.logintrack.model.LoginData> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserId(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LoginDataLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LoginDataLocalService.class.getName());

			if (invokableLocalService instanceof LoginDataLocalService) {
				_service = (LoginDataLocalService)invokableLocalService;
			}
			else {
				_service = new LoginDataLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LoginDataLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LoginDataLocalService service) {
	}

	private static LoginDataLocalService _service;
}
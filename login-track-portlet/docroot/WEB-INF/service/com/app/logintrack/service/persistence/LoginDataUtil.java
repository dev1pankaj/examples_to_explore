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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the login data service. This utility wraps {@link LoginDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pankaj Kathiriya
 * @see LoginDataPersistence
 * @see LoginDataPersistenceImpl
 * @generated
 */
public class LoginDataUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(LoginData loginData) {
		getPersistence().clearCache(loginData);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LoginData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LoginData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LoginData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LoginData update(LoginData loginData)
		throws SystemException {
		return getPersistence().update(loginData);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LoginData update(LoginData loginData,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(loginData, serviceContext);
	}

	/**
	* Returns all the login datas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching login datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.app.logintrack.model.LoginData> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the login datas where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.app.logintrack.model.impl.LoginDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of login datas
	* @param end the upper bound of the range of login datas (not inclusive)
	* @return the range of matching login datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.app.logintrack.model.LoginData> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the login datas where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.app.logintrack.model.impl.LoginDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of login datas
	* @param end the upper bound of the range of login datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching login datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.app.logintrack.model.LoginData> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first login data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching login data
	* @throws com.app.logintrack.NoSuchLoginDataException if a matching login data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.app.logintrack.model.LoginData findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.app.logintrack.NoSuchLoginDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first login data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching login data, or <code>null</code> if a matching login data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.app.logintrack.model.LoginData fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last login data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching login data
	* @throws com.app.logintrack.NoSuchLoginDataException if a matching login data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.app.logintrack.model.LoginData findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.app.logintrack.NoSuchLoginDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last login data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching login data, or <code>null</code> if a matching login data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.app.logintrack.model.LoginData fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the login datas before and after the current login data in the ordered set where userId = &#63;.
	*
	* @param loginDataPK the primary key of the current login data
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next login data
	* @throws com.app.logintrack.NoSuchLoginDataException if a login data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.app.logintrack.model.LoginData[] findByUserId_PrevAndNext(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.app.logintrack.NoSuchLoginDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_PrevAndNext(loginDataPK, userId,
			orderByComparator);
	}

	/**
	* Removes all the login datas where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of login datas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching login datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the login data in the entity cache if it is enabled.
	*
	* @param loginData the login data
	*/
	public static void cacheResult(com.app.logintrack.model.LoginData loginData) {
		getPersistence().cacheResult(loginData);
	}

	/**
	* Caches the login datas in the entity cache if it is enabled.
	*
	* @param loginDatas the login datas
	*/
	public static void cacheResult(
		java.util.List<com.app.logintrack.model.LoginData> loginDatas) {
		getPersistence().cacheResult(loginDatas);
	}

	/**
	* Creates a new login data with the primary key. Does not add the login data to the database.
	*
	* @param loginDataPK the primary key for the new login data
	* @return the new login data
	*/
	public static com.app.logintrack.model.LoginData create(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK) {
		return getPersistence().create(loginDataPK);
	}

	/**
	* Removes the login data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loginDataPK the primary key of the login data
	* @return the login data that was removed
	* @throws com.app.logintrack.NoSuchLoginDataException if a login data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.app.logintrack.model.LoginData remove(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK)
		throws com.app.logintrack.NoSuchLoginDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(loginDataPK);
	}

	public static com.app.logintrack.model.LoginData updateImpl(
		com.app.logintrack.model.LoginData loginData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(loginData);
	}

	/**
	* Returns the login data with the primary key or throws a {@link com.app.logintrack.NoSuchLoginDataException} if it could not be found.
	*
	* @param loginDataPK the primary key of the login data
	* @return the login data
	* @throws com.app.logintrack.NoSuchLoginDataException if a login data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.app.logintrack.model.LoginData findByPrimaryKey(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK)
		throws com.app.logintrack.NoSuchLoginDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(loginDataPK);
	}

	/**
	* Returns the login data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param loginDataPK the primary key of the login data
	* @return the login data, or <code>null</code> if a login data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.app.logintrack.model.LoginData fetchByPrimaryKey(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(loginDataPK);
	}

	/**
	* Returns all the login datas.
	*
	* @return the login datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.app.logintrack.model.LoginData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.app.logintrack.model.LoginData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the login datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.app.logintrack.model.impl.LoginDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of login datas
	* @param end the upper bound of the range of login datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of login datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.app.logintrack.model.LoginData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the login datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of login datas.
	*
	* @return the number of login datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LoginDataPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LoginDataPersistence)PortletBeanLocatorUtil.locate(com.app.logintrack.service.ClpSerializer.getServletContextName(),
					LoginDataPersistence.class.getName());

			ReferenceRegistry.registerReference(LoginDataUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LoginDataPersistence persistence) {
	}

	private static LoginDataPersistence _persistence;
}
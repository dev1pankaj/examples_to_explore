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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the login data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pankaj Kathiriya
 * @see LoginDataPersistenceImpl
 * @see LoginDataUtil
 * @generated
 */
public interface LoginDataPersistence extends BasePersistence<LoginData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LoginDataUtil} to access the login data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the login datas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching login datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.app.logintrack.model.LoginData> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.app.logintrack.model.LoginData> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.app.logintrack.model.LoginData> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first login data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching login data
	* @throws com.app.logintrack.NoSuchLoginDataException if a matching login data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.app.logintrack.model.LoginData findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.app.logintrack.NoSuchLoginDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first login data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching login data, or <code>null</code> if a matching login data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.app.logintrack.model.LoginData fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last login data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching login data
	* @throws com.app.logintrack.NoSuchLoginDataException if a matching login data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.app.logintrack.model.LoginData findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.app.logintrack.NoSuchLoginDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last login data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching login data, or <code>null</code> if a matching login data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.app.logintrack.model.LoginData fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.app.logintrack.model.LoginData[] findByUserId_PrevAndNext(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.app.logintrack.NoSuchLoginDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the login datas where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of login datas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching login datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the login data in the entity cache if it is enabled.
	*
	* @param loginData the login data
	*/
	public void cacheResult(com.app.logintrack.model.LoginData loginData);

	/**
	* Caches the login datas in the entity cache if it is enabled.
	*
	* @param loginDatas the login datas
	*/
	public void cacheResult(
		java.util.List<com.app.logintrack.model.LoginData> loginDatas);

	/**
	* Creates a new login data with the primary key. Does not add the login data to the database.
	*
	* @param loginDataPK the primary key for the new login data
	* @return the new login data
	*/
	public com.app.logintrack.model.LoginData create(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK);

	/**
	* Removes the login data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loginDataPK the primary key of the login data
	* @return the login data that was removed
	* @throws com.app.logintrack.NoSuchLoginDataException if a login data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.app.logintrack.model.LoginData remove(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK)
		throws com.app.logintrack.NoSuchLoginDataException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.app.logintrack.model.LoginData updateImpl(
		com.app.logintrack.model.LoginData loginData)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the login data with the primary key or throws a {@link com.app.logintrack.NoSuchLoginDataException} if it could not be found.
	*
	* @param loginDataPK the primary key of the login data
	* @return the login data
	* @throws com.app.logintrack.NoSuchLoginDataException if a login data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.app.logintrack.model.LoginData findByPrimaryKey(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK)
		throws com.app.logintrack.NoSuchLoginDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the login data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param loginDataPK the primary key of the login data
	* @return the login data, or <code>null</code> if a login data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.app.logintrack.model.LoginData fetchByPrimaryKey(
		com.app.logintrack.service.persistence.LoginDataPK loginDataPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the login datas.
	*
	* @return the login datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.app.logintrack.model.LoginData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.app.logintrack.model.LoginData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.app.logintrack.model.LoginData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the login datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of login datas.
	*
	* @return the number of login datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import com.app.logintrack.NoSuchLoginDataException;
import com.app.logintrack.model.LoginData;
import com.app.logintrack.model.impl.LoginDataImpl;
import com.app.logintrack.model.impl.LoginDataModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the login data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pankaj Kathiriya
 * @see LoginDataPersistence
 * @see LoginDataUtil
 * @generated
 */
public class LoginDataPersistenceImpl extends BasePersistenceImpl<LoginData>
	implements LoginDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LoginDataUtil} to access the login data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LoginDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LoginDataModelImpl.ENTITY_CACHE_ENABLED,
			LoginDataModelImpl.FINDER_CACHE_ENABLED, LoginDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LoginDataModelImpl.ENTITY_CACHE_ENABLED,
			LoginDataModelImpl.FINDER_CACHE_ENABLED, LoginDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LoginDataModelImpl.ENTITY_CACHE_ENABLED,
			LoginDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LoginDataModelImpl.ENTITY_CACHE_ENABLED,
			LoginDataModelImpl.FINDER_CACHE_ENABLED, LoginDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(LoginDataModelImpl.ENTITY_CACHE_ENABLED,
			LoginDataModelImpl.FINDER_CACHE_ENABLED, LoginDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			LoginDataModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LoginDataModelImpl.ENTITY_CACHE_ENABLED,
			LoginDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the login datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching login datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoginData> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LoginData> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<LoginData> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<LoginData> list = (List<LoginData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LoginData loginData : list) {
				if ((userId != loginData.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOGINDATA_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoginDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<LoginData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LoginData>(list);
				}
				else {
					list = (List<LoginData>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LoginData findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLoginDataException, SystemException {
		LoginData loginData = fetchByUserId_First(userId, orderByComparator);

		if (loginData != null) {
			return loginData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoginDataException(msg.toString());
	}

	/**
	 * Returns the first login data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching login data, or <code>null</code> if a matching login data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoginData fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LoginData> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LoginData findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLoginDataException, SystemException {
		LoginData loginData = fetchByUserId_Last(userId, orderByComparator);

		if (loginData != null) {
			return loginData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoginDataException(msg.toString());
	}

	/**
	 * Returns the last login data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching login data, or <code>null</code> if a matching login data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoginData fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<LoginData> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LoginData[] findByUserId_PrevAndNext(LoginDataPK loginDataPK,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchLoginDataException, SystemException {
		LoginData loginData = findByPrimaryKey(loginDataPK);

		Session session = null;

		try {
			session = openSession();

			LoginData[] array = new LoginDataImpl[3];

			array[0] = getByUserId_PrevAndNext(session, loginData, userId,
					orderByComparator, true);

			array[1] = loginData;

			array[2] = getByUserId_PrevAndNext(session, loginData, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LoginData getByUserId_PrevAndNext(Session session,
		LoginData loginData, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGINDATA_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LoginDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loginData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LoginData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the login datas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (LoginData loginData : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loginData);
		}
	}

	/**
	 * Returns the number of login datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching login datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGINDATA_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "loginData.id.userId = ?";

	public LoginDataPersistenceImpl() {
		setModelClass(LoginData.class);
	}

	/**
	 * Caches the login data in the entity cache if it is enabled.
	 *
	 * @param loginData the login data
	 */
	@Override
	public void cacheResult(LoginData loginData) {
		EntityCacheUtil.putResult(LoginDataModelImpl.ENTITY_CACHE_ENABLED,
			LoginDataImpl.class, loginData.getPrimaryKey(), loginData);

		loginData.resetOriginalValues();
	}

	/**
	 * Caches the login datas in the entity cache if it is enabled.
	 *
	 * @param loginDatas the login datas
	 */
	@Override
	public void cacheResult(List<LoginData> loginDatas) {
		for (LoginData loginData : loginDatas) {
			if (EntityCacheUtil.getResult(
						LoginDataModelImpl.ENTITY_CACHE_ENABLED,
						LoginDataImpl.class, loginData.getPrimaryKey()) == null) {
				cacheResult(loginData);
			}
			else {
				loginData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all login datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LoginDataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LoginDataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the login data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LoginData loginData) {
		EntityCacheUtil.removeResult(LoginDataModelImpl.ENTITY_CACHE_ENABLED,
			LoginDataImpl.class, loginData.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LoginData> loginDatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LoginData loginData : loginDatas) {
			EntityCacheUtil.removeResult(LoginDataModelImpl.ENTITY_CACHE_ENABLED,
				LoginDataImpl.class, loginData.getPrimaryKey());
		}
	}

	/**
	 * Creates a new login data with the primary key. Does not add the login data to the database.
	 *
	 * @param loginDataPK the primary key for the new login data
	 * @return the new login data
	 */
	@Override
	public LoginData create(LoginDataPK loginDataPK) {
		LoginData loginData = new LoginDataImpl();

		loginData.setNew(true);
		loginData.setPrimaryKey(loginDataPK);

		return loginData;
	}

	/**
	 * Removes the login data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loginDataPK the primary key of the login data
	 * @return the login data that was removed
	 * @throws com.app.logintrack.NoSuchLoginDataException if a login data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoginData remove(LoginDataPK loginDataPK)
		throws NoSuchLoginDataException, SystemException {
		return remove((Serializable)loginDataPK);
	}

	/**
	 * Removes the login data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the login data
	 * @return the login data that was removed
	 * @throws com.app.logintrack.NoSuchLoginDataException if a login data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoginData remove(Serializable primaryKey)
		throws NoSuchLoginDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LoginData loginData = (LoginData)session.get(LoginDataImpl.class,
					primaryKey);

			if (loginData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLoginDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(loginData);
		}
		catch (NoSuchLoginDataException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LoginData removeImpl(LoginData loginData)
		throws SystemException {
		loginData = toUnwrappedModel(loginData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(loginData)) {
				loginData = (LoginData)session.get(LoginDataImpl.class,
						loginData.getPrimaryKeyObj());
			}

			if (loginData != null) {
				session.delete(loginData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (loginData != null) {
			clearCache(loginData);
		}

		return loginData;
	}

	@Override
	public LoginData updateImpl(com.app.logintrack.model.LoginData loginData)
		throws SystemException {
		loginData = toUnwrappedModel(loginData);

		boolean isNew = loginData.isNew();

		LoginDataModelImpl loginDataModelImpl = (LoginDataModelImpl)loginData;

		Session session = null;

		try {
			session = openSession();

			if (loginData.isNew()) {
				session.save(loginData);

				loginData.setNew(false);
			}
			else {
				session.merge(loginData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LoginDataModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((loginDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loginDataModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { loginDataModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(LoginDataModelImpl.ENTITY_CACHE_ENABLED,
			LoginDataImpl.class, loginData.getPrimaryKey(), loginData);

		return loginData;
	}

	protected LoginData toUnwrappedModel(LoginData loginData) {
		if (loginData instanceof LoginDataImpl) {
			return loginData;
		}

		LoginDataImpl loginDataImpl = new LoginDataImpl();

		loginDataImpl.setNew(loginData.isNew());
		loginDataImpl.setPrimaryKey(loginData.getPrimaryKey());

		loginDataImpl.setUserId(loginData.getUserId());
		loginDataImpl.setLoginDate(loginData.getLoginDate());

		return loginDataImpl;
	}

	/**
	 * Returns the login data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the login data
	 * @return the login data
	 * @throws com.app.logintrack.NoSuchLoginDataException if a login data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoginData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLoginDataException, SystemException {
		LoginData loginData = fetchByPrimaryKey(primaryKey);

		if (loginData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLoginDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return loginData;
	}

	/**
	 * Returns the login data with the primary key or throws a {@link com.app.logintrack.NoSuchLoginDataException} if it could not be found.
	 *
	 * @param loginDataPK the primary key of the login data
	 * @return the login data
	 * @throws com.app.logintrack.NoSuchLoginDataException if a login data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoginData findByPrimaryKey(LoginDataPK loginDataPK)
		throws NoSuchLoginDataException, SystemException {
		return findByPrimaryKey((Serializable)loginDataPK);
	}

	/**
	 * Returns the login data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the login data
	 * @return the login data, or <code>null</code> if a login data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoginData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LoginData loginData = (LoginData)EntityCacheUtil.getResult(LoginDataModelImpl.ENTITY_CACHE_ENABLED,
				LoginDataImpl.class, primaryKey);

		if (loginData == _nullLoginData) {
			return null;
		}

		if (loginData == null) {
			Session session = null;

			try {
				session = openSession();

				loginData = (LoginData)session.get(LoginDataImpl.class,
						primaryKey);

				if (loginData != null) {
					cacheResult(loginData);
				}
				else {
					EntityCacheUtil.putResult(LoginDataModelImpl.ENTITY_CACHE_ENABLED,
						LoginDataImpl.class, primaryKey, _nullLoginData);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LoginDataModelImpl.ENTITY_CACHE_ENABLED,
					LoginDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return loginData;
	}

	/**
	 * Returns the login data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loginDataPK the primary key of the login data
	 * @return the login data, or <code>null</code> if a login data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoginData fetchByPrimaryKey(LoginDataPK loginDataPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)loginDataPK);
	}

	/**
	 * Returns all the login datas.
	 *
	 * @return the login datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoginData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LoginData> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<LoginData> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<LoginData> list = (List<LoginData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOGINDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOGINDATA;

				if (pagination) {
					sql = sql.concat(LoginDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LoginData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LoginData>(list);
				}
				else {
					list = (List<LoginData>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the login datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LoginData loginData : findAll()) {
			remove(loginData);
		}
	}

	/**
	 * Returns the number of login datas.
	 *
	 * @return the number of login datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOGINDATA);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the login data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.app.logintrack.model.LoginData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LoginData>> listenersList = new ArrayList<ModelListener<LoginData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LoginData>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LoginDataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LOGINDATA = "SELECT loginData FROM LoginData loginData";
	private static final String _SQL_SELECT_LOGINDATA_WHERE = "SELECT loginData FROM LoginData loginData WHERE ";
	private static final String _SQL_COUNT_LOGINDATA = "SELECT COUNT(loginData) FROM LoginData loginData";
	private static final String _SQL_COUNT_LOGINDATA_WHERE = "SELECT COUNT(loginData) FROM LoginData loginData WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "loginData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LoginData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LoginData exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LoginDataPersistenceImpl.class);
	private static LoginData _nullLoginData = new LoginDataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LoginData> toCacheModel() {
				return _nullLoginDataCacheModel;
			}
		};

	private static CacheModel<LoginData> _nullLoginDataCacheModel = new CacheModel<LoginData>() {
			@Override
			public LoginData toEntityModel() {
				return _nullLoginData;
			}
		};
}
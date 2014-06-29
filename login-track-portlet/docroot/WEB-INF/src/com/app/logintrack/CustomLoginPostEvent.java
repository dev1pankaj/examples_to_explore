package com.app.logintrack;

import com.app.logintrack.service.LoginDataLocalServiceUtil;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pankaj.kathiriya
 * CustomLoginPostEvent class for inserting LoginDate record
 * when user signs in to Portal
 */
public class CustomLoginPostEvent extends Action {

	private static final Log LOGGER=LogFactoryUtil.getLog(CustomLoginPostEvent.class);
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
			throws ActionException {

		long userId=Long.parseLong(request.getRemoteUser());
		try {
			LoginDataLocalServiceUtil.addLoginData(userId);
		} catch (SystemException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

}

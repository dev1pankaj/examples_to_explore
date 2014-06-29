package com.app.logintrack;

import com.app.logintrack.model.LoginData;
import com.app.logintrack.service.LoginDataLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author pankaj.kathiriya
 * 
 * LoginTrackPortlet is portlet class responsible for calling 
 * API for gettting LoginDate records and putting them in portletsession.
 *
 */
public class LoginTrackPortlet extends MVCPortlet {
	
	private static final Log LOGGER=LogFactoryUtil.getLog(LoginTrackPortlet.class);
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		ThemeDisplay themeDisplay=(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if(themeDisplay.isSignedIn() && Validator.isNull(request.getPortletSession().getAttribute("data"))){
				List<LoginData> loginList = LoginDataLocalServiceUtil.findByUserId(themeDisplay.getUserId());
				StringBuilder data=new StringBuilder();
				if(Validator.isNotNull(loginList)){
					Calendar date=Calendar.getInstance();
					for(LoginData loginData:loginList){
						date.setTime(loginData.getLoginDate());
						if(Validator.isNotNull(data)){
							data.append(StringPool.COMMA);
						}
						data.append("new Date(" + date.get(Calendar.YEAR) + StringPool.COMMA + date.get(Calendar.MONTH) + StringPool.COMMA + date.get(Calendar.DATE) + StringPool.CLOSE_PARENTHESIS);
					}
					request.getPortletSession().setAttribute("data", data);
					request.getPortletSession().setAttribute("loginCount", loginList.size());
				}
			}
		} catch (SystemException e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		super.render(request, response);
	}
}

package com.example.schedule;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;


public class Scheduler implements MessageListener {

	public void receive(Message arg0) throws MessageListenerException {
		/*
		 * SOME CODE TO BE RUN IN SCHEDULER AT INTERVAL
		 */
	}
}

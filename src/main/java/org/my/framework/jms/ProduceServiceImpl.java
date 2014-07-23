package org.my.framework.jms;

import javax.inject.Inject;
import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQTopic;
import org.apache.log4j.Logger;
import org.my.framework.util.Constant;
import org.my.framework.util.Des;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProduceServiceImpl implements ProduceService {

	private Logger logger = Logger.getLogger(this.getClass());

	private JmsTemplate jmsTemplate;

	@Inject
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void send(String destinationName, final byte[] message) {
		Destination destination = new ActiveMQTopic(destinationName);
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				BytesMessage bytesMessage = session.createBytesMessage();
				try {
					bytesMessage.writeBytes(Des.encrypt(message, Constant.KEY));
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
				return bytesMessage;
			}
		});
	}

}

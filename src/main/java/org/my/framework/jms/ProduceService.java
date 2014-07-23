package org.my.framework.jms;

public interface ProduceService {
	void send(String destinationName, byte[] data);
}

package pers.fxy.world.handler.eventhandler;

import java.util.HashMap;
import java.util.Map;

import pers.fxy.world.event.*;
import pers.fxy.world.handler.eventhandler.EventHandlerInterface.EventHandler;
import pers.fxy.world.request.Request;

public class EventHandlerBUS {
	private static EventHandlerBUS handler = new EventHandlerBUS();
	
	private static Map<Class<?>, EventHandler> handlerMapping = new HashMap<Class<?>, EventHandler>();
	
	private EventHandlerBUS() {}
	
	public static EventHandlerBUS get() { return handler; }
	
	public void receive(Event event) {
		EventHandler handler = handlerMapping.get(event.getTriggerRequest().getClass());
		if(handler != null) {
			handler.handle(event);
		}
	}
	
	public void registerHandler(Class<?> requestType, EventHandler handler) {
		handlerMapping.put(requestType, handler);
	}
}

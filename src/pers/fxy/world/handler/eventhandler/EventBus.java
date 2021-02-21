package pers.fxy.world.handler.eventhandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pers.fxy.world.event.*;

public class EventBus {
	private static EventBus handler = new EventBus();
	
	private static Map<Class<?>, IEventHandler> handlerMapping = new HashMap<Class<?>, IEventHandler>();
	
	private EventBus() {}
	
	public static EventBus get() { return handler; }
	
	public void receive(BaseEvent event) {		
		List<IEventHandler> handlers = EventHandlerManager.get().getHandlerList(event.getClass());
		if(handlers != null) {
			handlers.forEach(handler -> handler.handle(event));
		}
	}
	
	public void registerHandler(Class<?> eventType, IEventHandler handler) {
		handlerMapping.put(eventType, handler);
	}
}

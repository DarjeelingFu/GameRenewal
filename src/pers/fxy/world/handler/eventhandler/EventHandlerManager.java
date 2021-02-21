package pers.fxy.world.handler.eventhandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pers.fxy.world.event.BaseEvent;
import pers.fxy.world.handler.IHandler;
import pers.fxy.world.handler.IHandlerManager;

public class EventHandlerManager implements IHandlerManager {
	
	Map<Class<? extends BaseEvent>, List<IEventHandler>> handlerMapping = new ConcurrentHashMap<>();
	
	private EventHandlerManager() {}
	
	private static EventHandlerManager manager  = new EventHandlerManager();
	
	public static EventHandlerManager get() { return manager; }
	
	@Override
	public List<IEventHandler> getHandlerList(Class<?> type) {
		if(type != null) {
			return handlerMapping.get(type);
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void register(Class<?> eventType, IHandler handler) {
		List<IEventHandler> handlerList = null;
		if(eventType != null) {
			if(handlerMapping.get(eventType) == null) handlerMapping.put((Class<? extends BaseEvent>) eventType, new ArrayList<IEventHandler>()); 
			
			handlerList = handlerMapping.get(eventType);
			handlerList.add((IEventHandler) handler);
			// handlerList.sort((h1, h2) -> h1.getPriority().getIndex() - h2.getPriority().getIndex());
		} else {
			// throws an exception
		}
	}
	
}

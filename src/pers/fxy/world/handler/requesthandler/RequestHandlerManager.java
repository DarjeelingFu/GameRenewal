package pers.fxy.world.handler.requesthandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pers.fxy.world.handler.IHandler;
import pers.fxy.world.handler.IHandlerManager;
import pers.fxy.world.request.IRequest;

public class RequestHandlerManager implements IHandlerManager {
	
	Map<Class<? extends IRequest>, List<IRequestHandler>> handlerMapping = new ConcurrentHashMap<>();
	
	private RequestHandlerManager() {}
	
	private static RequestHandlerManager manager  = new RequestHandlerManager();
	
	public static RequestHandlerManager get() { return manager; }
	
	@Override
	public List<IRequestHandler> getHandlerList(Class<?> type) {
		if(type != null) {
			return handlerMapping.get(type);
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void register(Class<?> eventType, IHandler handler) {
		List<IRequestHandler> handlerList = null;
		if(eventType != null) {
			if(handlerMapping.get(eventType) == null) handlerMapping.put((Class<? extends IRequest>) eventType, new ArrayList<IRequestHandler>()); 
			
			handlerList = handlerMapping.get(eventType);
			handlerList.add((IRequestHandler) handler);
			// handlerList.sort((h1, h2) -> h1.getPriority().getIndex() - h2.getPriority().getIndex());
		} else {
			// throws an exception
		}
	}
	
}
package pers.fxy.world.handler.requesthandler;

import java.util.HashMap;
import java.util.Map;

import pers.fxy.world.event.Event;
import pers.fxy.world.handler.eventhandler.EventHandlerBUS;
import pers.fxy.world.handler.eventhandler.EventHandlerInterface.EventHandler;
import pers.fxy.world.handler.requesthandler.RequestHandlerInterface.*;
import pers.fxy.world.request.*;
import pers.fxy.world.request.TradeRequest.TradeType;

public class RequestHandlerBUS {
	private static RequestHandlerBUS handler = new RequestHandlerBUS();
	
	private static Map<Class<?>, RequestHandler> handlerMapping = new HashMap<Class<?>, RequestHandler>();
	
	private RequestHandlerBUS() {}
	
	public static RequestHandlerBUS get() { return handler; }
	
	public void registerHandler(Class<?> requestClass, RequestHandler handler) {
		handlerMapping.put(requestClass, handler);
	}
	
	public void receive(Request request) {
		RequestHandler handler = handlerMapping.get(request.getClass());
		if(handler != null) {
			handler.handle(request);
		}
	}
	
}

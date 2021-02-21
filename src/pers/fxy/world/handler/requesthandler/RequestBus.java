package pers.fxy.world.handler.requesthandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import pers.fxy.world.request.*;

public class RequestBus {
	private static RequestBus handler = new RequestBus();
	
	private static AtomicReference<RequestBus> rHandler = new AtomicReference<>(handler);
	
	@Deprecated
	private static Map<Class<?>, IRequestHandler> handlerMapping = new HashMap<Class<?>, IRequestHandler>();
	
	private RequestBus() {}
	
	public static RequestBus get() { return handler; }
	
	public static AtomicReference<RequestBus> getR() { return rHandler; }
	
	@Deprecated
	public void registerHandler(Class<?> requestClass, IRequestHandler handler) {
		handlerMapping.put(requestClass, handler);
	}
	
	public void receive(IRequest request) {
		List<IRequestHandler> handlers = RequestHandlerManager.get().getHandlerList(request.getClass());
		if(handlers != null) {
			synchronized(this) { handlers.forEach(handler -> handler.handle(request)); }
		}
	}
	
}

package pers.fxy.world.handler.requesthandler;

import pers.fxy.world.event.BaseEvent.EventState;
import pers.fxy.world.handler.IHandler;
import pers.fxy.world.handler.eventhandler.EventBus;
import pers.fxy.world.request.*;

public interface IRequestHandler extends IHandler {
	void handleRequest(IRequest request);
	
	default void handle(IRequest request) {
		handleRequest(request);
		andThen(request);
	}
	
	default void andThen(IRequest request) {
		EventBus.get().receive(request.buildEvent(EventState.SUCCESSFUL));
	}
}

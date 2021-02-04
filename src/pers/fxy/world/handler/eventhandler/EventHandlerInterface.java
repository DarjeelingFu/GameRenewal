package pers.fxy.world.handler.eventhandler;

import pers.fxy.world.event.*;

public class EventHandlerInterface {
	public interface EventHandler{
		void handle(Event event);
	}
}

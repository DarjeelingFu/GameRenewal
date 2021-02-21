package pers.fxy.world.handler.eventhandler;

import pers.fxy.world.event.*;
import pers.fxy.world.handler.IHandler;

public interface IEventHandler extends IHandler {
	void handle(BaseEvent event);
}

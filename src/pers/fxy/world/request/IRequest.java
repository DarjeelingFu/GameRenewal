package pers.fxy.world.request;

import pers.fxy.world.GameObject;
import pers.fxy.world.event.BaseEvent;
import pers.fxy.world.event.BaseEvent.EventState;

public interface IRequest {
	
	public GameObject getSource();
	
	public BaseEvent buildEvent(EventState state);
}

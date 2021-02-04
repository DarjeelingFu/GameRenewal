package pers.fxy.world.request;

import pers.fxy.world.GameObject;
import pers.fxy.world.event.Event;
import pers.fxy.world.event.Event.EventState;

public abstract class Request {
	
	private GameObject source;
	
	public Request(GameObject source) { this.source = source; }
	
	public GameObject getSource() { return source; }
	
	public Event buildEvent() {
		return new Event(this, EventState.SUCCESSFUL);
	}
}

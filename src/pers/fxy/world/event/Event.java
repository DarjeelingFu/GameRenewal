package pers.fxy.world.event;

import pers.fxy.world.request.Request;

public class Event {
	public static enum EventState{
		SUCCESSFUL,
		FAILED
	}
	
	private EventState state;
	
	private Request request;
	
	public Event(Request triggerRequest, EventState state) {
		request = triggerRequest;
		this.state = state;
	}
	
	public EventState getState() { return state; }
	
	public Request getTriggerRequest() { return request; }
}

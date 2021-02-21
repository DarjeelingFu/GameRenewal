package pers.fxy.world.event;

import pers.fxy.world.GameObject;
import pers.fxy.world.request.IRequest;

public class BaseEvent {
	public static enum EventState{
		SUCCESSFUL,
		FAILED,
		REFUSED
	}
	
	private EventState state;
	
	private Object source;
	
	private BaseEvent(EventState state) {
		this.state = state;
	}
	
	public BaseEvent(IRequest triggerRequest, EventState state) {
		this(state);
		this.source = triggerRequest;
	}
	
	public BaseEvent(GameObject source, EventState state) {
		this(state);
		this.source = source;
	}
	
	public BaseEvent(Object source) {
		this(EventState.SUCCESSFUL);
		this.source = source;
	}
	
	public EventState getState() { return state; }
	
	public Object getSource() { return source; }
	
	public IRequest getTriggerRequest() {
		if(source instanceof IRequest) return (IRequest) source; else return null;
	}
}

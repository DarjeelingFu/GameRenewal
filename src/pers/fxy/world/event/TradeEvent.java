package pers.fxy.world.event;

import pers.fxy.world.annotation.AGameEvent;
import pers.fxy.world.request.*;

@AGameEvent
public class TradeEvent extends BaseEvent {
	
	public TradeEvent(TradeRequest request, EventState state) {
		super(request, state);
	}
	
}

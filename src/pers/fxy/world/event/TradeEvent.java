package pers.fxy.world.event;

import pers.fxy.world.request.*;

public class TradeEvent extends Event {
	
	public TradeEvent(TradeRequest request, EventState state) {
		super(request, state);
	}
	
}

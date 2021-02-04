package pers.fxy.world.request;

import pers.fxy.world.*;
import pers.fxy.world.event.Event;
import pers.fxy.world.event.Event.EventState;
import pers.fxy.world.event.TradeEvent;

public class TradeRequest extends Request{
	public enum TradeType{
		BUY,
		SOLD
	}
	
	private GameObject tradeTarget;
	private ItemSet goods;
	private TradeType tradeType;
	
	public TradeRequest(GameObject source, GameObject tradeTarget, ItemSet goods, TradeType tradeType) {
		super(source);
		this.tradeTarget = tradeTarget;
		this.goods = goods;
		this.tradeType = tradeType;
	}
	
	public TradeType getTradeType() { return tradeType; }
	
	public GameObject getTradeTarget() { return tradeTarget; }
	
	public ItemSet getGoods() { return goods; }

	@Override
	public Event buildEvent() {
		return new TradeEvent(this, EventState.SUCCESSFUL);
	}
}

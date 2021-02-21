package pers.fxy.world.request;

import pers.fxy.world.*;
import pers.fxy.world.annotation.AGameRequest;
import pers.fxy.world.event.BaseEvent;
import pers.fxy.world.event.BaseEvent.EventState;
import pers.fxy.world.event.TradeEvent;

@AGameRequest
public class TradeRequest implements IRequest{
	public enum TradeType{
		BUY,
		SOLD
	}
	
	private GameObject source;
	private GameObject tradeTarget;
	private ItemSet goodsOfSource;
	private ItemSet goodsOfTarget;
	private TradeType tradeType;
	
	public TradeRequest(GameObject source, GameObject tradeTarget, ItemSet goodsOfSource, ItemSet goodsOfTarget, TradeType tradeType) {
		this.source = source;
		this.tradeTarget = tradeTarget;
		this.goodsOfSource = goodsOfSource;
		this.goodsOfTarget = goodsOfTarget;
		this.tradeType = tradeType;
	}

	@Override
	public BaseEvent buildEvent(EventState state) {
		return new TradeEvent(this, state);
	}

	@Override
	public GameObject getSource() {
		return source;
	}
	
	public TradeType getTradeType() { return tradeType; }
	
	public GameObject getTradeTarget() { return tradeTarget; }
	
	/**
	 * 
	 * @return array of goods to be traded. Two at most currently. <code>[0]</code> represents goods of <b>source</b>
	 * and <code>[1]</code> represents goods of <b>target</b>.
	 */
	public ItemSet[] getGoods() {
		ItemSet[] goods = {this.goodsOfSource, this.goodsOfTarget};
		return goods;
	}
}

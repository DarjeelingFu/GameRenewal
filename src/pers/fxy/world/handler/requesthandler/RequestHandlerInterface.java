package pers.fxy.world.handler.requesthandler;

import pers.fxy.world.handler.eventhandler.EventHandlerBUS;
import pers.fxy.world.request.*;

public class RequestHandlerInterface {
	public interface RequestHandler{
		void handleRequest(Request request);
		
		default void handle(Request request) {
			handleRequest(request);
			EventHandlerBUS.get().receive(request.buildEvent());
		}
	}
	
	public interface TradeRequestHandler extends RequestHandler{		
		void onBuy(TradeRequest request);
		
		void onSold(TradeRequest request);
	}
}

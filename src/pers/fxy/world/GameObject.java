package pers.fxy.world;

import pers.fxy.world.handler.eventhandler.*;
import pers.fxy.world.handler.requesthandler.*;
import pers.fxy.world.handler.requesthandler.RequestHandlerInterface.TradeRequestHandler;
import pers.fxy.world.request.*;
import pers.fxy.world.request.TradeRequest.TradeType;

public class GameObject {
	public static interface SenceEnity{
		public void moveTo(Scene scene);
	}
	
	public static interface ObjectSet{
		void addOne();
		
		void add(int num);
		
		void removeOne();
		
		void remove(int num);
		
		int getNum();
		
		void setNum(int num);
	}
	
	public static interface Information{
		void present();
	}
	
	// for test
	public static void main(String[] args) throws Exception {
		
		RequestHandlerBUS.get().registerHandler(TradeRequest.class, new TradeRequestHandler() {
			@Override
			public void handleRequest(Request request) {
				TradeRequest re = (TradeRequest) request;
				switch(re.getTradeType()) {
				case BUY:
					onBuy(re);
					break;
				case SOLD:
					onSold(re);
					break;
				}
			}
			
			@Override
			public void onBuy(TradeRequest request) {
				System.out.println("Buy");
			}

			@Override
			public void onSold(TradeRequest request) {
				System.out.println("Sold");
			}
		});
		
		EventHandlerBUS.get().registerHandler(TradeRequest.class, (event)->{
			System.out.println("trade event");
		});
		
		RequestHandlerBUS.get().receive(new TradeRequest(null, null, null, TradeType.BUY));
		Thread.sleep(2000);
		RequestHandlerBUS.get().receive(new TradeRequest(null, null, null, TradeType.SOLD));
		
	}
	
}

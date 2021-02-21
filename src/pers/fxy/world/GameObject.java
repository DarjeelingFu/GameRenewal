package pers.fxy.world;


import pers.fxy.world.event.BaseEvent;
import pers.fxy.world.event.TradeEvent;
import pers.fxy.world.handler.eventhandler.*;
import pers.fxy.world.handler.requesthandler.*;
import pers.fxy.world.handler.requesthandler.IRequestHandler;
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
		
		// registering request handlers
		RequestHandlerManager.get().register(TradeRequest.class, new IRequestHandler() {
			@Override
			public void handleRequest(IRequest request) {
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
			
			public void onBuy(TradeRequest request) {
				System.out.println("Buy");
			}

			public void onSold(TradeRequest request) {
				System.out.println("Sold");
			}
			
//			@Override
//			public void andThen(IRequest request) {}
		});
		
		RequestHandlerManager.get().register(TradeRequest.class, new IRequestHandler() {

			@Override
			public void handleRequest(IRequest request) {
				System.out.println("and whatever it's a trade request");
			}
			
			@Override
			public void andThen(IRequest request) {}
			
		});
		
		// registering event handlers
		EventHandlerManager.get().register(TradeEvent.class, new IEventHandler() {

			@Override
			public Priority getPriority() {
				return Priority.HIGHEST;
			}

			@Override
			public void handle(BaseEvent event) {
				System.out.println("trade event handler1");
			}
			
		});
		
		EventHandlerManager.get().register(TradeEvent.class, new IEventHandler() {

			@Override
			public Priority getPriority() {
				return Priority.HIGHEST;
			}

			@Override
			public void handle(BaseEvent event) {
				System.out.println("trade event handler2");
			}
			
		});
		
		// sending messages
		new Thread(() -> { RequestBus.get().receive(new TradeRequest(null, null, null, null, TradeType.BUY)); }).start();
		
		new Thread(() -> { RequestBus.get().receive(new TradeRequest(null, null, null, null, TradeType.SOLD)); }).start();
		
		new Thread(() -> { RequestBus.get().receive(new TradeRequest(null, null, null, null, TradeType.BUY)); }).start();
		
		new Thread(() -> { RequestBus.get().receive(new TradeRequest(null, null, null, null, TradeType.SOLD)); }).start();
		
	}
	
}

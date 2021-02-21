package pers.fxy.world.handler;

import java.util.List;

public interface IHandlerManager {
	List<? extends IHandler> getHandlerList(Class<?> type);
	
	void register(Class<?> type, IHandler handler);
}

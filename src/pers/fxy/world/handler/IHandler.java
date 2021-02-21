package pers.fxy.world.handler;

public interface IHandler {
	enum Priority {
		HIGHEST("first", 0),
		HIGH("second", 1),
		NORMAL("third",2),
		LOW("forth", 3);
		
		private int index;
		private String name;
		
		private Priority(int index) {
			this.index = index;
		}
		
		private Priority(String name, int index) {
			this(index);
			this.name = name;
		}
		
		public int getIndex() {
			return this.index;
		}
	}
	
	default Priority getPriority() {
		return Priority.NORMAL;
	}
}

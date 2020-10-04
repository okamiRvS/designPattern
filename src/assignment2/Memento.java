package assignment2;

import java.util.ArrayList;

// we implement ConcreteMemento as a nested class
class Memento implements MementoInterface{
	private ArrayList<Integer> shopIncomes;
	private ArrayList<Integer> onlineIncomes;
	private boolean state;

	public Memento(ArrayList<Integer> shopIncomes, ArrayList<Integer> onlineIncomes, boolean state) {
		this.shopIncomes = shopIncomes;
		this.onlineIncomes = onlineIncomes;
		this.state = state;
	}

	@Override
	public ArrayList<Integer> getShopIncomes() {
		return this.shopIncomes;
	}
	
	@Override
	public ArrayList<Integer> getOnlineIncomes() {
		return this.onlineIncomes;
	}
	
	@Override
	public boolean getState() {
		return this.state;
	}
}
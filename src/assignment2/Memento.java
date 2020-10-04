package assignment2;

import java.util.ArrayList;


class Memento implements MementoInterface{
	private ArrayList<Integer> shopIncomes;
	private ArrayList<Integer> onlineIncomes;

	public Memento(ArrayList<Integer> shopIncomes, ArrayList<Integer> onlineIncomes) {
		this.shopIncomes = shopIncomes;
		this.onlineIncomes = onlineIncomes;
	}

	@Override
	public ArrayList<Integer> getShopIncomes() {
		return this.shopIncomes;
	}
	
	@Override
	public ArrayList<Integer> getOnlineIncomes() {
		return this.onlineIncomes;
	}
}
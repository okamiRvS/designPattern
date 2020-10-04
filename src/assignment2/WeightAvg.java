package assignment2;

import java.util.ArrayList;

public class WeightAvg implements AvgStrategy{

	@Override
	public double computeAvg(ArrayList<Integer> shopIncomes, ArrayList<Integer> onlineIncomes) {
		return computeAvg(shopIncomes, onlineIncomes, 0.5); // default
	}
	
	public double computeAvg(ArrayList<Integer> shopIncomes, ArrayList<Integer> onlineIncomes, double c) {
		double sizeShopIncomes = shopIncomes.size();
		double sizeOnlineIncomes = onlineIncomes.size();
		double sumShop = 0, avgShop;
		double sumOnline = 0, avgOnline;
		
		for (int i = 0; i < sizeShopIncomes; i++) {
			sumShop += shopIncomes.get(i);
		}
		avgShop = sumShop / sizeShopIncomes;

		for (int i = 0; i < sizeOnlineIncomes; i++) {
			sumOnline += onlineIncomes.get(i);
		}
		avgOnline = sumOnline / sizeOnlineIncomes;

		return c * avgShop + (1 - c) * avgOnline;
	}	
}

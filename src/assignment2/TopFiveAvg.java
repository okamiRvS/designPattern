package assignment2;

import java.util.ArrayList;

/**
 * @return Another possible way is by computing the average by first computing the average
 *  of the last five values (or less values if there are less the five values) of each type
 *  of incomes, and then averaging the two results.
 */
public class TopFiveAvg implements AvgStrategy{

	@Override
	public double computeAvg(ArrayList<Integer> shopIncomes, ArrayList<Integer> onlineIncomes) {
		double sizeShopIncomes = shopIncomes.size();
		double sizeOnlineIncomes = onlineIncomes.size();
		double sumShop = 0, avgShop;
		double sumOnline = 0, avgOnline;
		
		if (sizeShopIncomes >= 5) {
			for (int i = (int) sizeShopIncomes - 5; i < sizeShopIncomes; i++) {
				sumShop += shopIncomes.get(i);
			}
			avgShop = sumShop / 5;
		} else {
			for (int i = 0; i < sizeShopIncomes; i++) {
				sumShop += shopIncomes.get(i);
			}
			avgShop = sumShop / sizeShopIncomes;
		}

		if (sizeOnlineIncomes >= 5) {
			for (int i = (int) sizeOnlineIncomes - 5; i < sizeOnlineIncomes; i++) {
				sumOnline += onlineIncomes.get(i);
			}
			avgOnline = sumOnline / 5;
		} else {
			for (int i = 0; i < sizeOnlineIncomes; i++) {
				sumOnline += shopIncomes.get(i);
			}
			avgOnline = sumShop / sizeOnlineIncomes;
		}
		return (avgShop + avgOnline) / 2;
	}

}

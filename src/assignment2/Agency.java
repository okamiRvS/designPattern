package assignment2;

import java.util.ArrayList;

/**
 * Represents an agency and their incomes. Stores the name, shop incomes and
 * online incomes.
 *
 */
public class Agency {

	private String name; // Agency identifier, a name
	private ArrayList<Integer> shopIncomes; // incomes from the shop
	private ArrayList<Integer> onlineIncomes; // incomes from the online e-commerce app
	private boolean change = false;	// flag to use only top five incomes
	private Memento backup; // Memento class


	/**
	 * Constructs the agency from their name
	 * 
	 * @param name a name that identifies the agency.
	 */
	public Agency(String name) {
		this.name = name;
		shopIncomes = new ArrayList<Integer>();
		onlineIncomes = new ArrayList<Integer>();
	}

	/**
	 * @return the agency's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds incomes to the collection of incomes from the shop.
	 * 
	 * @param incomes the incomes to add
	 */
	public void addShopIncomes(int[] incomes) {
		for (int i = 0; i < incomes.length; ++i) {
			shopIncomes.add(incomes[i]);
		}
	}

	/**
	 * Adds incomes to the collection of online incomes.
	 * 
	 * @param incomes the income to add
	 */
	public void addOnlineIncomes(int[] incomes) {
		for (int i = 0; i < incomes.length; ++i) {
			onlineIncomes.add(incomes[i]);
		}
	}

	/**
	 * Get Average of shop and online incomes
	 * 
	 * @return incomes with different strategies
	 */
	public double getAverage() {
		if (change) {
			TopFiveAvg avg = new TopFiveAvg();
			return avg.computeAvg(shopIncomes, onlineIncomes);
		} else {
			WeightAvg avg = new WeightAvg(); 
			return avg.computeAvg(shopIncomes, onlineIncomes);
		}
	}

	/**
	 * @param false sets default strategy of average, true sets top five average strategy  
	 */
	public void setUseOnlyTopFiveIncomes(boolean b) {
		change = b;
	}

	/**
	 * Take frame of Incomes  
	 */
	public void save() {
		ArrayList<Integer> copiedShopIncomes = new ArrayList<Integer>(shopIncomes);
		ArrayList<Integer> copiedOnlineIncomes = new ArrayList<Integer>(onlineIncomes);
		this.backup = new Memento(copiedShopIncomes, copiedOnlineIncomes, change);
	}

	/**
	 * Restore frame of Incomes  
	 */
	public void restore() {
		this.shopIncomes = backup.getShopIncomes();
		this.onlineIncomes = backup.getOnlineIncomes();	
	}	
}

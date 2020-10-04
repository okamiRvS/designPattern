package assignment2;

import java.util.*;

/**
 * Represents the headquarters of the agencies.
 *
 */
public class Headquarters implements Containter {

	private String name; // Headquarters identifier, a name
	private List<Agency> theAgencies; // List of controlled agencies
	private static Headquarters uniqueInstance;

	/**
	 * Constructs the headquarters from its name
	 * 
	 * @param name Headquarters identifier, a name
	 * @throws SingletonException
	 */
	private Headquarters(String name) throws Exception {
		if (uniqueInstance != null) {
			throw new Exception("SingletonException message");
		} else {
			this.name = name;
			theAgencies = new ArrayList<Agency>();
		}
	}

	/**
	 * Get Instance of Headquarters
	 * 
	 * @throws SingletonException
	 */
	public static Headquarters getInstance() {
		if (uniqueInstance == null) {
			try {
				uniqueInstance = new Headquarters("Test");
			} catch (Exception x) {
				System.out.println("SingletonException");
			}
		}
		return uniqueInstance;

	}

	/**
	 * @return the headquarters name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds an Agency to the list.
	 * 
	 * @param agency the Agency to add
	 */
	public void addAgency(Agency agency) {
		theAgencies.add(agency);
	}

	/**
	 * Do Backups of the incomes Agency
	 * 
	 */
	public void doBackups() {
		for (int i = 0; i < theAgencies.size(); i++) {
			theAgencies.get(i).save();
		}
	}

	/**
	 * Restore Backups of the incomes Agency
	 * 
	 * @param string of the Agency to restore
	 */
	public void restoreBackup(String string) {
		for (int i = 0; i < theAgencies.size(); i++) {
			if (theAgencies.get(i).getName().equalsIgnoreCase(string)) {
				theAgencies.get(i).restore();
				break;
			}
		}
	}

	/**
	 * @return the Iterator
	 */
	public AvgProvider getAvgProvider() {
		return new Iterator();
	}

	public class Iterator implements AvgProvider {
		private int index;
		
		@Override
		public double getNextAvg() {
			return theAgencies.get(index++).getAverage();
		}

		@Override
		public boolean done() {
			if (index >= theAgencies.size()) {
				return true;
			}
			return false;
		}
	}
}

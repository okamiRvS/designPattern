package assignment2;

import java.util.*;

/**
 * Represents the headquarters of the agencies.
 *
 */
public class Headquarters {

	private String name; // Headquarters identifier, a name
	private List<Agency> theAgencies; // List of controlled agencies
	private static Headquarters uniqueInstance;

	/**
	 * Constructs the headquarters from its name
	 * @param name Headquarters identifier, a name
	 */
	private Headquarters(String name) {
		if (uniqueInstance != null) {
			System.out.println("SingletonException");
		} else {
			this.name = name;
			theAgencies = new ArrayList<Agency>();
		}
	}

	public static Headquarters getInstance() {
		if (uniqueInstance == null) {
			try {
				uniqueInstance = new Headquarters("Test");
			} catch (Exception x) {
				/* never */
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

}

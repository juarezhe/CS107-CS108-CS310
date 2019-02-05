
public class Move {
	private String name, type;
	private int power, energy, duration;

	public Move(String name, String type, int power, int energy) {
		this.name = name;
		this.type = type;
		this.power = power;
		this.energy = energy;
		this.duration = 0;
	}

	public Move(String name, String type, int power, int energy, int duration) {
		this.name = name;
		this.type = type;
		this.power = power;
		this.energy = energy;
		this.duration = duration;
	}

	public String toString() {
		String stringToReturn = this.name + "," + this.type + "," + this.power + "," + this.energy;
		stringToReturn = this.duration == 0 ? stringToReturn : stringToReturn + "," + this.duration;

		return stringToReturn;
	}
}
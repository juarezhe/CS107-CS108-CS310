
public class Move {
	private String mName, mType;
	private int mPower, mEnergy, mDuration;
	
	public Move (String name, String type, int power, int energy, int duration) {
		this.mName = name;
		this.mType = type;
		this.mPower = power;
		this.mEnergy = energy;
		this.mDuration = duration;
	}
	
	public String toString() {
		return this.mName + "," + this.mType + "," + this.mPower + "," + this.mEnergy + "," + this.mDuration;
	}
}

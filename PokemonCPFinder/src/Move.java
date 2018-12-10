
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
		// writer.println("name,form,type1,type2,hp,atk,def,cp,level,hpIV,atkIV,defIV,quick,type,pwr,nrg,dur,charge,type,pwr,nrg,dur");
		return this.mName + "," + this.mType + "," + this.mPower + "," + this.mEnergy + "," + this.mDuration;
	}
}

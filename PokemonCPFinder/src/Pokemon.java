
public class Pokemon {
	String mName, mForm, mType1, mType2;
	int mHP, mAtk, mDef;
	Move mQuickMove;
	Move mChargeMove;
	
	public Pokemon(String name, String form, String type1, String type2, int hp, int atk, int def) {
		this.mName = name;
		this.mForm = form;
		this.mType1 = type1;
		this.mType2 = type2;
		this.mHP = hp;
		this.mAtk = atk;
		this.mDef = def;
	}
	
	public String toString() {
		return "[" + this.mName + ", " + this.mForm + ", " + this.mType1 + ", " + this.mType2 + ", " + this.mHP + ", " + this.mAtk + ", " + this.mDef + "]";
	}
}

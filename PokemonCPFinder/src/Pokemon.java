
public class Pokemon {
	String name, form, type1, type2;
	int health, attack, defense, minLevel;
	Move quickMove, chargeMove1, chargeMove2;

	public Pokemon(String name, String form, String type1, String type2, int hp, int atk, int def, int minLevel) {
		this.name = name;
		this.form = form;
		this.type1 = type1;
		this.type2 = type2;
		this.health = hp;
		this.attack = atk;
		this.defense = def;
		this.minLevel = minLevel;
	}

	public Pokemon(String name, String form, String type1, String type2, int health, int attack, int defense,
			int minLevel, Move quickMove, Move chargeMove1) {
		this.name = name;
		this.form = form;
		this.type1 = type1;
		this.type2 = type2;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.minLevel = minLevel;
		this.quickMove = quickMove;
		this.chargeMove1 = chargeMove1;
		this.chargeMove2 = MainActivity.chargeMoveList.get(0);
	}

	public Pokemon(String name, String form, String type1, String type2, int health, int attack, int defense,
			int minLevel, Move quickMove, Move chargeMove1, Move chargeMove2) {
		this.name = name;
		this.form = form;
		this.type1 = type1;
		this.type2 = type2;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.minLevel = minLevel;
		this.quickMove = quickMove;
		this.chargeMove1 = chargeMove1;
		this.chargeMove2 = chargeMove2;
	}

	public String toString() {
		return this.name + "," + this.form + "," + this.type1 + "," + this.type2 + "," + this.health + "," + this.attack
				+ "," + this.defense;
	}
}

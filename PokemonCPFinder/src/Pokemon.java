
public class Pokemon {
	String name, form, type1, type2;
	int health, attack, defense;
	Move quickMove, chargeMove;
	
	public Pokemon(String name, String form, String type1, String type2, int hp, int atk, int def, Move quickMove, Move chargeMove) {
		this.name = name;
		this.form = form;
		this.type1 = type1;
		this.type2 = type2;
		this.health = hp;
		this.attack = atk;
		this.defense = def;
		this.quickMove = quickMove;
		this.chargeMove = chargeMove;
	}
	
	public String toString() {
		return "[" + this.name + ", " + this.form + ", " + this.type1 + ", " + this.type2 + ", " + this.health + ", " + this.attack + ", " + this.defense + "]";
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity {
	static ArrayList<Move> quickMoveList = new ArrayList<Move>(64);
	static ArrayList<Move> chargeMoveList = new ArrayList<Move>(133);
	static ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>(2148);
	static PrintWriter writer;
	static final int CP_MAX = 1500;
	static final int LEVEL_MAX = 40;
	static final String FILE_PATH = "C:\\Users\\djuarez\\Desktop\\";
	static final double[] CPM_LIST = { 0, 0, 0.094, 0.135137432, 0.16639787, 0.192650919, 0.21573247, 0.236572661,
			0.25572005, 0.273530381, 0.29024988, 0.306057377, 0.3210876, 0.335445036, 0.34921268, 0.362457751,
			0.37523559, 0.387592406, 0.39956728, 0.411193551, 0.42250001, 0.432926419, 0.44310755, 0.4530599578,
			0.46279839, 0.472336083, 0.48168495, 0.4908558, 0.49985844, 0.508701765, 0.51739395, 0.525942511,
			0.53435433, 0.542635767, 0.55079269, 0.558830576, 0.56675452, 0.574569153, 0.58227891, 0.589887917,
			0.59740001, 0.604818814, 0.61215729, 0.619399365, 0.62656713, 0.633644533, 0.64065295, 0.647576426,
			0.65443563, 0.661214806, 0.667934, 0.674577537, 0.68116492, 0.687680648, 0.69414365, 0.700538673,
			0.70688421, 0.713164996, 0.71939909, 0.725571552, 0.7317, 0.734741009, 0.73776948, 0.740785574, 0.74378943,
			0.746781211, 0.74976104, 0.752729087, 0.75568551, 0.758630378, 0.76156384, 0.764486065, 0.76739717,
			0.770297266, 0.7731865, 0.776064962, 0.77893275, 0.781790055, 0.78463697, 0.787473578, 0.79030001 };

	public static void main(String[] args) {
		buildQuickMoveList();
		buildChargeMoveList();
		buildList();

		try {
			writer = new PrintWriter(FILE_PATH + CP_MAX + "-" + LEVEL_MAX + ".txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("name,form,type1,type2,hp,atk,def,hpIV,atkIV,defIV,level,cp,quick,type"
				+ ",pwr,nrg,dur,charge1,type,pwr,nrg,charge2,type,pwr,nrg,cpm");

		for (int n = 0; n < pokemonList.size(); n++) {
			Pokemon curr = pokemonList.get(n);
			int hpIV = 15;
			int atkIV = 0;
			int defIV = 15;
			int level;
			double cpm = 1;
			int cp = 9999;

			for (level = LEVEL_MAX * 2; level > curr.minLevel * 2; level--) {
				cpm = CPM_LIST[level];
				cp = getCP(cpm, curr.health, hpIV, curr.attack, atkIV, curr.defense, defIV);
				if (cp <= CP_MAX)
					break;
			}
			if (cp < CP_MAX) {
				while (atkIV < 15) {
					atkIV++;
					cpm = CPM_LIST[level];
					cp = getCP(cpm, curr.health, hpIV, curr.attack, atkIV, curr.defense, defIV);
					if (cp > CP_MAX) {
						atkIV--;
						cpm = CPM_LIST[level];
						cp = getCP(cpm, curr.health, hpIV, curr.attack, atkIV, curr.defense, defIV);
						break;
					}
				}
			}
			if (cp > CP_MAX) {
				while (atkIV >= 5) {
					atkIV--;
					cpm = CPM_LIST[level];
					cp = getCP(cpm, curr.health, hpIV, curr.attack, atkIV, curr.defense, defIV);
					if (cp <= CP_MAX)
						break;
				}
			}
			if (cp > CP_MAX) {
				while (hpIV >= 5) {
					hpIV--;
					cpm = CPM_LIST[level];
					cp = getCP(cpm, curr.health, hpIV, curr.attack, atkIV, curr.defense, defIV);
					if (cp <= CP_MAX)
						break;
				}
			}
			if (cp > CP_MAX) {
				while (defIV >= 5) {
					defIV--;
					cpm = CPM_LIST[level];
					cp = getCP(cpm, curr.health, hpIV, curr.attack, atkIV, curr.defense, defIV);
					if (cp <= CP_MAX)
						break;
				}
			}
			if (cp <= CP_MAX) {
				cpm = CPM_LIST[level];
				cp = getCP(cpm, curr.health, hpIV, curr.attack, atkIV, curr.defense, defIV);
				String stringToWrite = curr.toString() + "," + hpIV + "," + atkIV + "," + defIV + ","
						+ (double) level / 2 + "," + cp + "," + curr.quickMove.toString() + ","
						+ curr.chargeMove1.toString();
				stringToWrite = curr.chargeMove2 == null ? stringToWrite
						: stringToWrite + "," + curr.chargeMove2.toString();
				stringToWrite = stringToWrite + "," + cpm;

				writer.println(stringToWrite);
			}

		}
		writer.close();
	}

	static int getCP(double cpm, int hp, int hpIV, int atk, int atkIV, int def, int defIV) {
		return (int) Math.floor(Math.sqrt(hp + hpIV) * (atk + atkIV) * Math.sqrt(def + defIV) * cpm * cpm / 10);
	}

	static void buildQuickMoveList() {
		quickMoveList.add(new Move(null, null, 0, 0, 0));
		quickMoveList.add(new Move("Counter","Fighting",8,7,2));
		quickMoveList.add(new Move("Dragon Breath","Dragon",4,3,1));
		quickMoveList.add(new Move("Vine Whip","Grass",5,8,2));
		quickMoveList.add(new Move("Bullet Punch","Steel",6,7,2));
		quickMoveList.add(new Move("Poison Jab","Poison",6,7,2));
		quickMoveList.add(new Move("Shadow Claw","Ghost",6,7,2));
		quickMoveList.add(new Move("Mud Shot","Ground",3,9,2));
		quickMoveList.add(new Move("Psycho Cut","Psychic",3,9,2));
		quickMoveList.add(new Move("Thunder Shock","Electric",3,9,2));
		quickMoveList.add(new Move("Bubble","Water",8,11,3));
		quickMoveList.add(new Move("Dragon Tail","Dragon",9,10,3));
		quickMoveList.add(new Move("Fire Spin","Fire",9,10,3));
		quickMoveList.add(new Move("Fury Cutter","Bug",2,4,1));
		quickMoveList.add(new Move("Powder Snow","Ice",4,8,2));
		quickMoveList.add(new Move("Spark","Electric",4,8,2));
		quickMoveList.add(new Move("Rock Throw","Rock",8,5,2));
		quickMoveList.add(new Move("Karate Chop","Fighting",5,7,2));
		quickMoveList.add(new Move("Quick Attack","Normal",5,7,2));
		quickMoveList.add(new Move("Sucker Punch","Dark",5,7,2));
		quickMoveList.add(new Move("Wing Attack","Flying",5,7,2));
		quickMoveList.add(new Move("Extrasensory","Psychic",8,10,3));
		quickMoveList.add(new Move("Ice Shard","Ice",8,10,3));
		quickMoveList.add(new Move("Snarl","Dark",8,10,3));
		quickMoveList.add(new Move("Air Slash","Flying",9,9,3));
		quickMoveList.add(new Move("Bug Bite","Bug",3,3,1));
		quickMoveList.add(new Move("Confusion","Psychic",12,12,4));
		quickMoveList.add(new Move("Ember","Fire",6,6,2));
		quickMoveList.add(new Move("Feint Attack","Dark",6,6,2));
		quickMoveList.add(new Move("Lick","Ghost",3,3,1));
		quickMoveList.add(new Move("Water Gun","Water",3,3,1));
		quickMoveList.add(new Move("Hex","Ghost",6,11,3));
		quickMoveList.add(new Move("Infestation","Bug",6,11,3));
		quickMoveList.add(new Move("Smack Down","Rock",10,8,3));
		quickMoveList.add(new Move("Waterfall","Water",10,8,3));
		quickMoveList.add(new Move("Fire Fang","Fire",7,5,2));
		quickMoveList.add(new Move("Steel Wing","Steel",7,5,2));
		quickMoveList.add(new Move("Bullet Seed","Grass",5,11,3));
		quickMoveList.add(new Move("Charge Beam","Electric",5,11,3));
		quickMoveList.add(new Move("Bite","Dark",4,2,1));
		quickMoveList.add(new Move("Razor Leaf","Grass",8,4,2));
		quickMoveList.add(new Move("Scratch","Normal",4,2,1));
		quickMoveList.add(new Move("Hidden Power","",9,8,3));
		quickMoveList.add(new Move("Mud-slap","Ground",9,8,3));
		quickMoveList.add(new Move("Struggle Bug","Bug",9,8,3));
		quickMoveList.add(new Move("Metal Claw","Steel",5,6,2));
		quickMoveList.add(new Move("Present","Normal",3,12,3));
		quickMoveList.add(new Move("Acid","Poison",6,5,2));
		quickMoveList.add(new Move("Frost Breath","Ice",6,5,2));
		quickMoveList.add(new Move("Peck","Flying",6,5,2));
		quickMoveList.add(new Move("Rock Smash","Fighting",9,7,3));
		quickMoveList.add(new Move("Astonish","Ghost",5,9,3));
		quickMoveList.add(new Move("Cut","Normal",3,2,1));
		quickMoveList.add(new Move("Iron Tail","Steel",9,6,3));
		quickMoveList.add(new Move("Tackle","Normal",3,2,1));
		quickMoveList.add(new Move("Water Gun Blastoise","Water",6,4,2));
		quickMoveList.add(new Move("Poison Sting","Poison",3,6,2));
		quickMoveList.add(new Move("Low Kick","Fighting",4,5,2));
		quickMoveList.add(new Move("Zen Headbutt","Psychic",8,6,3));
		quickMoveList.add(new Move("Take Down","Normal",5,8,3));
		quickMoveList.add(new Move("Pound","Normal",5,4,2));
		quickMoveList.add(new Move("Volt Switch","Electric",12,10,5));
		quickMoveList.add(new Move("Splash","Water",0,12,4));
		quickMoveList.add(new Move("Yawn","Normal",0,12,4));
		quickMoveList.add(new Move("Transform","Normal",0,0,3));
	}

	static void buildChargeMoveList() {
		chargeMoveList.add(new Move(null, null, 0, 0));
		chargeMoveList.add(new Move("Doom Desire","Steel",80,35));
		chargeMoveList.add(new Move("Hydro Cannon","Water",90,40));
		chargeMoveList.add(new Move("Frenzy Plant","Grass",100,45));
		chargeMoveList.add(new Move("Blast Burn","Fire",110,50));
		chargeMoveList.add(new Move("Origin Pulse","Water",130,60));
		chargeMoveList.add(new Move("Precipice Blades","Ground",130,60));
		chargeMoveList.add(new Move("Leaf Blade","Grass",70,35));
		chargeMoveList.add(new Move("Avalanche","Ice",90,45));
		chargeMoveList.add(new Move("Meteor Mash","Steel",100,50));
		chargeMoveList.add(new Move("Draco Meteor","Dragon",150,75));
		chargeMoveList.add(new Move("Focus Blast","Fighting",150,75));
		chargeMoveList.add(new Move("Hyper Beam","Normal",150,80));
		chargeMoveList.add(new Move("Overheat","Fire",150,80));
		chargeMoveList.add(new Move("Solar Beam","Grass",150,80));
		chargeMoveList.add(new Move("Zap Cannon","Electric",150,80));
		chargeMoveList.add(new Move("Moonblast","Fairy",130,70));
		chargeMoveList.add(new Move("Earthquake","Ground",120,65));
		chargeMoveList.add(new Move("Future Sight","Psychic",120,65));
		chargeMoveList.add(new Move("Outrage","Dragon",110,60));
		chargeMoveList.add(new Move("Psystrike","Psychic",100,55));
		chargeMoveList.add(new Move("Shadow Ball","Ghost",100,55));
		chargeMoveList.add(new Move("Stone Edge","Rock",100,55));
		chargeMoveList.add(new Move("Dynamic Punch","Fighting",90,50));
		chargeMoveList.add(new Move("Grass Knot","Grass",90,50));
		chargeMoveList.add(new Move("Power Whip","Grass",90,50));
		chargeMoveList.add(new Move("Wild Charge","Electric",90,50));
		chargeMoveList.add(new Move("Rock Slide","Rock",80,45));
		chargeMoveList.add(new Move("Sky Attack","Flying",80,45));
		chargeMoveList.add(new Move("Thunderbolt","Electric",80,45));
		chargeMoveList.add(new Move("Psycho Boost","Psychic",70,40));
		chargeMoveList.add(new Move("Fire Blast","Fire",140,80));
		chargeMoveList.add(new Move("Blizzard","Ice",130,75));
		chargeMoveList.add(new Move("Gunk Shot","Poison",130,75));
		chargeMoveList.add(new Move("Hydro Pump","Water",130,75));
		chargeMoveList.add(new Move("Weather Ball Fire","Fire",60,35));
		chargeMoveList.add(new Move("Weather Ball Ice","Ice",60,35));
		chargeMoveList.add(new Move("Weather Ball Rock","Rock",60,35));
		chargeMoveList.add(new Move("Weather Ball Water","Water",60,35));
		chargeMoveList.add(new Move("Flash Cannon","Steel",110,65));
		chargeMoveList.add(new Move("Hurricane","Flying",110,65));
		chargeMoveList.add(new Move("Petal Blizzard","Grass",110,65));
		chargeMoveList.add(new Move("Sludge Wave","Poison",110,65));
		chargeMoveList.add(new Move("Close Combat","Fighting",100,60));
		chargeMoveList.add(new Move("Thunder","Electric",100,60));
		chargeMoveList.add(new Move("Brave Bird","Flying",90,55));
		chargeMoveList.add(new Move("Ice Beam","Ice",90,55));
		chargeMoveList.add(new Move("Last Resort","Normal",90,55));
		chargeMoveList.add(new Move("Megahorn","Bug",90,55));
		chargeMoveList.add(new Move("Surf","Water",65,40));
		chargeMoveList.add(new Move("Dark Pulse","Dark",80,50));
		chargeMoveList.add(new Move("Hyper Fang","Normal",80,50));
		chargeMoveList.add(new Move("Sludge Bomb","Poison",80,50));
		chargeMoveList.add(new Move("Ancient Power","Rock",70,45));
		chargeMoveList.add(new Move("Crunch","Dark",70,45));
		chargeMoveList.add(new Move("Disarming Voice","Fairy",70,45));
		chargeMoveList.add(new Move("Foul Play","Dark",70,45));
		chargeMoveList.add(new Move("Magnet Bomb","Steel",70,45));
		chargeMoveList.add(new Move("Silver Wind","Bug",70,45));
		chargeMoveList.add(new Move("Drill Peck","Flying",60,40));
		chargeMoveList.add(new Move("Bug Buzz","Bug",90,60));
		chargeMoveList.add(new Move("Dragon Pulse","Dragon",90,60));
		chargeMoveList.add(new Move("Energy Ball","Grass",90,60));
		chargeMoveList.add(new Move("Play Rough","Fairy",90,60));
		chargeMoveList.add(new Move("Drill Run","Ground",80,55));
		chargeMoveList.add(new Move("Discharge","Electric",65,45));
		chargeMoveList.add(new Move("Psyshock","Psychic",65,45));
		chargeMoveList.add(new Move("Aqua Tail","Water",50,35));
		chargeMoveList.add(new Move("Body Slam","Normal",50,35));
		chargeMoveList.add(new Move("Cross Chop","Fighting",50,35));
		chargeMoveList.add(new Move("Dragon Claw","Dragon",50,35));
		chargeMoveList.add(new Move("Rest","Normal",50,35));
		chargeMoveList.add(new Move("Dazzling Gleam","Fairy",100,70));
		chargeMoveList.add(new Move("Psychic","Psychic",100,70));
		chargeMoveList.add(new Move("Flame Charge","Fire",70,50));
		chargeMoveList.add(new Move("Flamethrower","Fire",70,50));
		chargeMoveList.add(new Move("Heavy Slam","Steel",70,50));
		chargeMoveList.add(new Move("Fire Punch","Fire",55,40));
		chargeMoveList.add(new Move("Mud Bomb","Ground",55,40));
		chargeMoveList.add(new Move("Seed Bomb","Grass",55,40));
		chargeMoveList.add(new Move("Stomp","Normal",55,40));
		chargeMoveList.add(new Move("Signal Beam","Bug",75,55));
		chargeMoveList.add(new Move("Icy Wind","Ice",60,45));
		chargeMoveList.add(new Move("Wrap","Normal",60,45));
		chargeMoveList.add(new Move("Aurora Beam","Ice",80,60));
		chargeMoveList.add(new Move("Bulldoze","Ground",80,60));
		chargeMoveList.add(new Move("Gyro Ball","Steel",80,60));
		chargeMoveList.add(new Move("Power Gem","Rock",80,60));
		chargeMoveList.add(new Move("Sand Tomb","Ground",80,60));
		chargeMoveList.add(new Move("Scald","Water",80,60));
		chargeMoveList.add(new Move("Thunder Punch","Electric",45,35));
		chargeMoveList.add(new Move("X-Scissor","Bug",45,35));
		chargeMoveList.add(new Move("Flame Burst","Fire",70,55));
		chargeMoveList.add(new Move("Heat Wave","Fire",95,75));
		chargeMoveList.add(new Move("Ice Punch","Ice",50,40));
		chargeMoveList.add(new Move("Night Slash","Dark",50,40));
		chargeMoveList.add(new Move("Ominous Wind","Ghost",50,40));
		chargeMoveList.add(new Move("Rock Blast","Rock",50,40));
		chargeMoveList.add(new Move("Sludge","Poison",50,40));
		chargeMoveList.add(new Move("Dig","Ground",100,80));
		chargeMoveList.add(new Move("Aerial Ace","Flying",55,45));
		chargeMoveList.add(new Move("Brine","Water",60,50));
		chargeMoveList.add(new Move("Iron Head","Steel",60,50));
		chargeMoveList.add(new Move("Submission","Fighting",60,50));
		chargeMoveList.add(new Move("Psybeam","Psychic",70,60));
		chargeMoveList.add(new Move("Rock Tomb","Rock",70,60));
		chargeMoveList.add(new Move("Water Pulse","Water",70,60));
		chargeMoveList.add(new Move("Bone Club","Ground",40,35));
		chargeMoveList.add(new Move("Brick Break","Fighting",40,35));
		chargeMoveList.add(new Move("Cross Poison","Poison",40,35));
		chargeMoveList.add(new Move("Horn Attack","Normal",40,35));
		chargeMoveList.add(new Move("Poison Fang","Poison",40,35));
		chargeMoveList.add(new Move("Shadow Punch","Ghost",40,35));
		chargeMoveList.add(new Move("Bubble Beam","Water",45,40));
		chargeMoveList.add(new Move("Hydro Pump Blastoise","Water",90,80));
		chargeMoveList.add(new Move("Shadow Sneak","Ghost",50,45));
		chargeMoveList.add(new Move("Air Cutter","Flying",60,55));
		chargeMoveList.add(new Move("Draining Kiss","Fairy",60,55));
		chargeMoveList.add(new Move("Flame Wheel","Fire",60,55));
		chargeMoveList.add(new Move("Mirror Coat","Psychic",60,55));
		chargeMoveList.add(new Move("Night Shade","Ghost",60,55));
		chargeMoveList.add(new Move("Swift","Normal",60,55));
		chargeMoveList.add(new Move("Heart Stamp","Psychic",40,40));
		chargeMoveList.add(new Move("Low Sweep","Fighting",40,40));
		chargeMoveList.add(new Move("Vice Grip","Normal",40,40));
		chargeMoveList.add(new Move("Aqua Jet","Water",45,45));
		chargeMoveList.add(new Move("Twister","Dragon",45,45));
		chargeMoveList.add(new Move("Giga Drain","Grass",50,80));
		chargeMoveList.add(new Move("Scald Blastoise","Water",50,80));
		chargeMoveList.add(new Move("Wrap Green","Normal",25,45));
		chargeMoveList.add(new Move("Wrap Pink","Normal",25,45));
		chargeMoveList.add(new Move("Mega Drain","Grass",25,55));
		chargeMoveList.add(new Move("Parabolic Charge","Electric",25,55));
		chargeMoveList.add(new Move("Struggle","Normal",35,100));
	}

	static void buildList() {
		// parses a Pokemon object from a csv
		try {
			Scanner scan = new Scanner(new File(FILE_PATH + "import.txt"));
			scan.useDelimiter(",|\\r\\n");
			String[] fields = new String[11];

			while (scan.hasNext()) {
				for (int i = 0; i < fields.length; i++) {
					fields[i] = scan.next();
					System.out.println("i=" + i + " " + fields[i]);
				}
				pokemonList.add(new Pokemon(fields[0], fields[1], fields[2], fields[3], Integer.parseInt(fields[4]),
						Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]),
						quickMoveList.get(Integer.parseInt(fields[8])), chargeMoveList.get(Integer.parseInt(fields[9])),
						chargeMoveList.get(Integer.parseInt(fields[10]))));
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

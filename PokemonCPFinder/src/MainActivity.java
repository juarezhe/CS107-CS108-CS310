import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity {
	static ArrayList<Move> quickMoveList = new ArrayList<Move>(81);
	static ArrayList<Move> chargeMoveList = new ArrayList<Move>(131);
	static ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>(3426);
	static PrintWriter writer;
	static final int CP_MAX = 1500;
	static final int LEVEL_MAX = 30;
	static final String FILE_PATH = "C:\\Users\\djuarez\\Desktop\\";
	static final double[] CPM_LIST = {0,0,0.094,0.135137432,0.16639787,0.192650919,0.21573247,0.236572661,0.25572005,0.273530381,0.29024988,0.306057377,0.3210876,0.335445036,0.34921268,0.362457751,0.37523559,0.387592406,0.39956728,0.411193551,0.42250001,0.432926419,0.44310755,0.4530599578,0.46279839,0.472336083,0.48168495,0.4908558,0.49985844,0.508701765,0.51739395,0.525942511,0.53435433,0.542635767,0.55079269,0.558830576,0.56675452,0.574569153,0.58227891,0.589887917,0.59740001,0.604818814,0.61215729,0.619399365,0.62656713,0.633644533,0.64065295,0.647576426,0.65443563,0.661214806,0.667934,0.674577537,0.68116492,0.687680648,0.69414365,0.700538673,0.70688421,0.713164996,0.71939909,0.725571552,0.7317,0.734741009,0.73776948,0.740785574,0.74378943,0.746781211,0.74976104,0.752729087,0.75568551,0.758630378,0.76156384,0.764486065,0.76739717,0.770297266,0.7731865,0.776064962,0.77893275,0.781790055,0.78463697,0.787473578,0.79030001};

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
		writer.println("name,form,type1,type2,cp,level,hp,atk,def,quick,type,pwr,nrg,dur,charge,type,pwr,nrg,dur");
		
		for (int n = 0; n < pokemonList.size(); n++) {
			Pokemon curr = pokemonList.get(n);
			int hpIV = 15;
			int atkIV = 15;
			int defIV = 15;
			int level;
			double cpm;
			int cp = 9999;
			
			for (level = LEVEL_MAX * 2; level >= 2; level --) {
				cpm = CPM_LIST[level];
				cp = getCP(cpm, curr.health, hpIV, curr.attack, atkIV, curr.defense, defIV);
				//System.out.println(curr.name + "," + curr.form + "," + cp + "," + (double) level / 2 + "," + hpIV + "," + atkIV + "," + defIV);
				if (cp < 1500) break;
			}
			writer.println(curr.name + "," + curr.form + "," + curr.type1 + "," + curr.type2 + "," + cp + "," + (double) level / 2 + "," + hpIV + "," + atkIV + "," + defIV + "," + curr.quickMove.toString() + "," + curr.chargeMove.toString());
		}
		writer.close();
	}
	
	static int getCP(double cpm, int hp, int hpIV, int atk, int atkIV, int def, int defIV) {
		return (int) Math.floor(Math.sqrt(hp + hpIV) * (atk + atkIV) * Math.sqrt(def + defIV) * cpm * cpm / 10);
	}
	
	static void buildQuickMoveList() {
		quickMoveList.add(new Move("Acid","Poison",9,8,800));
		quickMoveList.add(new Move("Air Slash","Flying",14,10,1200));
		quickMoveList.add(new Move("Astonish","Ghost",8,14,1100));
		quickMoveList.add(new Move("Bite","Dark",6,4,500));
		quickMoveList.add(new Move("Bubble","Water",12,14,1200));
		quickMoveList.add(new Move("Bug Bite","Bug",5,6,500));
		quickMoveList.add(new Move("Bullet Punch","Steel",9,10,900));
		quickMoveList.add(new Move("Bullet Seed","Grass",8,14,1100));
		quickMoveList.add(new Move("Charge Beam","Electric",8,15,1100));
		quickMoveList.add(new Move("Confusion","Psychic",20,15,1600));
		quickMoveList.add(new Move("Counter","Fighting",12,8,900));
		quickMoveList.add(new Move("Cut","Normal",5,5,500));
		quickMoveList.add(new Move("Dragon Breath","Dragon",6,4,500));
		quickMoveList.add(new Move("Dragon Tail","Dragon",15,9,1100));
		quickMoveList.add(new Move("Ember","Fire",10,10,1000));
		quickMoveList.add(new Move("Extrasensory","Psychic",12,12,1100));
		quickMoveList.add(new Move("Feint Attack","Dark",10,9,900));
		quickMoveList.add(new Move("Fire Fang","Fire",11,8,900));
		quickMoveList.add(new Move("Fire Spin","Fire",14,10,1100));
		quickMoveList.add(new Move("Frost Breath","Ice",10,8,900));
		quickMoveList.add(new Move("Fury Cutter","Bug",3,6,400));
		quickMoveList.add(new Move("Hex","Ghost",10,15,1200));
		quickMoveList.add(new Move("Hidden Power Bug","Bug",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Dark","Dark",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Dragon","Dragon",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Electric","Electric",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Fairy","Fairy",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Fighting","Fighting",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Fire","Fire",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Flying","Flying",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Ghost","Ghost",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Grass","Grass",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Ground","Ground",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Ice","Ice",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Normal","Normal",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Poison","Poison",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Psychic","Psychic",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Rock","Rock",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Steel","Steel",15,15,1500));
		quickMoveList.add(new Move("Hidden Power Water","Water",15,15,1500));
		quickMoveList.add(new Move("Ice Shard","Ice",12,12,1200));
		quickMoveList.add(new Move("Infestation","Bug",10,14,1100));
		quickMoveList.add(new Move("Iron Tail","Steel",15,7,1100));
		quickMoveList.add(new Move("Karate Chop","Fighting",8,10,800));
		quickMoveList.add(new Move("Lick","Ghost",5,6,500));
		quickMoveList.add(new Move("Low Kick","Fighting",6,6,600));
		quickMoveList.add(new Move("Metal Claw","Steel",8,7,700));
		quickMoveList.add(new Move("Mud Shot","Ground",5,7,600));
		quickMoveList.add(new Move("Mud-slap","Ground",15,12,1400));
		quickMoveList.add(new Move("Peck","Flying",10,10,1000));
		quickMoveList.add(new Move("Poison Jab","Poison",10,7,800));
		quickMoveList.add(new Move("Poison Sting","Poison",5,7,600));
		quickMoveList.add(new Move("Pound","Normal",7,6,600));
		quickMoveList.add(new Move("Powder Snow","Ice",6,15,1000));
		quickMoveList.add(new Move("Present","Normal",5,20,1300));
		quickMoveList.add(new Move("Psycho Cut","Psychic",5,8,600));
		quickMoveList.add(new Move("Quick Attack","Normal",8,10,800));
		quickMoveList.add(new Move("Razor Leaf","Grass",13,7,1000));
		quickMoveList.add(new Move("Rock Smash","Fighting",15,10,1300));
		quickMoveList.add(new Move("Rock Throw","Rock",12,7,900));
		quickMoveList.add(new Move("Scratch","Normal",6,4,500));
		quickMoveList.add(new Move("Shadow Claw","Ghost",9,6,700));
		quickMoveList.add(new Move("Smack Down","Rock",12,7,900));
		quickMoveList.add(new Move("Snarl","Dark",12,12,1100));
		quickMoveList.add(new Move("Spark","Electric",6,9,700));
		quickMoveList.add(new Move("Splash","Water",0,20,1730));
		quickMoveList.add(new Move("Steel Wing","Steel",11,6,800));
		quickMoveList.add(new Move("Struggle Bug","Bug",15,15,1500));
		quickMoveList.add(new Move("Sucker Punch","Dark",7,8,700));
		quickMoveList.add(new Move("Tackle","Normal",5,5,500));
		quickMoveList.add(new Move("Take Down","Normal",8,10,1200));
		quickMoveList.add(new Move("Thunder Shock","Electric",5,8,600));
		quickMoveList.add(new Move("Transform","Normal",0,0,2230));
		quickMoveList.add(new Move("Vine Whip","Grass",7,6,600));
		quickMoveList.add(new Move("Volt Switch","Electric",20,25,2300));
		quickMoveList.add(new Move("Water Gun","Water",5,5,500));
		quickMoveList.add(new Move("Water Gun Blastoise","Water",10,6,1000));
		quickMoveList.add(new Move("Waterfall","Water",16,8,1200));
		quickMoveList.add(new Move("Wing Attack","Flying",8,9,800));
		quickMoveList.add(new Move("Yawn","Normal",0,15,1700));
		quickMoveList.add(new Move("Zen Headbutt","Psychic",12,10,1100));
	}
	
	static void buildChargeMoveList() {
		chargeMoveList.add(new Move("Aerial Ace","Flying",55,33,2400));
		chargeMoveList.add(new Move("Air Cutter","Flying",60,50,2700));
		chargeMoveList.add(new Move("Ancient Power","Rock",70,33,3500));
		chargeMoveList.add(new Move("Aqua Jet","Water",45,33,2600));
		chargeMoveList.add(new Move("Aqua Tail","Water",50,33,1900));
		chargeMoveList.add(new Move("Aurora Beam","Ice",80,50,3550));
		chargeMoveList.add(new Move("Avalanche","Ice",90,50,2700));
		chargeMoveList.add(new Move("Blast Burn","Fire",110,50,3300));
		chargeMoveList.add(new Move("Blizzard","Ice",130,100,3100));
		chargeMoveList.add(new Move("Body Slam","Normal",50,33,1900));
		chargeMoveList.add(new Move("Bone Club","Ground",40,33,1600));
		chargeMoveList.add(new Move("Brave Bird","Flying",90,100,2000));
		chargeMoveList.add(new Move("Brick Break","Fighting",40,33,1600));
		chargeMoveList.add(new Move("Brine","Water",60,50,2300));
		chargeMoveList.add(new Move("Bubble Beam","Water",45,33,1900));
		chargeMoveList.add(new Move("Bug Buzz","Bug",90,50,3700));
		chargeMoveList.add(new Move("Bulldoze","Ground",80,50,3500));
		chargeMoveList.add(new Move("Close Combat","Fighting",100,100,2300));
		chargeMoveList.add(new Move("Cross Chop","Fighting",50,50,1500));
		chargeMoveList.add(new Move("Cross Poison","Poison",40,33,1500));
		chargeMoveList.add(new Move("Crunch","Dark",70,33,3200));
		chargeMoveList.add(new Move("Dark Pulse","Dark",80,50,3000));
		chargeMoveList.add(new Move("Dazzling Gleam","Fairy",100,50,3500));
		chargeMoveList.add(new Move("Dig","Ground",100,50,4700));
		chargeMoveList.add(new Move("Disarming Voice","Fairy",70,33,3900));
		chargeMoveList.add(new Move("Discharge","Electric",65,33,2500));
		chargeMoveList.add(new Move("Doom Desire","Steel",80,50,1700));
		chargeMoveList.add(new Move("Draco Meteor","Dragon",150,100,3600));
		chargeMoveList.add(new Move("Dragon Claw","Dragon",50,33,1700));
		chargeMoveList.add(new Move("Dragon Pulse","Dragon",90,50,3600));
		chargeMoveList.add(new Move("Draining Kiss","Fairy",60,50,2600));
		chargeMoveList.add(new Move("Drill Peck","Flying",60,33,2300));
		chargeMoveList.add(new Move("Drill Run","Ground",80,50,2800));
		chargeMoveList.add(new Move("Dynamic Punch","Fighting",90,50,2700));
		chargeMoveList.add(new Move("Earthquake","Ground",120,100,3600));
		chargeMoveList.add(new Move("Energy Ball","Grass",90,50,3900));
		chargeMoveList.add(new Move("Fire Blast","Fire",140,100,4200));
		chargeMoveList.add(new Move("Fire Punch","Fire",55,33,2200));
		chargeMoveList.add(new Move("Flame Burst","Fire",70,50,2600));
		chargeMoveList.add(new Move("Flame Charge","Fire",70,33,3800));
		chargeMoveList.add(new Move("Flame Wheel","Fire",60,50,2700));
		chargeMoveList.add(new Move("Flamethrower","Fire",70,50,2200));
		chargeMoveList.add(new Move("Flash Cannon","Steel",100,100,2700));
		chargeMoveList.add(new Move("Focus Blast","Fighting",140,100,3500));
		chargeMoveList.add(new Move("Foul Play","Dark",70,50,2000));
		chargeMoveList.add(new Move("Frenzy Plant","Grass",100,50,2600));
		chargeMoveList.add(new Move("Future Sight","Psychic",120,100,2700));
		chargeMoveList.add(new Move("Giga Drain","Grass",50,100,3900));
		chargeMoveList.add(new Move("Grass Knot","Grass",90,50,2600));
		chargeMoveList.add(new Move("Gunk Shot","Poison",130,100,3100));
		chargeMoveList.add(new Move("Gyro Ball","Steel",80,50,3300));
		chargeMoveList.add(new Move("Heart Stamp","Psychic",40,33,1900));
		chargeMoveList.add(new Move("Heat Wave","Fire",95,100,3000));
		chargeMoveList.add(new Move("Heavy Slam","Steel",70,50,2100));
		chargeMoveList.add(new Move("Horn Attack","Normal",40,33,1850));
		chargeMoveList.add(new Move("Hurricane","Flying",110,100,2700));
		chargeMoveList.add(new Move("Hydro Cannon","Water",90,50,1900));
		chargeMoveList.add(new Move("Hydro Pump","Water",130,100,3300));
		chargeMoveList.add(new Move("Hydro Pump Blastoise","Water",90,100,4500));
		chargeMoveList.add(new Move("Hyper Beam","Normal",150,100,3800));
		chargeMoveList.add(new Move("Hyper Fang","Normal",80,50,2500));
		chargeMoveList.add(new Move("Ice Beam","Ice",90,50,3300));
		chargeMoveList.add(new Move("Ice Punch","Ice",50,33,1900));
		chargeMoveList.add(new Move("Icy Wind","Ice",60,33,3300));
		chargeMoveList.add(new Move("Iron Head","Steel",60,50,1900));
		chargeMoveList.add(new Move("Last Resort","Normal",90,50,2900));
		chargeMoveList.add(new Move("Leaf Blade","Grass",70,33,2400));
		chargeMoveList.add(new Move("Low Sweep","Fighting",40,33,1900));
		chargeMoveList.add(new Move("Magnet Bomb","Steel",70,33,2800));
		chargeMoveList.add(new Move("Mega Drain","Grass",25,50,2600));
		chargeMoveList.add(new Move("Megahorn","Bug",90,100,2200));
		chargeMoveList.add(new Move("Meteor Mash","Steel",100,50,2600));
		chargeMoveList.add(new Move("Mirror Coat","Psychic",60,50,2600));
		chargeMoveList.add(new Move("Moonblast","Fairy",130,100,3900));
		chargeMoveList.add(new Move("Mud Bomb","Ground",55,33,2300));
		chargeMoveList.add(new Move("Night Shade","Ghost",60,50,2600));
		chargeMoveList.add(new Move("Night Slash","Dark",50,33,2200));
		chargeMoveList.add(new Move("Ominous Wind","Ghost",50,33,2300));
		chargeMoveList.add(new Move("Outrage","Dragon",110,50,3900));
		chargeMoveList.add(new Move("Overheat","Fire",160,100,4000));
		chargeMoveList.add(new Move("Parabolic Charge","Electric",25,50,2800));
		chargeMoveList.add(new Move("Petal Blizzard","Grass",110,100,2600));
		chargeMoveList.add(new Move("Play Rough","Fairy",90,50,2900));
		chargeMoveList.add(new Move("Poison Fang","Poison",35,33,1700));
		chargeMoveList.add(new Move("Power Gem","Rock",80,50,2900));
		chargeMoveList.add(new Move("Power Whip","Grass",90,50,2600));
		chargeMoveList.add(new Move("Psybeam","Psychic",70,50,3200));
		chargeMoveList.add(new Move("Psychic","Psychic",100,100,2800));
		chargeMoveList.add(new Move("Psycho Boost","Psychic",70,50,4000));
		chargeMoveList.add(new Move("Psyshock","Psychic",65,33,2700));
		chargeMoveList.add(new Move("Psystrike","Psychic",100,50,4400));
		chargeMoveList.add(new Move("Rest","Normal",50,33,1900));
		chargeMoveList.add(new Move("Rock Blast","Rock",50,33,2100));
		chargeMoveList.add(new Move("Rock Slide","Rock",80,50,2700));
		chargeMoveList.add(new Move("Rock Tomb","Rock",70,50,3200));
		chargeMoveList.add(new Move("Sand Tomb","Ground",80,50,4000));
		chargeMoveList.add(new Move("Scald","Water",80,50,3700));
		chargeMoveList.add(new Move("Scald Blastoise","Water",50,100,4700));
		chargeMoveList.add(new Move("Seed Bomb","Grass",55,33,2100));
		chargeMoveList.add(new Move("Shadow Ball","Ghost",100,50,3000));
		chargeMoveList.add(new Move("Shadow Punch","Ghost",40,33,1700));
		chargeMoveList.add(new Move("Shadow Sneak","Ghost",50,33,2900));
		chargeMoveList.add(new Move("Signal Beam","Bug",75,50,2900));
		chargeMoveList.add(new Move("Silver Wind","Bug",70,33,3700));
		chargeMoveList.add(new Move("Sky Attack","Flying",80,50,2000));
		chargeMoveList.add(new Move("Sludge","Poison",50,33,2100));
		chargeMoveList.add(new Move("Sludge Bomb","Poison",80,50,2300));
		chargeMoveList.add(new Move("Sludge Wave","Poison",110,100,3200));
		chargeMoveList.add(new Move("Solar Beam","Grass",180,100,4900));
		chargeMoveList.add(new Move("Stomp","Normal",55,50,1700));
		chargeMoveList.add(new Move("Stone Edge","Rock",100,100,2300));
		chargeMoveList.add(new Move("Struggle","Normal",35,0,2200));
		chargeMoveList.add(new Move("Submission","Fighting",60,50,2200));
		chargeMoveList.add(new Move("Surf","Water",65,50,1700));
		chargeMoveList.add(new Move("Swift","Normal",60,50,2800));
		chargeMoveList.add(new Move("Thunder","Electric",100,100,2400));
		chargeMoveList.add(new Move("Thunder Punch","Electric",45,33,1800));
		chargeMoveList.add(new Move("Thunderbolt","Electric",80,50,2500));
		chargeMoveList.add(new Move("Twister","Dragon",45,33,2800));
		chargeMoveList.add(new Move("Vice Grip","Normal",35,33,1900));
		chargeMoveList.add(new Move("Water Pulse","Water",70,50,3200));
		chargeMoveList.add(new Move("Weather Ball Fire","Fire",60,33,1600));
		chargeMoveList.add(new Move("Weather Ball Ice","Ice",60,33,1600));
		chargeMoveList.add(new Move("Weather Ball Rock","Rock",60,33,1600));
		chargeMoveList.add(new Move("Weather Ball Water","Water",60,33,1600));
		chargeMoveList.add(new Move("Wild Charge","Electric",90,50,2600));
		chargeMoveList.add(new Move("Wrap","Normal",60,33,2900));
		chargeMoveList.add(new Move("Wrap Green","Normal",25,33,2900));
		chargeMoveList.add(new Move("Wrap Pink","Normal",25,33,2900));
		chargeMoveList.add(new Move("X-Scissor","Bug",45,33,1600));
		chargeMoveList.add(new Move("Zap Cannon","Electric",140,100,3700));
	}

	static void buildList() {
		//parses a Pokemon object from a csv
		try {
			Scanner scan = new Scanner(new File(FILE_PATH + "import.txt"));
			scan.useDelimiter(",|\\r\\n");
			while (scan.hasNext()) {
				String[] fields = new String[9];
				for (int i = 0; i < 9; i++) {
					fields[i] = scan.next();
				}
				pokemonList.add(new Pokemon(fields[0], fields[1], fields[2], fields[3], Integer.parseInt(fields[4]), Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), quickMoveList.get(Integer.parseInt(fields[7])), chargeMoveList.get(Integer.parseInt(fields[8]))));
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

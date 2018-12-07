import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MainActivity {
	static PokemonArray pokemonList = new PokemonArray(528);
	static PrintWriter writer;
	static final int CP_MAX = 1500;
	static final int LEVEL_MAX = 30;
	static final String FILE_PATH = "C:\\Users\\djuarez\\Desktop\\";
	static final double[] CPM_LIST = {0,0,0.094,0.135137432,0.16639787,0.192650919,0.21573247,0.236572661,0.25572005,0.273530381,0.29024988,0.306057377,0.3210876,0.335445036,0.34921268,0.362457751,0.37523559,0.387592406,0.39956728,0.411193551,0.42250001,0.432926419,0.44310755,0.4530599578,0.46279839,0.472336083,0.48168495,0.4908558,0.49985844,0.508701765,0.51739395,0.525942511,0.53435433,0.542635767,0.55079269,0.558830576,0.56675452,0.574569153,0.58227891,0.589887917,0.59740001,0.604818814,0.61215729,0.619399365,0.62656713,0.633644533,0.64065295,0.647576426,0.65443563,0.661214806,0.667934,0.674577537,0.68116492,0.687680648,0.69414365,0.700538673,0.70688421,0.713164996,0.71939909,0.725571552,0.7317,0.734741009,0.73776948,0.740785574,0.74378943,0.746781211,0.74976104,0.752729087,0.75568551,0.758630378,0.76156384,0.764486065,0.76739717,0.770297266,0.7731865,0.776064962,0.77893275,0.781790055,0.78463697,0.787473578,0.79030001};

	public static void main(String[] args) {
		pokemonList.add(new Pokemon("Machoke","","fighting","",190,177,125));
		
		try {
			writer = new PrintWriter(FILE_PATH + CP_MAX + "-" + LEVEL_MAX + ".txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("name,form,cp,level,hpIV,atkIV,defIV");
		
		for (int n = 0; n < pokemonList.getSize(); n++) {
			Pokemon curr = pokemonList.getPokemon(n);
			String name = curr.mName;
			String form = curr.mForm;
			int hp = curr.mHP;
			int atk = curr.mAtk;
			int def = curr.mDef;
			int hpIV = 15;
			int atkIV = 15;
			int defIV = 15;
			int level = LEVEL_MAX;
			double cpm = CPM_LIST[level];
			int cp = getCP(cpm, hp, hpIV, atk, atkIV, def, defIV);
			
			while (cp > CP_MAX && level >= 2) {
				cpm = CPM_LIST[level];
				cp = getCP(cpm, hp, hpIV, atk, atkIV, def, defIV);
				if(cp > CP_MAX) {
					level--;
					break;
				}
				if (level == LEVEL_MAX * 2) {
					break;
				}
				level++;
			}
			cpm = CPM_LIST[level];
			cp = getCP(cpm, hp, hpIV, atk, atkIV, def, defIV);
			
			while(cp <= CP_MAX && hpIV <= 15) {
				cp = getCP(cpm, hp, hpIV, atk, atkIV, def, defIV);
				if (cp > CP_MAX) {
					hpIV--;
					break;
				}
				if (hpIV == 15) {
					break;
				}
				hpIV++;
			}
			cp = getCP(cpm, hp, hpIV, atk, atkIV, def, defIV);
			
			while(cp <= CP_MAX && defIV <= 15) {
				cp = getCP(cpm, hp, hpIV, atk, atkIV, def, defIV);
				if (cp > CP_MAX) {
					defIV--;
					break;
				}
				if (defIV == 15) {
					break;
				}
				defIV++;
			}
			cp = getCP(cpm, hp, hpIV, atk, atkIV, def, defIV);
			
			while(cp <= CP_MAX && atkIV <= 15) {
				cp = getCP(cpm, hp, hpIV, atk, atkIV, def, defIV);
				if (cp > CP_MAX) {
					atkIV--;
					break;
				}
				if (atkIV == 15) {
					break;
				}				
				atkIV++;
			}
			cp = getCP(cpm, hp, hpIV, atk, atkIV, def, defIV);
			writer.println(name + "," + form + "," + cp + "," + (double) level / 2 + "," + hpIV + "," + atkIV + "," + defIV);
		}
		writer.close();
	}
	
	static int getCP(double cpm, int hp, int hpIV, int atk, int atkIV, int def, int defIV) {
		return (int) Math.floor(Math.sqrt(hp + hpIV) * (atk + atkIV) * Math.sqrt(def + defIV) * cpm * cpm / 10);
	}
	
	static void buildList() {
		pokemonList.add(new Pokemon("Machoke","","fighting","",190,177,125));
		
	}

}

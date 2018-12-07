
public class PokemonArray {	
	Pokemon[] mPokemonList;
	int mIndex;
	
	public PokemonArray (int size) {
		this.mPokemonList = new Pokemon[size];
		this.mIndex = -1;
	}
	
	public void add(Pokemon newPokemon) {
		if (this.mIndex == mPokemonList.length - 1) {
			System.out.println("Can't add. Array full.");
		} else {
			this.mIndex++;
			this.mPokemonList[this.mIndex] = newPokemon;
		}
	}
	
	public Pokemon getPokemon(int idx) {
		return this.mPokemonList[idx];
	}
	
	public int getSize() {
		return this.mIndex + 1;
	}
}

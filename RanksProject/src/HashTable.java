
public class HashTable {
	
	private Word[] tabela;
	private int blocoA, blocoB, blocoC, blocoD, blocoE, blocoF, blocoG, blocoH, blocoI, blocoJ, blocoK, blocoL, blocoM,
				blocoN, blocoO, blocoP, blocoQ, blocoR, blocoS, blocoT, blocoU, blocoV, blocoW, blocoX, blocoY, blocoZ;
	private int tamanho;	
	private int qtdItens;
	private int conflitos;
	private Letra letra;
	private int min, max;
	
	public HashTable() {
		this.qtdItens = 0;
		this.conflitos = 0;
		this.min = 0;
		this.max = 0;
	}
	
	public void BeginHashTable(Letra letra) {
		
		this.letra = letra;
		this.tamanho = this.letra.getA() + this.letra.getB() + this.letra.getC() + this.letra.getD() +
					   this.letra.getE() + this.letra.getF() + this.letra.getG() + this.letra.getH() +
					   this.letra.getI() + this.letra.getJ() + this.letra.getK() + this.letra.getL() +
					   this.letra.getM() + this.letra.getN() + this.letra.getO() + this.letra.getP() +
					   this.letra.getQ() + this.letra.getR() + this.letra.getS() + this.letra.getT() +
					   this.letra.getU() + this.letra.getV() + this.letra.getW() + this.letra.getX() +
					   this.letra.getY() + this.letra.getZ() + 1;
		this.tabela = new Word[this.tamanho];
		this.blocoA = 0;
		this.blocoB = this.letra.getA() + 1;
		this.blocoC = this.blocoB + this.letra.getB();
		this.blocoD = this.blocoC + this.letra.getC();
		this.blocoE = this.blocoD + this.letra.getD();
		this.blocoF = this.blocoE + this.letra.getE();
		this.blocoG = this.blocoF + this.letra.getF();
		this.blocoH = this.blocoG + this.letra.getG();
		this.blocoI = this.blocoH + this.letra.getH();
		this.blocoJ = this.blocoI + this.letra.getI();
		this.blocoK = this.blocoJ + this.letra.getJ();
		this.blocoL = this.blocoK + this.letra.getK();
		this.blocoM = this.blocoL + this.letra.getL();
		this.blocoN = this.blocoM + this.letra.getM();
		this.blocoO = this.blocoN + this.letra.getN();
		this.blocoP = this.blocoO + this.letra.getO();
		this.blocoQ = this.blocoP + this.letra.getP();
		this.blocoR = this.blocoQ + this.letra.getQ();
		this.blocoS = this.blocoR + this.letra.getR();
		this.blocoT = this.blocoS + this.letra.getS();
		this.blocoU = this.blocoT + this.letra.getT();
		this.blocoV = this.blocoU + this.letra.getU();
		this.blocoW = this.blocoV + this.letra.getV();
		this.blocoX = this.blocoW + this.letra.getW();
		this.blocoY = this.blocoX + this.letra.getX();
		this.blocoZ = this.blocoY + this.letra.getY();
		System.out.println("tamanho tabela: "+tabela.length);
	}
	
	public boolean AddTabelaHash(Word word) {
		
		int indice = HashCode(word.getDescricao());
		
		if (IsEmpty(indice) == true) {
			this.tabela[indice] = word;
			this.qtdItens++;			
			return true;
		} else {			
			this.conflitos++;
			UpdateRange(word.getDescricao().charAt(0));			
			for (int i = 0; i < (this.max - this.min); i++) {
				
				if (indice < this.max) {
					indice++;
				} else {
					indice = this.min;
				}
				
				if (IsEmpty(indice) == true) {
					this.tabela[indice] = word;
					this.qtdItens++;					
					return true;
				} else {					
					this.conflitos++;
				}				
			}
			return false;
		}
	}
	
	public Word SearchTabelaHash(String word) {

		int indice = HashCode(word);
		if (IsEmpty(indice) == false) {
			if (IsEquals(word, indice) == true) {				
				return this.tabela[indice];			
			} else {			
				UpdateRange(word.toUpperCase().charAt(0));			
				for (int i = 0; i < (this.max - this.min); i++) {
					if (indice < this.max) {
						indice++;
					} else {
						indice = this.min;
					}
					
					if (IsEmpty(indice) == false) {
						if (IsEquals(word, indice) == true) {					
							return this.tabela[indice];
						}
					}				
				}
			}
		}		
		return null;
	}
	
	public int HashCode(String word) {
		
		int tamWord = word.length();
		int probe = 0;
		char letra;
									
		for (int i = 0; i < tamWord; i++) {
			letra = word.charAt(i);
			probe += Character.getNumericValue(letra);			
		}
		return CalcHashCode(probe, word.charAt(0));
	}

	private int CalcHashCode(int probe, char first) {
		
		switch (first) {
			case 'A': return probe % this.letra.getA() + this.blocoA;
			case 'B': return probe % this.letra.getB() + this.blocoB;
			case 'C': return probe % this.letra.getC() + this.blocoC;
			case 'D': return probe % this.letra.getD() + this.blocoD;
			case 'E': return probe % this.letra.getE() + this.blocoE;
			case 'F': return probe % this.letra.getF() + this.blocoF;
			case 'G': return probe % this.letra.getG() + this.blocoG;
			case 'H': return probe % this.letra.getH() + this.blocoH;
			case 'I': return probe % this.letra.getI() + this.blocoI;
			case 'J': return probe % this.letra.getJ() + this.blocoJ;
			case 'K': return probe % this.letra.getK() + this.blocoK;
			case 'L': return probe % this.letra.getL() + this.blocoL;
			case 'M': return probe % this.letra.getM() + this.blocoM;
			case 'N': return probe % this.letra.getN() + this.blocoN;
			case 'O': return probe % this.letra.getO() + this.blocoO;
			case 'P': return probe % this.letra.getP() + this.blocoP;
			case 'Q': return probe % this.letra.getQ() + this.blocoQ;
			case 'R': return probe % this.letra.getR() + this.blocoR;
			case 'S': return probe % this.letra.getS() + this.blocoS;
			case 'T': return probe % this.letra.getT() + this.blocoT;
			case 'U': return probe % this.letra.getU() + this.blocoU;
			case 'V': return probe % this.letra.getV() + this.blocoV;
			case 'W': return probe % this.letra.getW() + this.blocoW;
			case 'X': return probe % this.letra.getX() + this.blocoX;
			case 'Y': return probe % this.letra.getY() + this.blocoY;
			case 'Z': return probe % this.letra.getZ() + this.blocoZ;
			default: return 0;
		}
	}
	
	public boolean IsEmpty(int indice) {		
		if (tabela[indice] == null) {			
			return true;
		}
		return false;
	}
	
	public boolean IsEquals(String w, int indice) {		
		if (w.equals(this.tabela[indice].getDescricao())) {
			return true;
		}
		return false;
	}
	
	public Word[] getTabela() {
		return this.tabela;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}

	public int getQtdItens() {
		return this.qtdItens;
	}

	public int getConflitos() {
		return this.conflitos;
	}
	
	public void UpdateRange(char first) {		
		switch (first) {
			case 'A':
				this.min = 0;
				this.max = this.blocoB;
				break;
			case 'B':
				this.min = this.blocoB + 1;
				this.max = this.blocoC;
				break;
			case 'C':
				this.min = this.blocoC + 1;
				this.max = this.blocoD;
				break;
			case 'D':
				this.min = this.blocoD + 1;
				this.max = this.blocoE;
				break;
			case 'E':
				this.min = this.blocoE + 1;
				this.max = this.blocoF;
				break;
			case 'F':
				this.min = this.blocoF + 1;
				this.max = this.blocoG;
				break;
			case 'G':
				this.min = this.blocoG+ 1;
				this.max = this.blocoH;
				break;
			case 'H':
				this.min = this.blocoH + 1;
				this.max = this.blocoI;
				break;
			case 'I':
				this.min = this.blocoI + 1;
				this.max = this.blocoJ;
				break;
			case 'J':
				this.min = this.blocoJ + 1;
				this.max = this.blocoK;
				break;
			case 'K':
				this.min = this.blocoK + 1;
				this.max = this.blocoL;
				break;
			case 'L':
				this.min = this.blocoL + 1;
				this.max = this.blocoM;
				break;
			case 'M':
				this.min = this.blocoM + 1;
				this.max = this.blocoN;
				break;
			case 'N':
				this.min = this.blocoN + 1;
				this.max = this.blocoO;
				break;
			case 'O':
				this.min = this.blocoO + 1;
				this.max = this.blocoP;
				break;
			case 'P':
				this.min = this.blocoP + 1;
				this.max = this.blocoQ;
				break;
			case 'Q':
				this.min = this.blocoQ + 1;
				this.max = this.blocoR;
				break;
			case 'R':
				this.min = this.blocoR + 1;
				this.max = this.blocoS;
				break;
			case 'S':
				this.min = this.blocoS + 1;
				this.max = this.blocoT;
				break;
			case 'T':
				this.min = this.blocoT + 1;
				this.max = this.blocoU;
				break;
			case 'U':
				this.min = this.blocoU + 1;
				this.max = this.blocoV;
				break;
			case 'V':
				this.min = this.blocoV + 1;
				this.max = this.blocoW;
				break;
			case 'W':
				this.min = this.blocoW + 1;
				this.max = this.blocoX;
				break;
			case 'X':
				this.min = this.blocoX + 1;
				this.max = this.blocoY;
				break;
			case 'Y':
				this.min = this.blocoY + 1;
				this.max = this.blocoZ;
				break;
			case 'Z':
				this.min = this.blocoZ + 1;
				this.max = this.tamanho;
				break;
			default:
				this.min = 0;
				this.max = this.tamanho;
				break;
		}
	}
}


public class Letra {
	
	private int a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
	private char first;

	public Letra() {
		this.a = this.b = this.c = this.d = this.e = this.f = this.g = this.h = this.i = 0;
		this.j = this.k = this.l = this.m = this.n = this.o = this.p = this.q = this.r = 0;
		this.s = this.t = this.u = this.v = this.w = this.x = this.y = this.z = 0;
		this.first = 0;
	}
	
	public void CountLetras(String word) {
		
		this.first = word.toUpperCase().charAt(0);		
		switch (this.first) {
			case 'A': this.a++;
				break;
			case 'B': this.b++;
				break;
			case 'C': this.c++;
				break;
			case 'D': this.d++;
				break;
			case 'E': this.e++;
				break;
			case 'F': this.f++;
				break;
			case 'G': this.g++;
				break;
			case 'H': this.h++;
				break;
			case 'I': this.i++;
				break;
			case 'J': this.j++;
				break;
			case 'K': this.k++;
				break;
			case 'L': this.l++;
				break;
			case 'M': this.m++;
				break;
			case 'N': this.n++;
				break;
			case 'O': this.o++;
				break;
			case 'P': this.p++;
				break;
			case 'Q': this.q++;
				break;
			case 'R': this.r++;
				break;
			case 'S': this.s++;
				break;
			case 'T': this.t++;
				break;
			case 'U': this.u++;
				break;
			case 'V': this.v++;
				break;
			case 'W': this.w++;
				break;
			case 'X': this.x++;
				break;
			case 'Y': this.y++;
				break;
			case 'Z': this.z++;
				break;
			default: System.out.println("Letra não encontrada: "+first);
				break;
		}
	}
	
	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getC() {
		return c;
	}

	public int getD() {
		return d;
	}

	public int getE() {
		return e;
	}

	public int getF() {
		return f;
	}

	public int getG() {
		return g;
	}

	public int getH() {
		return h;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public int getK() {
		return k;
	}

	public int getL() {
		return l;
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}

	public int getO() {
		return o;
	}

	public int getP() {
		return p;
	}

	public int getQ() {
		return q;
	}

	public int getR() {
		return r;
	}
	
	public int getS() {
		return s;
	}
	
	public int getT() {
		return t;
	}

	public int getU() {
		return u;
	}
	
	public int getV() {
		return v;
	}

	public int getW() {
		return w;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
}

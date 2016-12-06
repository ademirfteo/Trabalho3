
public class Word {
	
	private String descricao;
	private boolean cultura;
	private boolean drogas;
	private boolean educacao;
	private boolean emprego;
	private boolean esporte;
	private boolean habitacao;
	private boolean infraestrutura;
	private boolean meioambiente;
	private boolean mobilidade;	
	private boolean seguranca;
	private boolean saude;
	private boolean social;
	
	public Word() {}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isCultura() {
		return cultura;
	}
	public void setCultura(boolean cultura) {
		this.cultura = cultura;
	}

	public boolean isDrogas() {
		return drogas;
	}
	public void setDrogas(boolean drogas) {
		this.drogas = drogas;
	}

	public boolean isEducacao() {
		return educacao;
	}
	public void setEducacao(boolean educacao) {
		this.educacao = educacao;
	}

	public boolean isEmprego() {
		return emprego;
	}
	public void setEmprego(boolean emprego) {
		this.emprego = emprego;
	}

	public boolean isEsporte() {
		return esporte;
	}
	public void setEsporte(boolean esporte) {
		this.esporte = esporte;
	}

	public boolean isHabitacao() {
		return habitacao;
	}
	public void setHabitacao(boolean habitacao) {
		this.habitacao = habitacao;
	}

	public boolean isInfraestrutura() {
		return infraestrutura;
	}
	public void setInfraestrutura(boolean infraestrutura) {
		this.infraestrutura = infraestrutura;
	}

	public boolean isMeioambiente() {
		return meioambiente;
	}
	public void setMeioambiente(boolean meioambiente) {
		this.meioambiente = meioambiente;
	}

	public boolean isMobilidade() {
		return mobilidade;
	}
	public void setMobilidade(boolean mobilidade) {
		this.mobilidade = mobilidade;
	}

	public boolean isSeguranca() {
		return seguranca;
	}
	public void setSeguranca(boolean seguranca) {
		this.seguranca = seguranca;
	}

	public boolean isSaude() {
		return saude;
	}
	public void setSaude(boolean saude) {
		this.saude = saude;
	}

	public boolean isSocial() {
		return social;
	}
	public void setSocial(boolean social) {
		this.social = social;
	}

	public int hashCode() {
		return getDescricao().length() * 8;
	}
	
	public boolean equals(Object o) {
		if ((o instanceof Word) && ((Word) o).getDescricao().equals(this.getDescricao())) {
			return true;
		} else {
			return false;
		}
	}
}

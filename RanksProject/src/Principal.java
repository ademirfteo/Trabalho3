import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<String> arrayWord = new ArrayList<String>();
		String [] linha;
		String [] palavras;
		String palavra;
		String insertProjeto, insertPrjArea;
		String numPrj, descrPrj, percent;
		int opcao = 0;
		double cul = 0;
		double dro = 0;
		double edu = 0;
		double emp = 0;
		double esp = 0;
		double hab = 0;
		double inf = 0;
		double mam = 0;
		double mob = 0;
		double seg = 0;
		double sau = 0;
		double soc = 0;
		double peso = 0;
				
		Dictionary dic = new Dictionary();
		Letra letra = new Letra();
		HashTable hashTable = new HashTable();
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"O que deseja fazer? " +
																	  "\n Digite 1 Gerar Dicionário." +
																	  "\n Digite 2 Gerar Tabela Hash." +
																	  "\n Digite 3 Classificar Projetos." +
																	  "\n Digite 4 para Sair."));
			switch (opcao) {
				case 1:					
					try {
						// LÊ ARQUIVO DE PROJETOS
						CSVFile csvFile = new CSVFile("data/projetos.csv");
						while(csvFile.hasNext()) {
							linha = csvFile.next();							
							palavras = linha[4].split(" ");
							for (String p : palavras) {								
								palavra = dic.ClearWord(p);								
								if (dic.FilterWord(palavra) == false) {
									if (dic.ConsultaArray(palavra) == false) {
										dic.AddArray(palavra);
									}
								}
							}
						}
						
						// GERA ARQUIVO DICIONÁRIO
						arrayWord = dic.getArrayWord();						
						if (arrayWord.size() > 0) {
							
							BufferedWriter buffer = csvFile.CreateFile("data/dicionario.csv");							
							csvFile.AddLineFile(buffer, "DESCRICAO;CUL;DRO;EDU;EMP;ESP;HAB;INF;MAM;MOB;SEG;SAU;SOC;");
							for (String w : arrayWord) {								
								csvFile.AddLineFile(buffer, w+";0;0;0;0;0;0;0;0;0;0;0;0");
								letra.CountLetras(w);
							}		
							csvFile.CloseFile(buffer);
						}
						JOptionPane.showMessageDialog(null,"INFO: Dicionário gerado com sucesso!");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null,"ERRO: Arquivo não encontrado!");
					} catch (IOException e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(null,"ERRO: Ao gerar dicionário!");
					}						
					break;
				case 2:
					/*				
					HashMap<String,Word> hash = new HashMap<String,Word>();
					
					hash.put("helicoptero", new Word("helicoptero", false, false, false, false, false, false, false, false, true, false, false, false));
					hash.put("taxi", new Word("taxi", false, false, false, false, false, false, false, false, true, false, false, false));
					hash.put("moto", new Word("moto", false, false, false, false, false, false, false, false, true, false, false, false));	
                            		
					Word info = hash.get("moto");
					System.out.println(info.getDescricao());
					*/
					if (dic.getArrayWord().size() > 0) {
						try {						
							CSVFile csvDicionario = new CSVFile("data/dicionario.csv");
							hashTable.BeginHashTable(letra);
							while(csvDicionario.hasNext()) {
								linha = csvDicionario.next();
								if (!linha[0].equals("")) {
									Word word = new Word();
									word.setDescricao(linha[0]);
									if (linha[1].equals("0")) {word.setCultura(false);} else {word.setCultura(true);}
									if (linha[2].equals("0")) {word.setDrogas(false);} else {word.setDrogas(true);}
									if (linha[3].equals("0")) {word.setEducacao(false);} else {word.setEducacao(true);}
									if (linha[4].equals("0")) {word.setEmprego(false);} else {word.setEmprego(true);}
									if (linha[5].equals("0")) {word.setEsporte(false);} else {word.setEsporte(true);}
									if (linha[6].equals("0")) {word.setHabitacao(false);} else {word.setHabitacao(true);}
									if (linha[7].equals("0")) {word.setInfraestrutura(false);} else {word.setInfraestrutura(true);}
									if (linha[8].equals("0")) {word.setMeioambiente(false);} else {word.setMeioambiente(true);}
									if (linha[9].equals("0")) {word.setMobilidade(false);} else {word.setMobilidade(true);}
									if (linha[10].equals("0")) {word.setSeguranca(false);} else {word.setSeguranca(true);}
									if (linha[11].equals("0")) {word.setSaude(false);} else {word.setSaude(true);}
									if (linha[12].equals("0")) {word.setSocial(false);} else {word.setSocial(true);}
									hashTable.AddTabelaHash(word);										
								}									
							}
							System.out.println("adicionados: "+hashTable.getQtdItens());
							System.out.println("conflitos: "+hashTable.getConflitos());
						} catch (FileNotFoundException e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(null,"ERRO: Dicionário não encontrado!");
						}
					} else {
						JOptionPane.showMessageDialog(null,"INFO: Dicionário não carregado!");
					}
					break;
				case 3:
					if (hashTable.getTamanho() > 1) {
						try {							
							CSVFile csvProjetos = new CSVFile("data/projetos.csv");
							BufferedWriter buffer = csvProjetos.CreateFile("data/insert.sql");
							DecimalFormat df = new DecimalFormat("0.00");
							df.setRoundingMode(RoundingMode.UP);							
							
							while(csvProjetos.hasNext()) {								
								linha = csvProjetos.next();
								numPrj = linha[0]; 
								descrPrj =  linha[4];
								palavras = linha[4].split(" ");								
								cul = dro = edu = emp = esp = hab = inf = mam = mob = seg = sau = soc = peso = 0;
								
								for (String p : palavras) {							
									palavra = dic.ClearWord(p);									
									if (dic.FilterWord(palavra) == false) {
										Word w = hashTable.SearchTabelaHash(palavra);
										if (w != null) {
											if (w.isCultura() == true) {cul++;}
											if (w.isDrogas() == true) {dro++;}
											if (w.isEducacao() == true) {edu++;}
											if (w.isEmprego() == true) {emp++;}
											if (w.isEsporte() == true) {esp++;}
											if (w.isHabitacao() == true) {hab++;}
											if (w.isInfraestrutura() == true) {inf++;}
											if (w.isMeioambiente() == true) {mam++;}
											if (w.isMobilidade() == true) {mob++;}
											if (w.isSaude() == true) {sau++;}
											if (w.isSocial() == true) {soc++;}
										}
									}	
								}
								if ((cul + dro + edu + emp + esp + hab + inf + mam + mob + seg + sau + soc) > 0) {
									peso = 100 / (cul + dro + edu + emp + esp + hab + inf + mam + mob + seg + sau + soc);
								} else {
									peso = 0;
								}
								
								descrPrj = descrPrj.replaceAll("\"", "");
								descrPrj = descrPrj.replaceAll("\'", "");
								insertProjeto = "INSERT INTO perfil.projeto (idProjeto, Autor, Nome, Descricao) VALUES ("+numPrj+","+1+",null,"+"'"+descrPrj+"'"+");";								
								csvProjetos.AddLineFile(buffer, insertProjeto);
								percent = df.format(cul*peso).replaceAll(",", ".");
								insertPrjArea = "INSERT INTO perfil.projetoarea (idProjeto, idArea, Percentual) VALUES ("+numPrj+","+1+","+percent+");";
								csvProjetos.AddLineFile(buffer, insertPrjArea);
								percent = df.format(dro*peso).replaceAll(",", ".");
								insertPrjArea = "INSERT INTO perfil.projetoarea (idProjeto, idArea, Percentual) VALUES ("+numPrj+","+2+","+percent+");";
								csvProjetos.AddLineFile(buffer, insertPrjArea);
								percent = df.format(edu*peso).replaceAll(",", ".");
								insertPrjArea = "INSERT INTO perfil.projetoarea (idProjeto, idArea, Percentual) VALUES ("+numPrj+","+3+","+percent+");";
								csvProjetos.AddLineFile(buffer, insertPrjArea);
								percent = df.format(emp*peso).replaceAll(",", ".");
								insertPrjArea = "INSERT INTO perfil.projetoarea (idProjeto, idArea, Percentual) VALUES ("+numPrj+","+4+","+percent+");";
								csvProjetos.AddLineFile(buffer, insertPrjArea);
								percent = df.format(esp*peso).replaceAll(",", ".");
								insertPrjArea = "INSERT INTO perfil.projetoarea (idProjeto, idArea, Percentual) VALUES ("+numPrj+","+5+","+percent+");";
								csvProjetos.AddLineFile(buffer, insertPrjArea);
								percent = df.format(hab*peso).replaceAll(",", ".");
								insertPrjArea = "INSERT INTO perfil.projetoarea (idProjeto, idArea, Percentual) VALUES ("+numPrj+","+6+","+percent+");";
								csvProjetos.AddLineFile(buffer, insertPrjArea);
								percent = df.format(inf*peso).replaceAll(",", ".");
								insertPrjArea = "INSERT INTO perfil.projetoarea (idProjeto, idArea, Percentual) VALUES ("+numPrj+","+7+","+percent+");";
								csvProjetos.AddLineFile(buffer, insertPrjArea);
								percent = df.format(mam*peso).replaceAll(",", ".");
								insertPrjArea = "INSERT INTO perfil.projetoarea (idProjeto, idArea, Percentual) VALUES ("+numPrj+","+8+","+percent+");";
								csvProjetos.AddLineFile(buffer, insertPrjArea);
								percent = df.format(mob*peso).replaceAll(",", ".");
								insertPrjArea = "INSERT INTO perfil.projetoarea (idProjeto, idArea, Percentual) VALUES ("+numPrj+","+9+","+percent+");";
								csvProjetos.AddLineFile(buffer, insertPrjArea);
								percent = df.format(seg*peso).replaceAll(",", ".");
								insertPrjArea = "INSERT INTO perfil.projetoarea (idProjeto, idArea, Percentual) VALUES ("+numPrj+","+10+","+percent+");";
								csvProjetos.AddLineFile(buffer, insertPrjArea);
								percent = df.format(sau*peso).replaceAll(",", ".");
								insertPrjArea = "INSERT INTO perfil.projetoarea (idProjeto, idArea, Percentual) VALUES ("+numPrj+","+11+","+percent+");";
								csvProjetos.AddLineFile(buffer, insertPrjArea);
								percent = df.format(soc*peso).replaceAll(",", ".");
								insertPrjArea = "INSERT INTO perfil.projetoarea (idProjeto, idArea, Percentual) VALUES ("+numPrj+","+12+","+percent+");";
								csvProjetos.AddLineFile(buffer, insertPrjArea);								
							}
							csvProjetos.CloseFile(buffer);
							JOptionPane.showMessageDialog(null,"INFO: Projetos classificados com sucesso!");
						} catch (FileNotFoundException e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(null,"ERRO: Ao classificar projetos!");						
						} catch (IOException e) {						
							e.printStackTrace();
							JOptionPane.showMessageDialog(null,"ERRO: Ao gerar dicionário!");
						}
					} else {
						JOptionPane.showMessageDialog(null,"INFO: Tabela Hash não iniciada!");
					}
					break;
				case 4:
					JOptionPane.showMessageDialog(null,"Fim");
					return;
				default:
					JOptionPane.showMessageDialog(null,"ERRO: Opção inválida!");
			}
			
		} while (opcao != 4);		
	}
}

package evaluator.main;

import evaluator.controller.AppController;
import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.InputValidationFailedException;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.model.Intrebare;
import evaluator.model.Statistica;
import evaluator.model.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//functionalitati
//i.	 adaugarea unei noi intrebari pentru un anumit domeniu (enunt intrebare, raspuns 1, raspuns 2, raspuns 3, raspunsul corect, domeniul) in setul de intrebari disponibile;
//ii.	 crearea unui nou test (testul va contine 5 intrebari alese aleator din cele disponibile, din domenii diferite);
//iii.	 afisarea unei statistici cu numarul de intrebari organizate pe domenii.

public class StartApp {

	static AppController appController;

	private static final String file = "intrebari.txt";
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		appController = new AppController();
		
		boolean activ = true;
		String optiune = null;
		
		while(activ){
			
			System.out.println("");
			System.out.println("1.Adauga intrebare");
			System.out.println("2.Creeaza test");
			System.out.println("3.Statistica");
			System.out.println("4.Exit");
			System.out.println("");
			
			optiune = console.readLine();
			
			switch(optiune){
			case "1" :
				System.out.println("Dati enuntul intrebarii:");
				String enunt = console.readLine();
				System.out.println("Dati prima varianta a intrebarii:");
				String varianta1 = console.readLine();
				System.out.println("Dati a doua varianta a intrebarii:");
				String varianta2 = console.readLine();
				System.out.println("Dati a treia varianta a intrebarii:");
				String varianta3 = console.readLine();
				System.out.println("Dati varianta corecta a intrebarii:");
				String raspuns = console.readLine();
				System.out.println("Dati domeniul intrebarii:");
				String domeniu = console.readLine();
				try {
					addIntrebare(enunt, varianta1, varianta2, varianta3, raspuns, domeniu);
				} catch (InputValidationFailedException | DuplicateIntrebareException e) {
					System.out.println(e.getMessage());
				}
				break;
			case "2" :
				try {
					Test test = appController.createNewTest();
					System.out.println(test);
				} catch (NotAbleToCreateTestException e) {
					System.out.println(e.getMessage());
				}
				break;
			case "3" :
				appController.loadIntrebariFromFile(file);
				Statistica statistica;
				try {
					statistica = appController.getStatistica();
					System.out.println(statistica);
				} catch (NotAbleToCreateStatisticsException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case "4" :
				activ = false;
				break;
			default:
				break;
			}
		}
		
	}

	public static void addIntrebare(String enunt, String varianta1, String varianta2, String varianta3, String raspuns, String domeniu) throws InputValidationFailedException, DuplicateIntrebareException {
		Intrebare intrebare = new Intrebare(enunt,varianta1,varianta2,varianta3,raspuns,domeniu);
		appController.addNewIntrebare(intrebare);
	}

}

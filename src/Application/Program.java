package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Departament;
import Entities.HourContract;
import Entities.Worker;
import Entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Enter departament's name: ");
		String name_dep = sc.nextLine();
		System.out.println("Enter the worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(name_dep));
		
		System.out.print("How many contracts to this worker: ");
		int quantity_contracts = sc.nextInt();
		
		for(int i=1; i<=quantity_contracts;i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contract_date = sdf.parse(sc.next());
			System.out.print("Valeu per hour: ");
			double valueHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hour = sc.nextInt();
			HourContract contract = new HourContract(contract_date, valueHour, hour);
			worker.addContract(contract);
						
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Departament: " + worker.getDepartament().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		
		sc.close();
		
	}

}

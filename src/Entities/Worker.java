package Entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double salary;
	
	private Worker () {
		
	}

	private Departament departament;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker(String name, WorkerLevel level, Double salary, Departament departament) {
		this.name = name;
		this.level = level;
		this.salary = salary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	
	public void addContract (HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract (HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income (int year, int month) {
		
		Calendar cal = Calendar.getInstance();
		
		for(HourContract c: contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			
			if(year == c_year && month == c_month ) {
				salary += c.totalValue();
			}
									
		}
		return salary;
	}
	
}

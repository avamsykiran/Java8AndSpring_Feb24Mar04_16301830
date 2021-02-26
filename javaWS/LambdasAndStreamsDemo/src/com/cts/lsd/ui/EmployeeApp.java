package com.cts.lsd.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cts.lsd.model.Employee;
import com.cts.lsd.service.EmployeeBasicComparator;

public class EmployeeApp {

	public static void main(String[] args) {

		List<Employee> emps = Arrays.asList(new Employee[] {
				new Employee(101, "Vamsy", 5642.0,"DEV",new String[] {"JAVA","SPRING","ANGULAR"}),
				new Employee(104, "Anu", 5142.0,"OPS",new String[] {"JAVA","JENKINS","AWS"}),
				new Employee(105, "Bhanu", 1642.0,"TEST",new String[] {"JAVA","SELENIUM","JUNIT"}),
				new Employee(102, "Prem", 5642.0,"TEST",new String[] {"C#","SELENIUM","NUNIT"}),
				new Employee(110, "Chiru", 7642.0,"DEV",new String[] {"C#","ASP.net","REACTJS"}),
				new Employee(107, "Deepa", 9642.0,"DEV",new String[] {"C#","ASP.net","Angular"}),
				new Employee(109, "Eithar", 5842.0,"OPS",new String[] {"C#","AZURE","GCP"})
		});
		
		Collections.sort(emps);
		for(Employee e:emps) {
			System.out.println(e);
		}
		System.out.println("------------------------------------------------");
		Collections.sort(emps,new EmployeeBasicComparator());
		for(Employee e:emps) {
			System.out.println(e);
		}
		System.out.println("------------------------------------------------");
		Collections.sort(emps,(e1,e2) -> e1.getName().compareTo(e2.getName()));
		for(Employee e:emps) {
			System.out.println(e);
		}
		System.out.println("------------------------------------------------");
		//emps.stream().forEach((e) -> {System.out.println(e);});
		emps.stream().forEach(System.out::println);
		System.out.println("------------------------------------------------");
		emps.stream().filter(e -> e.getBasic()>6500.0).forEach(System.out::println);
		System.out.println("------------------------------------------------");
		List<Employee> lowPaid = emps.stream()
				.filter(e -> e.getBasic()<6000.0)
				.filter(e -> e.getName().indexOf('a')>-1)
				.collect(Collectors.toList());
		System.out.println(lowPaid);
		System.out.println("------------------------------------------------");
		Map<String,List<Employee>> empMap = 
				emps.stream().collect(Collectors.toMap(Employee::getDept,
						e -> Arrays.asList(new Employee[] {e}),
						(list1,list2) -> {
							List<Employee> finalList = new ArrayList<>();
							finalList.addAll(list1);
							finalList.addAll(list2);
							return finalList;
							}
						));	
		System.out.println(empMap);
		System.out.println("------------------------------------------------");
		emps.stream().map(e -> e.getName()).forEach(System.out::println);
		System.out.println("------------------------------------------------");	
		System.out.println(emps.stream()
				.reduce((e1,e2) -> e1.getBasic()>e2.getBasic()?e1:e2).orElse(null));
		System.out.println("------------------------------------------------");
		emps.stream().map(e -> e.getSkills()).forEach(r -> {System.out.println(Arrays.toString(r));});
		System.out.println("------------------------------------------------");
		emps.stream().flatMap(e -> Stream.of(e.getSkills())).forEach(System.out::println);
		System.out.println("------------------------------------------------");
		emps.stream().flatMap(e -> Stream.of(e.getSkills()))
		.distinct().forEach(System.out::println);
		System.out.println("------------------------------------------------");
		emps.stream().flatMap(e -> Stream.of(e.getSkills()))
			.distinct().sorted().forEach(System.out::println);
		System.out.println("------------------------------------------------");
		emps.stream().sorted((e1,e2) -> e1.getName().compareTo(e2.getName()))
			.forEach(System.out::println);
		
	}

}

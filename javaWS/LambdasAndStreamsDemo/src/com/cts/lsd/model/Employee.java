package com.cts.lsd.model;

import java.util.Arrays;

public class Employee implements Comparable<Employee>{
	
	private int empId;
	private String name;
	private double basic;
	private String dept;
	private String[] skills;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String name, double basic, String dept, String[] skills) {
		super();
		this.empId = empId;
		this.name = name;
		this.basic = basic;
		this.dept = dept;
		this.skills = skills;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	@Override
	public int compareTo(Employee o) {
		return ((Integer)this.empId).compareTo(o.empId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(basic);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + empId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(skills);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (Double.doubleToLongBits(basic) != Double.doubleToLongBits(other.basic))
			return false;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (empId != other.empId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(skills, other.skills))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", basic=" + basic + ", dept=" + dept + ", skills="
				+ Arrays.toString(skills) + "]";
	}

	
}

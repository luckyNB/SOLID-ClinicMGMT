package com.clinic.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.clinic.model.Appointment;
import com.clinic.model.Doctor;
import com.clinic.model.Patients;
import com.clinic.util.Utility;

public class InformationDisplayImplementation //implements InformationDisplay 
{
	static ObjectMapper mapper = new ObjectMapper();
	List<Patients> personlist = new ArrayList<>(); // to store data in arraylist
	List<Doctor> doctorlist = new ArrayList<>();
	List<Appointment> appointmentlist = new ArrayList<>();

	{
		try {
			// to read files
			personlist = mapper.readValue(new File(
					"/home/admin111/Spring Modules/DDD/clinic/src/main/java/com/jsonfiles/Patients.json"),
					new TypeReference<List<Patients>>() {
					});
			doctorlist = mapper.readValue(new File(
					"/home/admin111/Spring Modules/DDD/clinic/src/main/java/com/jsonfiles/Doctors.json"),
					new TypeReference<List<Doctor>>() {
					});
			appointmentlist = mapper.readValue(new File(
					"/home/admin111/Spring Modules/DDD/clinic/src/main/java/com/jsonfiles/Appointment.json"),
					new TypeReference<List<Appointment>>() {
					});

		} catch (Exception e) {

		}
	}

	public void operation() {
		int Answer = 0;
		do {
			System.out.println("\n1. Print Doctors Information");
			System.out.println("2. Print Patients Information");
			System.out.println("3. Exit");
			Answer = Utility.inputInteger();
			switch (Answer) {
			case 1:
				doctorInformation(); // print doctors data
				break;
			case 2:
				patientInformation(); // print patients data
				break;
			case 3:
				break;
			default:
				System.out.println("Invalid Entry");
			}
		} while (Answer != 3);
	}

	
	// to print patient data
	public void patientInformation() {
		// TODO Auto-generated method stub
		// String spaces=" ";
		System.out.println("Name     id \t Phone  \tage");
		personlist.stream().forEach(i -> {
			System.out.println(i.getName() + "\t  " + i.getId() + "\t" + i.getPhone() + "\t" + i.getAge());
		});

	}

	
	// to print doctors data
	public void doctorInformation() {
		// TODO Auto-generated method stub
		System.out.println("Name     id  availability  specialization");
		doctorlist.stream().forEach(i -> {
			System.out.println(
					i.getName() + "\t  " + i.getId() + "\t" + i.getAvailability() + "\t\t" + i.getSpecialization());
		});
	}

}
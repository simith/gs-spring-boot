package com.example.springboot;

import com.example.db.DbConnection;
import com.example.db.Doctor;
import com.example.db.SlotDetailsRequestModel;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {


	@GetMapping("/doctors")
	public String doctors() {

		Gson gson = new Gson();
		List<Doctor> doctors = DbConnection.getAllDoctors();

		return gson.toJson(doctors);
	}

	@PostMapping("/slots")
	public String slots(@RequestBody SlotDetailsRequestModel slotDetailsRequest) {


		int lReturn = DbConnection.insertIntoSlots(slotDetailsRequest.getSelectedSlot(),
				slotDetailsRequest.getBookingDate(),
				Integer.parseInt(slotDetailsRequest.getSelectedDoctorId()),
				slotDetailsRequest.getNoteToDoctor());

		return "ok";
	}


}

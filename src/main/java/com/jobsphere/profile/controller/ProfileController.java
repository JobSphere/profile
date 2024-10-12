package com.jobsphere.profile.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobsphere.profile.model.Profile;
import com.jobsphere.profile.model.Response;
import com.jobsphere.profile.service.ProfileService;



@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;

	@PostMapping
	public ResponseEntity<Response<?>> create(
		@RequestParam String first_name,
		@RequestParam String last_name,
		@RequestParam String account_type
		) {

		Profile profile  = profileService.create(first_name, last_name, account_type);
		
		return read(profile.getId());
	}

	@GetMapping
	public ResponseEntity<Response<?>> read(@RequestParam UUID profile_id) {
		Profile profile  = profileService.read(profile_id);
		return ResponseEntity.ok(new Response<>(HttpStatus.OK.value(), "success", profile));
	}
	
	@PutMapping
	public ResponseEntity<Response<?>> update(
		@RequestParam UUID profile_id,
		@RequestParam String first_name,
		@RequestParam String last_name,
		@RequestParam String account_type,
		@RequestParam Long phone,
		@RequestParam String email
		) {
		Profile profile = profileService.update(profile_id, first_name, last_name, account_type, phone, email);
		return read(profile.getId());
	}
	
	@DeleteMapping
	public ResponseEntity<Response<?>> delete(UUID profile_id) {
		profileService.delete(profile_id);
		return ResponseEntity.ok(new Response<>(HttpStatus.OK.value(), "success", null));
	}
}
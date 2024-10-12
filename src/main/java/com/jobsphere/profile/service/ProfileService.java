package com.jobsphere.profile.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jobsphere.profile.model.Profile;

@Service
public class ProfileService {

	Map<UUID, Profile> map = new HashMap<>();

	public Profile create(String first_name, String last_name, String account_type) {
		if(first_name.isEmpty() || last_name.isEmpty()) {
			return null;
		}

		Profile profile = new Profile(first_name, last_name, account_type);

		map.put(profile.getId(), profile);
		return read(profile.getId());
	}

	public Profile read(UUID profile_id) {
		return map.get(profile_id);
	}

	public Profile update(UUID profile_id, String first_name, String last_name, String account_type, Long phone, String email) {
		Profile existing_profile = map.get(profile_id);

		if(!first_name.isEmpty())
			existing_profile.setFirstName(first_name);
		
		if(!last_name.isEmpty())
			existing_profile.setLastName(last_name);

		if(phone != null)
			existing_profile.setPhone(phone);

		if(!email.isEmpty())
			existing_profile.setEmail(email);

		return existing_profile;
		
	}

	public Boolean delete(UUID profile_id) {
		map.remove(profile_id);
		return map.containsKey(profile_id);
	}
}

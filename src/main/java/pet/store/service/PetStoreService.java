package pet.store.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {
	@Autowired
	private PetStoreDao petStoreDao;

	@Transactional(readOnly = false)
	public PetStoreData savePetStore(PetStoreData petStoreData) {
		
		Long petStoreId = petStoreData.getPet_store_id();
		PetStore petStore = findOrCreatePetStore(petStoreId);
		copyPetStoreFields(petStore, petStoreData);
		return new PetStoreData(petStoreDao.save(petStore));
	}


	private void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
		petStore.setPet_store_address(petStoreData.getPet_store_address());
		petStore.setPet_store_city(petStoreData.getPet_store_city());
		petStore.setPet_store_id(petStoreData.getPet_store_id());
		petStore.setPet_store_name(petStoreData.getPet_store_name());
		petStore.setPet_store_phone(petStoreData.getPet_store_phone());
		petStore.setPet_store_state(petStoreData.getPet_store_state());
		petStore.setPet_store_zip(petStoreData.getPet_store_zip());		
	}


	private PetStore findOrCreatePetStore(Long pet_store_id) {
		
		
		if(Objects.isNull(pet_store_id)) {
			return new PetStore();
		}
		else {
			return findPetStoreById(pet_store_id);
		}
		
	}

	private PetStore findPetStoreById(Long pet_store_id) {
		return petStoreDao.findById(pet_store_id).orElseThrow(() -> new NoSuchElementException("Pet Store with ID=" + pet_store_id + " was not found."));
		
	}
}

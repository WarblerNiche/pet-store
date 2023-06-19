package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor
public class PetStoreData {
	
	private Long pet_store_id;
	private String pet_store_name;
	private String pet_store_address;
	private String pet_store_city;
	private String pet_store_state;
	private String pet_store_zip;
	private String pet_store_phone;
	private Set<PetStoreCustomer> customers = new HashSet<>();
	private Set<PetStoreEmployee> employees = new HashSet<>();
	
	public PetStoreData(PetStore petStore) {
		pet_store_id = petStore.getPet_store_id();
		pet_store_name = petStore.getPet_store_name();
		pet_store_address = petStore.getPet_store_address();
		pet_store_city = petStore.getPet_store_city();
		pet_store_state = petStore.getPet_store_state();
		pet_store_zip = petStore.getPet_store_zip();
		pet_store_phone = petStore.getPet_store_phone();
		
		for(Customer customer : petStore.getCustomers()) {
			customers.add(new PetStoreCustomer(customer));
		}
		
		for(Employee employee : petStore.getEmployees()) {
			employees.add(new PetStoreEmployee(employee));
		}
	}
	
	@Data
	@NoArgsConstructor
	public static class PetStoreCustomer {
		private Long customer_id;
		private String customer_first_name;
		private String customer_last_name;
		private String customer_email;
		//private Set<PetStore> petStores = new HashSet<>();
		
		public PetStoreCustomer(Customer customer) {
			customer_id = customer.getCustomer_id();
			customer_first_name = customer.getCustomer_first_name();
			customer_last_name = customer.getCustomer_last_name();
			customer_email = customer.getCustomer_email();
		}
	}
	
	@Data
	@NoArgsConstructor
	public static class PetStoreEmployee {
		private Long employee_id;
		private String employee_first_name;
		private String employee_last_name;
		private String employee_phone;
		private String employee_job_title;
		
		public PetStoreEmployee(Employee employee) {
			employee_first_name = employee.getEmployee_first_name();
			employee_last_name = employee.getEmployee_last_name();
			employee_phone = employee.getEmployee_phone();
			employee_job_title = employee.getEmployee_job_title();
		}
	}

}

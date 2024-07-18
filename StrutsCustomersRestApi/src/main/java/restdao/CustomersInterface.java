package restdao;

import java.util.List;
import java.util.Map;

import restmodel.Customer;

public interface CustomersInterface {

	abstract List<Customer> getAllCustomers();
	abstract Map<String,Object> getCustomerById(int id);
	abstract void createCustomer(Customer c);
	abstract void updateCustomer(Customer c);
	abstract void deleteCustomer(int id);
    abstract List<Map<String, Object>> getTotalCutomers();

}

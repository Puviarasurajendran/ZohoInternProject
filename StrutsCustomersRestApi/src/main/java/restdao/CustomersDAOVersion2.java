package restdao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomersDAOVersion2 extends CustomersDAO{




	public CustomersDAOVersion2() {
	   System.out.println("CustomersDAOVersion2 object created succesfully");
	}

	@Override
	public List<Map<String, Object>> getTotalCutomers() {

		List<Map<String, Object>> listOfCutomers = super.getTotalCutomers();
		List<Map<String, Object>> updatedCutomersList = listOfCutomers.stream()
				.map(dataMap -> {
					Map<String, Object> fullnameMap = new HashMap<>();
					fullnameMap.put("first name", dataMap.remove("first name"));
					fullnameMap.put("last name", dataMap.remove("last name"));
					dataMap.put("full name", fullnameMap);
					return dataMap;
				}).collect(Collectors.toList());

		return updatedCutomersList;

	}

	@Override
	public Map<String, Object> getCustomerById(int id) {

		Map<String, Object> cutomerMap = new HashMap<>();
		cutomerMap = super.getCustomerById(id);
		System.out.println("Inside CustomersDAO getCustomerByIdVersion2 Method " + cutomerMap);
		if (cutomerMap != null) {
			HashMap fullNameMap = new HashMap();
			fullNameMap.put("First name", cutomerMap.remove("first name"));
			fullNameMap.put("Last name", cutomerMap.remove("last name"));
			cutomerMap.put("full name", fullNameMap);
		}

		return cutomerMap;
	}

}

package restaction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.dispatcher.mapper.DefaultActionMapper;

import com.opensymphony.xwork2.config.ConfigurationManager;

public class CustomActionMapper  extends DefaultActionMapper{


	@Override
	public ActionMapping getMapping(HttpServletRequest request, ConfigurationManager configManager) {
	//	throw new UnsupportedOperationException("Unimplemented method 'getMapping'");
		System.out.println("Inside Action mapper classsss");
		return super.getMapping(request, configManager);
	}


}

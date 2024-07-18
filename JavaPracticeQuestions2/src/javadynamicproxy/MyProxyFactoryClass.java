package javadynamicproxy;

public class MyProxyFactoryClass {
	
	private HelperProxyfactoryInterface target;

	public MyProxyFactoryClass(HelperProxyfactoryInterface target) {
		this.target = target;
	}
	
	public String onprocessingData() {
		return target.display();
		
	}

}

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Main2 {

	public static void main(String[] args) throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
		jndiProperties.put("jboss.naming.client.ejb.context",true);
		
		Context jndi = new InitialContext(jndiProperties);
		
		ShoppingCartSession cart = (ShoppingCartSession) jndi.lookup("ShoppingCartServerApplication/ShoppingCartSessionImplementation!ShoppingCartSession");
		
		cart.addItem("Bath towels");
		cart.addItem("soap");
		List<String> items = cart.getCartContents();
		for (String item : items) {
			System.out.println(item);
		}
		
		cart.checkout();
	}

}

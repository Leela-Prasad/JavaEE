import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class ShoppingCartSessionImplementation implements ShoppingCartSession {

	//This is the state for this bean
	//and will be specific to each client.
	//A better solution would be using a stateless bean while the state is stored in the database
	//and when the client comes back we can retrieve the state from the database, this way we can 
	//avoid large number of stateful bean created in the Application Server.
	private List<String> items;
	
	public ShoppingCartSessionImplementation() {
		this.items = new ArrayList<String>();
	}

	public void addItem(String newItem) {
		this.items.add(newItem);
		
	}

	public List<String> getCartContents() {
		return this.items;
	}

	//** This Remove Annotation is very Important 
	//After completion of this method our stateful bean 
	//will be removed from the server.
	@Remove
	public void checkout() {
		// add the items to a database or something
	}
	
	
}

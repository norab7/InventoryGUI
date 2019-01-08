package baron.rol.Inventory;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class InventoryStore {
	private final int INVSIZE = 54;
	private HashMap<Player, InventoryBuilder> playerInvs = new HashMap<>();

	// ### Contructors ##
	public InventoryStore() {

	}
	//

	// ### Get Player Inventory ###
	public InventoryBuilder getInventoryBuilder(Player p) {
		return playerInvs.get(p);
	}
	//

	// ### Create Player Inventory ###
	public InventoryBuilder createInventoryBuilder(Player p) {
		return this.createInventoryBuilder(p, this.INVSIZE, p.getName());
	}

	public InventoryBuilder createInventoryBuilder(Player p, int n) {
		return this.createInventoryBuilder(p, n, p.getName());
	}

	public InventoryBuilder createInventoryBuilder(Player p, String s) {
		return this.createInventoryBuilder(p, INVSIZE, s);
	}

	public InventoryBuilder createInventoryBuilder(Player p, int n, String s) {
		return new InventoryBuilder(p, n, s);
	}
	//

	// ### Remove Player Inventory ###
	public void removeInventoryBuilder(Player p) {
		playerInvs.remove(p);
	}
	//

}

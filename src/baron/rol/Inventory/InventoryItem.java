package baron.rol.Inventory;

import java.util.UUID;

import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public abstract class InventoryItem extends ItemStack {
	private final UUID UID = UUID.randomUUID();
	private final ItemStack item;

	// ### Constructors ###
	public InventoryItem(ItemStack item) {
		this.item = item;
	}
	//

	// ### Gettters ###
	public UUID getUID() {
		return UID;
	}

	public ItemStack getItem() {
		return item;
	}
	//

	// ### Abstract Methods ###
	public abstract void action(InventoryClickEvent e);
	//

}

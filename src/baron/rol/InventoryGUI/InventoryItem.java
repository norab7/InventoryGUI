package baron.rol.InventoryGUI;

import java.util.UUID;

import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public abstract class InventoryItem extends ItemStack {
	// private final UUID UID = UUID.randomUUID();
	private ItemStack item;

	// public UUID getUID() {
	// return UID;
	// }

	public ItemStack getItem() {
		return item;
	}

	public void setItem(ItemStack item) {
		this.item = item;
	}

	public abstract void action(ClickType c);

}

package baron.rol.InventoryGUI;

import java.util.UUID;

import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public abstract class InventoryItem extends ItemStack {
	private final UUID UID = UUID.randomUUID();

	public UUID getUID() {
		return UID;
	}

	public abstract void action(ClickType c);

	protected abstract void leftClick();

	protected abstract void rightClick();

	protected abstract void middleClick();

}

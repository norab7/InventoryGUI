package baron.rol.InventoryGUI;

import java.util.UUID;

public abstract class InventoryItem {
	private final UUID UID = UUID.randomUUID();

	public UUID getUID() {
		return UID;
	}

	public abstract void action();

	public abstract void leftClick();

	public abstract void rightClick();

	public abstract void middleClick();

}

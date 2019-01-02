package baron.rol.InventoryGUI;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

// TODO: 
// Create inventory to attach to
// Add itemstack to add/set/update/etc methods changing inventories also
// Implement some event functionality

public class InventoryGUI {
	private final UUID UID;
	private final int PAGESIZE;
	private final Player player;

	private InventoryItem[] invSlots;
	private UUID[] uuidSlots;

	// ### Constructors ###
	public InventoryGUI(Player p, int n, String s) {
		this.player = p;
		this.PAGESIZE = 54;
		this.UID = UUID.randomUUID();

		this.invSlots = new InventoryItem[PAGESIZE];
		this.uuidSlots = new UUID[PAGESIZE];
	}
	//

	// ### Get Unique ID ###
	public UUID getUID() {
		return UID;
	}
	//

	// ### Get Player ###
	public Player getPlayer() {
		return player;
	}

	// ### Add Item ###
	public void addItem(InventoryItem item) {
		for (int i = 0; i < PAGESIZE; i++) {
			if (invSlots[i] == null) {
				invSlots[i] = item;
				uuidSlots[i] = item.getUID();
			}
		}
	}

	//

	// ### Get Item ###
	public InventoryItem getItem(int slot) {
		return invSlots[slot];
	}

	public InventoryItem getItem(UUID uid) {
		return invSlots[getSlot(uid)];
	}
	//

	// ### Set Item non-forced ###
	public boolean setItem(int slot, InventoryItem item) {
		if (invSlots[slot] == null) {
			invSlots[slot] = item;
			return true;
		}
		return false;
	}

	public boolean setItem(UUID uid, InventoryItem item) {
		int slot = getSlot(uid);

		if (slot == -1) {
			return false;
		}

		return setItem(slot, item);
	}
	//

	// ### Get Slot Number ###
	public int getSlot(UUID uid) {
		for (int i = 0; i < PAGESIZE; i++) {
			if (uuidSlots[i] == uid) {
				return i;
			}
		}
		return -1;
	}

	// ### Set Item Forced ###
	public void forceItem(int slot, InventoryItem item) {
		invSlots[slot] = item;
	}

	public void forceItem(UUID uid, InventoryItem item) {
		invSlots[getSlot(uid)] = item;
	}
	//

	// ### Has Item ###
	public boolean hasItem(int slot) {
		if (invSlots[slot] != null) {
			return true;
		}
		return false;
	}

	public boolean hasItem(UUID uid) {
		if (invSlots[getSlot(uid)] != null) {
			return true;
		}
		return false;
	}

	// ### onClickEvent //
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {

		if (!player.getName().equals(e.getWhoClicked().getName())) {
			return;
		}

		int slot = e.getRawSlot();
		if (PAGESIZE < slot) {
			return;
		}

		if (!hasItem(slot)) {
			return;
		}

		switch (e.getClick()) {
		case LEFT:

			break;
		case RIGHT:

			break;
		case MIDDLE:

			break;

		default:

			break;
		}

	}

}

package baron.rol.InventoryGUI;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

// TODO: 
// Create inventory to attach to
// Add itemstack to add/set/update/etc methods changing inventories also
// Implement some event functionality
// Check use of Comparing ItemStack UUID in event instead of using slot position

public class InventoryGUI implements Listener {
	private final UUID UID;
	private final Player PLAYER;
	private final int INVSIZE;
	private final String INVNAME;

	private Inventory inv;
	private HashMap<Integer, InventoryItem> invMap;

	// ### Constructors ###
	public InventoryGUI(Player p, int n, String s) {
		this.UID = UUID.randomUUID();
		this.PLAYER = p;
		this.INVSIZE = n;
		this.INVNAME = s;

		this.inv = Bukkit.createInventory(PLAYER, INVSIZE, INVNAME);
		this.invMap = new HashMap<>();

	}
	//

	// ### Get Unique ID ###
	public UUID getUID() {
		return UID;
	}
	//

	// ### Get Player ###
	public Player getPlayer() {
		return PLAYER;
	}
	//

	// ### Get Inventory ###
	public Inventory getInv() {
		return this.inv;
	}
	//

	// ### Add Item ###
	public boolean addItem(InventoryItem item) {
		for (int i = 0; i < INVSIZE; i++) {
			if (!hasItem(i)) {
				invMap.put(i, item);
				inv.setItem(i, item);
				return true;
			}
		}
		return false;
	}

	public boolean addItem(int slot, InventoryItem item) {
		if (withInRange(slot) && !hasItem(slot)) {
			invMap.put(slot, item);
			inv.setItem(slot, item);
			return true;
		}
		return false;
	}
	//

	// ### Set Item Forced ###
	public boolean forceItem(int slot, InventoryItem item) {
		if (withInRange(slot)) {
			invMap.put(slot, item);
			inv.setItem(slot, item);
			return true;
		}
		return false;
	}
	//

	// ### Get Item ###
	public InventoryItem getItem(int slot) {
		return invMap.get(slot);
	}

	public InventoryItem getItem(ItemStack item) {
		if (item.getItemMeta().hasLore()) {
			String itemLore = item.getItemMeta().getLore().get(0);
			for (InventoryItem el : invMap.values()) {
				if (el.getItemMeta().getLore().get(0).equals(itemLore)) {
					return el;
				}
			}
		}
		return null;
	}
	//

	// ### Get Slot Number ###
	public int getSlot(InventoryItem item) {
		for (int i = 0; i < INVSIZE; i++) {
			if (invMap.get(i) == item) {
				return i;
			}
		}
		return -1;
	}
	//

	// ### Remove Item ###
	public boolean removeItem(int slot) {
		return (hasItem(slot) ? nullItem(slot) : false);
	}

	public boolean removeItem(InventoryItem item) {
		return (hasItem(item) ? nullItem(getSlot(item)) : false);
	}

	private boolean nullItem(int slot) {
		invMap.remove(slot);
		return true;
	}
	//

	// ### Has Item ###
	public boolean hasItem(int slot) {
		return invMap.containsKey(slot);
	}

	public boolean hasItem(InventoryItem item) {
		return invMap.containsValue(item);
	}
	//

	// ### Within Range ###
	private boolean withInRange(int slot) {
		return slot >= 0 && slot < INVSIZE;
	}
	//

	// ### onClickEvent //
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {

		if (!PLAYER.getName().equals(e.getWhoClicked().getName())) {
			return;
		}

		if (!(e.getCurrentItem() instanceof ItemStack)) {
			return;
		}

		int slot = e.getRawSlot();
		if (INVSIZE <= slot) {
			return;	
		}

		if (!hasItem(slot)) {
			return;
		}

		getItem(slot).action(e.getClick());
	}
}

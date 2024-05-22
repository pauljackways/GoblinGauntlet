package seng201.team131;

/**
 * Enum with the two items used in the game changers screen, repair tower and upgradte tower.
 */
public enum EnumItems {
    REPAIR("Gremlins, daily hire"),
    UPGRADE("Building supplies (FREE labour)");
    private final String itemName;
    EnumItems(String itemName) {
        this.itemName = itemName;
    }
    public String getItemName() {
        return itemName;
    }
}




// for (int i = 0; i < player.getItemList().size(); i++) {
//     if(player.getItemList().get(i).getName() == "Gremlins, daily hire")
//         player.getItemList().remove(i);
//         Tower selectedTower = (Tower) player.getSelected();
//         selectedTower.repairTwr();
//         System.out.println(player.getItemList());
//         break;
//     }
// }

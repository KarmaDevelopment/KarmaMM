package karmadev.mcpl.karmamm.nlkarmamm;

/*
  KarmaMM by Karma Development Team
  MIT License
  Copyright (c) 2022, Karma Development Team
 */

import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class NLKarmaMM extends JavaPlugin implements Listener{

    private static Economy econ = null;
    private static final Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        System.out.println("[KarmaMobMoney] Plugin enabled.");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        if (!setupEconomy() ) {
            log.severe(String.format("The plugin KarmaMM has been disabled because it didn't find Vault!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getServer().getPluginManager().registerEvents(this, this);
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    @Override
    public void onDisable() {
        System.out.println("[KarmaMobMoney] Plugin disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(command.getName().equalsIgnoreCase("kmmreload")){

            if(sender.hasPermission("karmamm.reload")){
                reloadConfig();
                String rm = ChatColor.translateAlternateColorCodes('&', getConfig().getString("ReloadMessage"));
                sender.sendMessage(rm);
            }else{
                String np = ChatColor.translateAlternateColorCodes('&', getConfig().getString("NoPermission"));
                sender.sendMessage(np);
            }
        }
        return true;
    }

    @EventHandler
    public void pluginEvent(EntityDeathEvent e){

        if(e.getEntity().getKiller() instanceof Player){

            Player p = e.getEntity().getKiller();

            if(e.getEntityType().equals(EntityType.ZOMBIE)){

                if(getConfig().getDouble("ZombieReward") != -1){

                    double zombie = getConfig().getDouble("ZombieReward");
                    econ.depositPlayer(p, zombie);
                    String zombie_string = Double.toString(zombie);
                    String zombieet = getConfig().getString("Zombie");
                    String zombie_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", zombie_string).replace("%entity%", zombieet));
                    p.sendMessage(zombie_msg);

                }else if(getConfig().getDouble("ZombieReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.CREEPER)){

                if(getConfig().getDouble("CreeperReward") != -1){

                    double creeper = getConfig().getDouble("CreeperReward");
                    econ.depositPlayer(p, creeper);
                    String creeper_string = Double.toString(creeper);
                    String creeperet = getConfig().getString("Creeper");
                    String creeper_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", creeper_string).replace("%entity%", creeperet));
                    p.sendMessage(creeper_msg);

                }else if(getConfig().getDouble("CreeperReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.SKELETON)){

                if(getConfig().getDouble("SkeletonReward") != -1){

                    double skeleton = getConfig().getDouble("SkeletonReward");
                    econ.depositPlayer(p, skeleton);
                    String skeleton_string = Double.toString(skeleton);
                    String skeletonet = getConfig().getString("Skeleton");
                    String skeleton_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", skeleton_string).replace("%entity%", skeletonet));
                    p.sendMessage(skeleton_msg);

                }else if(getConfig().getDouble("SkeletonReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.SPIDER)){

                if(getConfig().getDouble("SpiderReward") != -1){

                    double spider = getConfig().getDouble("SpiderReward");
                    econ.depositPlayer(p, spider);
                    String spider_string = Double.toString(spider);
                    String spideret = getConfig().getString("Spider");
                    String spider_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", spider_string).replace("%entity%", spideret));
                    p.sendMessage(spider_msg);

                }else if(getConfig().getDouble("SpiderReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.SHEEP)){

                if(getConfig().getDouble("SheepReward") != -1){

                    double sheep = getConfig().getDouble("SheepReward");
                    econ.depositPlayer(p, sheep);
                    String sheep_string = Double.toString(sheep);
                    String sheepet = getConfig().getString("Sheep");
                    String sheep_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", sheep_string).replace("%entity%", sheepet));
                    p.sendMessage(sheep_msg);

                }else if(getConfig().getDouble("SheepReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.PIG)){

                if(getConfig().getDouble("PigReward") != -1){

                    double pig = getConfig().getDouble("PigReward");
                    econ.depositPlayer(p, pig);
                    String pig_string = Double.toString(pig);
                    String piget = getConfig().getString("Pig");
                    String pig_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", pig_string).replace("%entity%", piget));
                    p.sendMessage(pig_msg);

                }else if(getConfig().getDouble("PigReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.COW)){

                if(getConfig().getDouble("CowReward") != -1){

                    double cow = getConfig().getDouble("CowReward");
                    econ.depositPlayer(p, cow);
                    String cow_string = Double.toString(cow);
                    String cowet = getConfig().getString("Cow");
                    String cow_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", cow_string).replace("%entity%", cowet));
                    p.sendMessage(cow_msg);

                }else if(getConfig().getDouble("CowReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.MUSHROOM_COW)){

                if(getConfig().getDouble("MushroomReward") != -1){

                    double mushroom = getConfig().getDouble("MushroomReward");
                    econ.depositPlayer(p, mushroom);
                    String mushroom_string = Double.toString(mushroom);
                    String mushroomet = getConfig().getString("Mushroom");
                    String mushroom_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", mushroom_string).replace("%entity%", mushroomet));
                    p.sendMessage(mushroom_msg);

                }else if(getConfig().getDouble("MushroomReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.MAGMA_CUBE)){

                if(getConfig().getDouble("MagmacubeReward") != -1){

                    double magmacube = getConfig().getDouble("MagmacubeReward");
                    econ.depositPlayer(p, magmacube);
                    String magmacube_string = Double.toString(magmacube);
                    String magmacubeet = getConfig().getString("Magmacube");
                    String magmacube_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", magmacube_string).replace("%entity%", magmacubeet));
                    p.sendMessage(magmacube_msg);

                }else if(getConfig().getDouble("MagmacubeReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.SLIME)){

                if(getConfig().getDouble("SlimeReward") != -1){

                    double slime = getConfig().getDouble("SlimeReward");
                    econ.depositPlayer(p, slime);
                    String slime_string = Double.toString(slime);
                    String slimeet = getConfig().getString("Slime");
                    String slime_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", slime_string).replace("%entity%", slimeet));
                    p.sendMessage(slime_msg);

                }else if(getConfig().getDouble("SlimeReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.WITHER)){

                if(getConfig().getDouble("WitherReward") != -1){

                    double wither = getConfig().getDouble("WitherReward");
                    econ.depositPlayer(p, wither);
                    String wither_string = Double.toString(wither);
                    String witheret = getConfig().getString("Wither");
                    String wither_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", wither_string).replace("%entity%", witheret));
                    p.sendMessage(wither_msg);

                }else if(getConfig().getDouble("WitherReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.WITHER_SKELETON)){

                if(getConfig().getDouble("WitherSkeletonReward") != -1){

                    double wither_skeleton = getConfig().getDouble("WitherSkeletonReward");
                    econ.depositPlayer(p, wither_skeleton);
                    String wither_skeleton_string = Double.toString(wither_skeleton);
                    String wither_skeletonet = getConfig().getString("WitherSkeleton");
                    String wither_skeleton_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", wither_skeleton_string).replace("%entity%", wither_skeletonet));
                    p.sendMessage(wither_skeleton_msg);

                }else if(getConfig().getDouble("Whiter_skeletonReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.BLAZE)){

                if(getConfig().getDouble("BlazeReward") != -1){

                    double blaze = getConfig().getDouble("BlazeReward");
                    econ.depositPlayer(p, blaze);
                    String blaze_string = Double.toString(blaze);
                    String blazeet = getConfig().getString("Blaze");
                    String blaze_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", blaze_string).replace("%entity%", blazeet));
                    p.sendMessage(blaze_msg);

                }else if(getConfig().getDouble("BlazeReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.PLAYER)){

                if(getConfig().getDouble("PlayerReward") != -1){

                    double player = getConfig().getDouble("PlayerReward");
                    econ.depositPlayer(p, player);
                    String player_string = Double.toString(player);
                    Player k = (Player) e.getEntity();
                    String playeret = ChatColor.translateAlternateColorCodes('§', getConfig().getString("Player") .replace("%player%", k.getDisplayName()));
                    String player_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", player_string).replace("%entity%", playeret));
                    p.sendMessage(player_msg);

                }else if(getConfig().getDouble("PlayerReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.GHAST)){

                if(getConfig().getDouble("GhastReward") != -1){

                    double ghast = getConfig().getDouble("GhastReward");
                    econ.depositPlayer(p, ghast);
                    String ghast_string = Double.toString(ghast);
                    String ghastet = getConfig().getString("Ghast");
                    String ghast_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", ghast_string).replace("%entity%", ghastet));
                    p.sendMessage(ghast_msg);

                }else if(getConfig().getDouble("GhastReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.ENDERMAN)){

                if(getConfig().getDouble("EndermanReward") != -1){

                    double enderman = getConfig().getDouble("EndermanReward");
                    econ.depositPlayer(p, enderman);
                    String enderman_string = Double.toString(enderman);
                    String endermanet = getConfig().getString("Enderman");
                    String enderman_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", enderman_string).replace("%entity%", endermanet));
                    p.sendMessage(enderman_msg);

                }else if(getConfig().getDouble("EndermanReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.ENDER_DRAGON)){

                if(getConfig().getDouble("EnderDragonReward") != -1){

                    double enderdragon = getConfig().getDouble("EnderDragonReward");
                    econ.depositPlayer(p, enderdragon);
                    String enderdragon_string = Double.toString(enderdragon);
                    String enderdragonet = getConfig().getString("EnderDragon");
                    String enderdragon_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", enderdragon_string).replace("%entity%", enderdragonet));
                    p.sendMessage(enderdragon_msg);

                }else if(getConfig().getDouble("EnderDragonReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.PILLAGER)){

                if(getConfig().getDouble("PillagerReward") != -1){

                    double pillager = getConfig().getDouble("PillagerReward");
                    econ.depositPlayer(p, pillager);
                    String pillager_string = Double.toString(pillager);
                    String pillageret = getConfig().getString("Pillager");
                    String pillager_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage") .replace("%money%", pillager_string).replace("%entity%", pillageret));
                    p.sendMessage(pillager_msg);

                }else if(getConfig().getDouble("PillagerReward") <= -2 ){
                    return;
                }

            }else if(e.getEntityType().equals(EntityType.CHICKEN)) {

                if (getConfig().getDouble("ChickenReward") != -1) {

                    double chicken = getConfig().getDouble("ChickenReward");
                    econ.depositPlayer(p, chicken);
                    String chicken_string = Double.toString(chicken);
                    String chickenet = getConfig().getString("Chicken");
                    String chicken_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", chicken_string).replace("%entity%", chickenet));
                    p.sendMessage(chicken_msg);

                } else if (getConfig().getDouble("ChickenReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.CAVE_SPIDER)) {

                if (getConfig().getDouble("CaveSpiderReward") != -1) {

                    double cavespider = getConfig().getDouble("CaveSpiderReward");
                    econ.depositPlayer(p, cavespider);
                    String cavespider_string = Double.toString(cavespider);
                    String cavespideret = getConfig().getString("CaveSpider");
                    String cavespider_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", cavespider_string).replace("%entity%", cavespideret));
                    p.sendMessage(cavespider_msg);

                } else if (getConfig().getDouble("CaveSpiderReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.ENDERMITE)) {

                if (getConfig().getDouble("EndermiteReward") != -1) {

                    double endermite = getConfig().getDouble("EndermiteReward");
                    econ.depositPlayer(p, endermite);
                    String endermite_string = Double.toString(endermite);
                    String endermiteet = getConfig().getString("Endermite");
                    String endermite_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", endermite_string).replace("%entity%", endermiteet));
                    p.sendMessage(endermite_msg);

                } else if (getConfig().getDouble("EndermiteReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.EVOKER)) {

                if (getConfig().getDouble("EvokerReward") != -1) {

                    double evoker = getConfig().getDouble("EvokerReward");
                    econ.depositPlayer(p, evoker);
                    String evoker_string = Double.toString(evoker);
                    String evokeret = getConfig().getString("Evoker");
                    String evoker_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", evoker_string).replace("%entity%", evokeret));
                    p.sendMessage(evoker_msg);

                } else if (getConfig().getDouble("EvokerReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.HUSK)) {

                if (getConfig().getDouble("HuskReward") != -1) {

                    double husk = getConfig().getDouble("HuskReward");
                    econ.depositPlayer(p, husk);
                    String husk_string = Double.toString(husk);
                    String husket = getConfig().getString("Husk");
                    String husk_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", husk_string).replace("%entity%", husket));
                    p.sendMessage(husk_msg);

                } else if (getConfig().getDouble("HuskReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.FOX)) {

                if (getConfig().getDouble("FoxReward") != -1) {

                    double fox = getConfig().getDouble("FoxReward");
                    econ.depositPlayer(p, fox);
                    String fox_string = Double.toString(fox);
                    String foxet = getConfig().getString("Fox");
                    String fox_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", fox_string).replace("%entity%", foxet));
                    p.sendMessage(fox_msg);

                } else if (getConfig().getDouble("FoxReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.SILVERFISH)) {

                if (getConfig().getDouble("SilverfishReward") != -1) {

                    double silverfish = getConfig().getDouble("SilverfishReward");
                    econ.depositPlayer(p, silverfish);
                    String silverfish_string = Double.toString(silverfish);
                    String silverfishet = getConfig().getString("Silverfish");
                    String silverfish_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", silverfish_string).replace("%entity%", silverfishet));
                    p.sendMessage(silverfish_msg);

                } else if (getConfig().getDouble("SilverfishReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.SHULKER)) {

                if (getConfig().getDouble("ShulkerReward") != -1) {

                    double shulker = getConfig().getDouble("ShulkerReward");
                    econ.depositPlayer(p, shulker);
                    String shulker_string = Double.toString(shulker);
                    String shulkeret = getConfig().getString("Shulker");
                    String shulker_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", shulker_string).replace("%entity%", shulkeret));
                    p.sendMessage(shulker_msg);

                } else if (getConfig().getDouble("ShulkerReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.SQUID)) {

                if (getConfig().getDouble("SquidReward") != -1) {

                    double squid = getConfig().getDouble("SquidReward");
                    econ.depositPlayer(p, squid);
                    String squid_string = Double.toString(squid);
                    String squidet = getConfig().getString("Squid");
                    String squid_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", squid_string).replace("%entity%", squidet));
                    p.sendMessage(squid_msg);

                } else if (getConfig().getDouble("SquidReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.WITCH)) {

                if (getConfig().getDouble("WitchReward") != -1) {

                    double witch = getConfig().getDouble("WitchReward");
                    econ.depositPlayer(p, witch);
                    String witch_string = Double.toString(witch);
                    String witchet = getConfig().getString("Witch");
                    String witch_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", witch_string).replace("%entity%", witchet));
                    p.sendMessage(witch_msg);

                } else if (getConfig().getDouble("WitchReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.ZOMBIE_VILLAGER)) {

                if (getConfig().getDouble("ZombieVillagerReward") != -1) {

                    double zombievillager = getConfig().getDouble("ZombieVillagerReward");
                    econ.depositPlayer(p, zombievillager);
                    String zombievillager_string = Double.toString(zombievillager);
                    String zombievillageret = getConfig().getString("ZombieVillager");
                    String zombievillager_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", zombievillager_string).replace("%entity%", zombievillageret));
                    p.sendMessage(zombievillager_msg);

                } else if (getConfig().getDouble("ZombieVillagerReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.IRON_GOLEM)) {

                if (getConfig().getDouble("IronGolemReward") != -1) {

                    double irongolem = getConfig().getDouble("IronGolemReward");
                    econ.depositPlayer(p, irongolem);
                    String irongolem_string = Double.toString(irongolem);
                    String irongolemet = getConfig().getString("IronGolem");
                    String irongolem_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", irongolem_string).replace("%entity%", irongolemet));
                    p.sendMessage(irongolem_msg);

                } else if (getConfig().getDouble("IronGolemReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.RAVAGER)) {

                if (getConfig().getDouble("RavagerReward") != -1) {

                    double ravager = getConfig().getDouble("RavagerReward");
                    econ.depositPlayer(p, ravager);
                    String ravager_string = Double.toString(ravager);
                    String ravageret = getConfig().getString("Ravager");
                    String ravager_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", ravager_string).replace("%entity%", ravageret));
                    p.sendMessage(ravager_msg);

                } else if (getConfig().getDouble("RavagerReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.VEX)) {

                if (getConfig().getDouble("VexReward") != -1) {

                    double vex = getConfig().getDouble("VexReward");
                    econ.depositPlayer(p, vex);
                    String vex_string = Double.toString(vex);
                    String vexet = getConfig().getString("Vex");
                    String vex_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", vex_string).replace("%entity%", vexet));
                    p.sendMessage(vex_msg);

                } else if (getConfig().getDouble("VexReward") <= -2) {
                    return;
                }
            }else if(e.getEntityType().equals(EntityType.STRAY)) {

                if (getConfig().getDouble("StrayReward") != -1) {

                    double stray = getConfig().getDouble("StrayReward");
                    econ.depositPlayer(p, stray);
                    String stray_string = Double.toString(stray);
                    String strayet = getConfig().getString("Stray");
                    String stray_msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("RewardMessage").replace("%money%", stray_string).replace("%entity%", strayet));
                    p.sendMessage(stray_msg);

                } else if (getConfig().getDouble("VexReward") <= -2) {
                    return;
                }
            }
        }
    }
}

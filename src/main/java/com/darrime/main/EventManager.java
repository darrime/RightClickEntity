package com.darrime.main;


import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public class EventManager implements Listener {

    @EventHandler
    public void rightClick1(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        Action a = e.getAction();
        Location loc = p.getEyeLocation();

        //플레이어가 우클릭을 했을때(허공 혹은 블럭)
        if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
            //아머스탠드 엔티티 생성
            ArmorStand swordHolo = (ArmorStand) p.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
            //아이템 각도에 맞게 조정
            swordHolo.setHeadPose(new EulerAngle(80.1, 0.56,35.1));
            //TODO setGravity를 false로 하면 아이템 안날라감
            swordHolo.setGravity(true);
            swordHolo.setVisible(false);
            swordHolo.setArms(false);
            swordHolo.setBasePlate(false);

            //y좌표 5 증가
            loc.setY(loc.getY() + 5);
            swordHolo.setVelocity(p.getLocation().getDirection());
            //아이템 각도에 맞게 조정

            //아머스탠드 헬멧에 플레이어가 들고있는 아이템 씌우기
            swordHolo.setHelmet(new ItemStack(p.getItemInHand().getType()));
            //플레이어가 보이는 방향으로 날리기
            swordHolo.setVelocity(p.getEyeLocation().getDirection().multiply(10));

        }


    }
}

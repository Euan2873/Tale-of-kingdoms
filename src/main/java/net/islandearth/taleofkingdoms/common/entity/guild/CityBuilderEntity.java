package net.islandearth.taleofkingdoms.common.entity.guild;

import net.islandearth.taleofkingdoms.TaleOfKingdoms;
import net.islandearth.taleofkingdoms.common.entity.TOKEntity;
import net.islandearth.taleofkingdoms.common.world.ConquestInstance;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CityBuilderEntity extends TOKEntity {

    public CityBuilderEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 10.0F));
        applyEntityAI();
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (hand == Hand.OFF_HAND || !player.world.isClient()) return ActionResult.FAIL;
        ConquestInstance instance = TaleOfKingdoms.getAPI().get().getConquestInstanceStorage().mostRecentInstance().get();
        //TODO
        return ActionResult.PASS;
    }

    @Override
    public boolean isStationary() {
        return true;
    }
}

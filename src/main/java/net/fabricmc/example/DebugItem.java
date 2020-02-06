package net.fabricmc.example;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

/*
Copyright (C) 2019 Nathan P. Bombana

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program. If not, see https://www.gnu.org/licenses/.
*/
public class DebugItem extends Item {
    public DebugItem() {
        super(new Settings().group(ItemGroup.MISC));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos().offset(context.getSide());

        for (int i=0; i<128; i++) {
            context.getWorld().addParticle(
                ExampleMod.CUSTOM_TEST_PARTICLE,
                pos.getX(), pos.getY(), pos.getZ(),
                0, 0, 0
            );
        }

        return super.useOnBlock(context);
    }
}

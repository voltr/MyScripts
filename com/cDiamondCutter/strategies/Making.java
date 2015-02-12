package com.cDiamondCutter.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import com.cDiamondCutter.data.Constants;

public class Making implements Strategy {

	@Override
	public boolean activate() {
		return Inventory.getCount(Constants.UNCUT_DIAMONDS_ID) == 25;
	}

	@Override
	public void execute() {
		Inventory.combine(Constants.CHISEL_ID, Constants.UNCUT_DIAMONDS_ID);
		Menu.sendAction(315, 5029888, 272, 2498, 1);
		Time.sleep(24000);
		Inventory.combine(Constants.CHISEL_ID, Constants.DIAMONDS_ID);
		Menu.sendAction(315, Constants.DIAMONDS_ID - 1, 8, 2472, 1);
		Menu.sendAction(315, Constants.DIAMONDS_ID - 1, 20, 2498, 1);
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				return Players.getMyPlayer().getAnimation() == -1;
			}
		}, 500);
	}
}

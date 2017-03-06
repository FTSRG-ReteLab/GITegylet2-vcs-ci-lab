package hu.bme.mit.train.controller;

import java.util.Date;

import hu.bme.mit.train.interfaces.Tachograph;
import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private Tachograph tcg = new Tachograph();

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
			referenceSpeed += step;
		}
		enforceSpeedLimit();
		tcg.addEntry(new Date(), step, referenceSpeed);
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;		
	}
	
	@Override
	public Tachograph getTachograph(){
		return tcg;
	}

}

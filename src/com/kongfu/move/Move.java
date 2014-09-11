package com.kongfu.move;

public class Move {

	/**
	 * 
	 * @param name 招式名称
	 * @param movetype 招式类型，攻击/防守/闪避
	 * @param baseNum 基础数值，如果是攻击招式就是攻击力，防守招式就是防御力
	 * @param weaponType 需要的武器类别
	 * TODO 技能攻击的部位
	 */
	public Move(String name,int movetype, int baseNum, int weaponType) {
		this.moveName = name;
		this.moveType = movetype;
		this.baseNum = baseNum;
		this.weaponType = weaponType;
	}
	
	public Move(){
		
	}
	
	private String moveName;//招式名称
	private int moveType;//招式类型，攻击/防守/闪避
	private int baseNum;//基础数值，如果是攻击招式就是攻击力，防守招式就是防御力
	private int weaponType;//需要的武器类别
	private int moveSpeed;//招式速度 只有攻击招式有用
	
	
	public String getMoveName() {
		return moveName;
	}
	public void setMoveName(String moveName) {
		this.moveName = moveName;
	}
	public int getMoveType() {
		return moveType;
	}
	public void setMoveType(int moveType) {
		this.moveType = moveType;
	}
	public int getWeaponType() {
		return weaponType;
	}
	public void setWeaponType(int weaponType) {
		this.weaponType = weaponType;
	}

	public int getBaseNum() {
		return baseNum;
	}

	public void setBaseNum(int baseNum) {
		this.baseNum = baseNum;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	

}

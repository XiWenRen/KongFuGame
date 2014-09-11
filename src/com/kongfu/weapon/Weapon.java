package com.kongfu.weapon;

public class Weapon {

	public Weapon(String name, int type, int grade) {
		this.weaponName = name;
		this.weaponType = type;
		this.weapongGrade = grade;
	}
	
	public Weapon(){
		
	}

	private String weaponName;//武器名称
	private int weaponType;//武器类型
	private int weapongGrade;//武器等级
	
	public String getWeaponName() {
		return weaponName;
	}
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
	public int getWeaponType() {
		return weaponType;
	}
	public void setWeaponType(int weaponType) {
		this.weaponType = weaponType;
	}
	public int getWeapongrade() {
		return weapongGrade;
	}
	public void setWeapongrade(int weapongrade) {
		this.weapongGrade = weapongrade;
	}
	
	
}

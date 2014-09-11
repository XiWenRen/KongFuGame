package com.kongfu.roles;

import java.util.LinkedList;
import java.util.List;

import com.kongfu.move.Move;
import com.kongfu.weapon.Weapon;

public class Role {

	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	private String roleName;//角色名字
	private int strength;//力量
	private int agility;//敏捷
	private int power;//体力
	
	private Weapon weapon;//装备的武器
	private Weapon armor;//装备的防具
	
	private List<Move> attackMoveList = new LinkedList<Move>();//掌握的攻击招式
	private List<Move> defenseMoveList = new LinkedList<Move>();//掌握的防守招式
	private List<Move> dodgeMoveList = new LinkedList<Move>();//掌握的躲避招式
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public Weapon getArmor() {
		return armor;
	}
	public void setArmor(Weapon armor) {
		this.armor = armor;
	}
	public List<Move> getAttackMoveList() {
		return attackMoveList;
	}
	public void setAttackMoveList(List<Move> attackMoveList) {
		this.attackMoveList = attackMoveList;
	}
	public List<Move> getDefenseMoveList() {
		return defenseMoveList;
	}
	public void setDefenseMoveList(List<Move> defenseMoveList) {
		this.defenseMoveList = defenseMoveList;
	}
	public List<Move> getDodgeMoveList() {
		return dodgeMoveList;
	}
	public void setDodgeMoveList(List<Move> dodgeMoveList) {
		this.dodgeMoveList = dodgeMoveList;
	}
	
	
}

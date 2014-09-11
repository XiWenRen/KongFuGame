package com.kongfu.utility;

import java.util.Random;

import com.kongfu.move.Move;
import com.kongfu.roles.Protagonist;
import com.kongfu.roles.Role;

/**
 * 战斗过程的计算类
 * 每次战斗都有一个进攻者和一个防守者
 * 每次进攻/防守都是一次出招，出的招式在进攻者/防守者已拥有的招式列表中
 * 进攻者的攻击力 = 本身的力量*招式威力
 * 防守者的防御力 = 本身的体力*招式威力
 * 攻击者的攻击速度 = 本身的敏捷*招式速度(招式速度只有攻击招式才有)
 * 防守者也可以躲避，躲避概率 = 本身的敏捷*招式威力
 * 判断招式是否攻击成功就是攻击力 是否大于 防御力
 * 判断是否躲避成功就是躲避总速度 是否大于 攻击速度
 * TODO 下面几条还未完成
 * 如果防守成功，则下回合还是防守
 * 如果躲避成功，则下回合攻守方换位
 * 如果防守/躲避失败，则扣除体力和敏捷
 * 如果体力 <= 0则战斗失败 
 * @author Jay
 *
 */
public class FightProcess {

	private Role attacker;
	private Role defenser;
	
	private String attackerName;//攻击者名字，如果是主角就是'你'
	private String defenserName;//防守者名字，如果是主角就是'你'
	
	private int attack;//本次攻击的攻击力
	private int defense;//本次防御的防御力
	private int dodge;//本次闪避的闪避能力
	private String fightInfo;//战斗信息
	
	
	private String info1 = "使用一招";
	private String info2 = "攻向";
	private String[] bodysInfo = {"的脸门","的肩膀","的胸口","的下盘","的后背"};
	
	private String info3 = "挡住了";
	private String info4 = "的招式";
	private String info5 = "躲过了";
	
	private String info6 = "却没挡住，噗的喷出一口献血";
	private String info7 = "但没躲开，捂住伤口飞身后退";
	
	public FightProcess(Role attacker,Role defenser) {
		this.attacker = attacker;
		this.defenser = defenser;
		attackerName = attacker instanceof Protagonist ? "你" : attacker.getRoleName();
		defenserName = defenser instanceof Protagonist ? "你" : defenser.getRoleName();
	}
	
	/**
	 * 战斗
	 * @throws InterruptedException 
	 */
	public boolean fight() throws InterruptedException{
		calAttack();
		System.out.println(fightInfo);
		Thread.sleep(1000);
		
		int defOrDod = new Random().nextInt(2);
		if(defOrDod == 0){
			calDefense();
		}else{
			calDodge();
		}
		System.out.println(fightInfo);
		Thread.sleep(1000);
		exchangeAttackerAndDefenser();
		clear();
		return defenser.getPower() <= 0;
	}
	
	private void clear() {
		attack = 0;
		defense = 0;
		dodge = 0;
		fightInfo = null;
	}

	private void exchangeAttackerAndDefenser(){
		Role role = attacker;
		attacker = defenser;
		defenser = role;
	}
	
	/**
	 * 计算攻击力
	 */
	private void calAttack(){
		Move attackMove = attacker.getAttackMoveList().get(getRandomNum(MoveUtility.MOVE_TYPE_ATTACK));
		attack = attacker.getPower() * attackMove.getBaseNum();
		fightInfo = attackerName + info1 + attackMove.getMoveName() + info2 + defenserName + bodysInfo[new Random().nextInt(bodysInfo.length)];
	}
	
	/**
	 * 计算防御力
	 */
	private void calDefense(){
		int randomNum = getRandomNum(MoveUtility.MOVE_TYPE_ATTACK);
		if(randomNum == -1){
			calDodge();
			return;
		}
		Move defenseMove = attacker.getDefenseMoveList().get(randomNum);
		defense = defenser.getStrength() * defenseMove.getBaseNum();
		fightInfo = defenserName + info1 + defenseMove.getMoveName() + (attack > defense ? (info6) : (info3 + attackerName + info4));
		defenser.setPower(attack - defense > 0 ? attack - defense : defenser.getPower());
		
	}
	
	/**
	 * 计算躲避能力
	 */
	private void calDodge(){
		int randomNum = getRandomNum(MoveUtility.MOVE_TYPE_ATTACK);
		if(randomNum == -1){
			
		}
		Move dodgeMove = attacker.getDodgeMoveList().get(randomNum);
		dodge = defenser.getAgility() * dodgeMove.getMoveSpeed();
		fightInfo = defenserName + info1 + dodgeMove.getMoveName() + (attack > defense ? (info7) : (info5 + attackerName + info4));
		defenser.setPower(attack - dodge > 0 ? attack - dodge : defenser.getPower());
	}
	
	/**
	 * 获取招式随机数
	 * TODO 算法还可以改进，根据人物等级来计算高级招式的使用概率
	 * @param moveType
	 * @return
	 */
	private int getRandomNum(int moveType){
		int moveQty = 0;
		switch(moveType){
			case MoveUtility.MOVE_TYPE_ATTACK:
				moveQty = attacker.getAttackMoveList().size();
				break;
			case MoveUtility.MOVE_TYPE_DEFESE:
				moveQty = attacker.getDefenseMoveList().size();
				break;
			case MoveUtility.MOVE_TYPE_DODGE:
				moveQty = attacker.getDodgeMoveList().size();
				break;
			default :
				moveQty = 0;
				break;
		}
		//TODO 如果没有招式
		return moveQty == 0 ? -1 : new Random().nextInt(moveQty); 
	}
	
	
}

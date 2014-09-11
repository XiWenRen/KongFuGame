
package com.kongfu.game;

import com.kongfu.move.Move;
import com.kongfu.roles.Protagonist;
import com.kongfu.roles.Role;
import com.kongfu.utility.FightProcess;

public class GameStart implements Runnable{
	
	public static void main(String[] args) {
		GameStart gt = new GameStart();
		new Thread(gt).start();
		
	}
	
	private Role me;
	private Role anemy;
	
	public GameStart(){
		init();
	}
	
	private void init(){
		me = new Protagonist("XiWenRen",10,10,10);
		anemy = new Role("隔壁老王",8,8,8);
		
		Move attack1 = new Move("冲步双掌",1,10,1);
		Move attack2 = new Move("扭步断肘",1,20,1);
		Move defense1 = new Move("金钟罩",2,10,1);
		Move defense2 = new Move("铁布衫",2,20,1);
		Move dodge1 = new Move("凌波微步",3,10,1);
		Move dodge2 = new Move("一苇渡江",3,20,1);
		
		me.addMove(attack1);
		me.addMove(attack2);
		me.addMove(defense1);
		me.addMove(defense2);
		me.addMove(dodge1);
		me.addMove(dodge2);
		
		anemy.addMove(attack1);
		anemy.addMove(attack2);
		anemy.addMove(defense1);
		anemy.addMove(defense2);
		anemy.addMove(dodge1);
		anemy.addMove(dodge2);
	}
	
	public void run(){
		boolean isFightEnd = false;
		FightProcess fightProcess = new FightProcess(me,anemy);
		while(!isFightEnd){
			try {
				isFightEnd = fightProcess.fight();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

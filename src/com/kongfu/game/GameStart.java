
package com.kongfu.game;

import com.kongfu.move.Move;
import com.kongfu.roles.Protagonist;
import com.kongfu.roles.Role;

public class GameStart implements Runnable{
	
	private boolean round = true;//轮到谁出手,true是me,false是anemy

	public static void main(String[] args) {
		Role me = new Protagonist();
		Role anemy = new Role();
		
	}
	
	private void initMoves(){
		Move attack1 = new Move("冲步双掌",1,10,1);
		Move attack2 = new Move("扭步断肘",1,20,1);
		Move defense1 = new Move("",2,10,1);
		Move defense2 = new Move("",2,20,1);
		Move dodge1 = new Move("",3,10,1);
		Move dodge2 = new Move("",3,20,1);
	}
	
	private void fight(){
		if(round){
			
		}else{
			
		}
		round = !round;
	}
	
	public void run(){
		
	}
}

package game;

import java.util.Scanner;

public class ChessGame {
	public static void main(String[] args) {
		//Board b = new Board();
		//Scanner scan = new Scanner(System.in);
		GUI g = new GUI();
		g.setUpGUI();
		g.frameGUI();
		g.playGUI(g.startX, g.startY, g.endX, g.endY);
		
//		System.out.println("Welcome to chess");
//		System.out.println("White = upper case");
//		System.out.println("Black = lower case");
//		b.setUp();
//		b.print();
//		while(!b.gameOver()) {
//			boolean picked = false;
//			boolean played = false;
//			int startX = 100;
//			int startY = 100;
//			if(b.turn()) {
//				System.out.print("White turn: ");
//				b.turn = false;
//			}
//			else {
//				System.out.print("Black turn: ");
//				b.turn = true;
//			}
//			while(!picked) {
//				System.out.println("please enter the piece you wish to move");
//				System.out.print("X: ");
//				startX =scan.nextInt();
//				System.out.print("Y: ");
//				startY =scan.nextInt();
//				System.out.println(b.givePiece(startX, startY));
//				if(b.turn()==b.isWhite(startX, startY))
//					System.out.println("please enter a vaild piece");
//				else
//					picked = true;
//			}
//			while(!played) {
//				System.out.println("please enter where you wish to move to");
//				System.out.print("X: ");
//				int endX =scan.nextInt();
//				System.out.print("Y: ");
//				int endY =scan.nextInt();
//				if(!b.giveTile(startX, startY).givePiece().isVaild(endX, endY))
//					System.out.println("invaild move");
//				else 
//					played = b.play(startX, startY, endX, endY);
//					
//				}
//			b.print();
//		}
//		scan.close();
	}

}

package test;

import java.util.LinkedList;
import model.*;

public class Test {
	
	public static boolean add(Piece p,LinkedList<Piece> list) {
		int size = list.size();
		if( size == 0 ) {
			list.add(p);
			return true;
		}
		size = list.size();
		Piece top = list.get(size -1);
		if ( top != null) {
			System.out.println("Top Domino :"+top);
			if(top.tomatchRight(p)) {
				list.add(p);
				return true;
			}else {
				if(list.get(0).tomatchLeft(p)) {
					list.addFirst(p);
					return true;
				}
			}
		}
		System.out.println("la list :"+list);
		return false;
	}
	
	public static void main(String[] args) {
		/*
		DominoPiece p1 = new DominoPiece(1,2);
		DominoPiece p2 = new DominoPiece(1,3);
		DominoPiece p3 = new DominoPiece(3,0);
		DominoPiece p4 = new DominoPiece(0,1);
		DominoPiece p5 = new DominoPiece(5,1);
		
		LinkedList<Piece> list = new LinkedList<Piece>();
		add(p1,list);
		add(p2,list);
		add(p3,list);
		add(p4,list);
		add(p5,list);
		*/
		GommettePiece p1 = new GommettePiece(54,32);
		GommettePiece p2 = new GommettePiece(77,52);
		System.out.println(p1.tomatchRight(p2));
		System.out.println(p2);
		
	}

}

package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch match = new ChessMatch();
		
		while (true) {
			UI.printBoard(match.getPieces());
			
			System.out.print("\nSource: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.print("\nTarget: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = match.performChessMove(source, target);
		}
	}
}

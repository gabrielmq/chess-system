package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[super.getBoard().getRows()][super.getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		if (super.getColor() == Color.WHITE) {
			p.setValues(super.position.getRow() - 1, super.position.getColumn());
			if (super.getBoard().positionExists(p) && !super.getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(super.position.getRow() - 2, super.position.getColumn());
			Position p2 = new Position(super.position.getRow() - 1, super.position.getColumn());
			if (super.getBoard().positionExists(p) && !super.getBoard().thereIsAPiece(p) 
					&& super.getBoard().positionExists(p2) && !super.getBoard().thereIsAPiece(p2) 
					&& super.getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(super.position.getRow() - 1, super.position.getColumn() - 1);
			if (super.getBoard().positionExists(p) && super.isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(super.position.getRow() - 1, super.position.getColumn() + 1);
			if (super.getBoard().positionExists(p) && super.isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// #especialmove en passant white
			if (super.position.getRow() == 3) {
				Position left = new Position(super.position.getRow(), super.position.getColumn() - 1);
				if (super.getBoard().positionExists(left) && super.isThereOpponentPiece(left) && super.getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(super.position.getRow(), super.position.getColumn() + 1);
				if (super.getBoard().positionExists(right) && super.isThereOpponentPiece(right) && super.getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
			}
		}
		else {
			p.setValues(super.position.getRow() + 1, super.position.getColumn());
			if (super.getBoard().positionExists(p) && !super.getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(super.position.getRow() + 2, super.position.getColumn());
			Position p2 = new Position(super.position.getRow() + 1, super.position.getColumn());
			if (super.getBoard().positionExists(p) && !super.getBoard().thereIsAPiece(p) 
					&& super.getBoard().positionExists(p2) && !super.getBoard().thereIsAPiece(p2) 
					&& super.getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(super.position.getRow() + 1, super.position.getColumn() - 1);
			if (super.getBoard().positionExists(p) && super.isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(super.position.getRow() + 1, super.position.getColumn() + 1);
			if (super.getBoard().positionExists(p) && super.isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// #especialmove en passant black
			if (super.position.getRow() == 4) {
				Position left = new Position(super.position.getRow(), super.position.getColumn() - 1);
				if (super.getBoard().positionExists(left) && super.isThereOpponentPiece(left) && super.getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
				Position right = new Position(super.position.getRow(), super.position.getColumn() + 1);
				if (super.getBoard().positionExists(right) && super.isThereOpponentPiece(right) && super.getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
			}
		}
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}
}

package model;

import dao.FavoriteDAO;

public class LoadFavoriteBeverage {
	public FavoriteBeverage execute(int user_id) {
		FavoriteDAO dao = new FavoriteDAO();
		FavoriteBeverage favBev = dao.extractFavorite(user_id);
		return favBev;
	}
}

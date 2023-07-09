package com.smup.DAO;

import com.smup.Entity.Seguire;

import java.util.ArrayList;

public interface FollowingDAO {
	public void insertFollow(String id_User, String id_Artist);
	public void removeFollow(String id_User, String id_Following);
	public ArrayList<Seguire> getAllFollowings(String id_User);
}
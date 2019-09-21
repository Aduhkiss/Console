package me.atticuszambrana.console.center;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import me.atticuszambrana.console.common.Packet;
import me.atticuszambrana.console.common.Packet.RequestType;
import me.atticuszambrana.console.common.Rank;
import me.atticuszambrana.console.util.HWID;

public class PermissionCenter {
	
	private static Rank rank;
	
	public static void updateRank() {
		// Get the HWID of the computer
		String hwid = null;
		try {
			hwid = HWID.getHWID();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Packet packet = new Packet("get/rank/" + hwid, RequestType.INFINITY);

		String data = null;
		try {
			data = packet.Create();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		rank = Rank.valueOf(data);
		return;
	}
	
	public static Rank getRank() {
		return rank;
	}
}

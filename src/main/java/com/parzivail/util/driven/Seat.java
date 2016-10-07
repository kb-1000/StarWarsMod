package com.parzivail.util.driven;

import com.parzivail.util.lwjgl.Vector3f;

public class Seat
{
	/**
	 * The x, y and z positions of the seat within the plane in model co-ordinates
	 * x is forwards, y is up and z is left
	 */
	public int x, y, z;
	/**
	 * The id of this seat
	 */
	public int id;
	/**
	 * Limits for the look vector of the seat. Range is -360 to 360. Thus any range should lie in here without having to wrap
	 */
	public float minYaw = -360F, maxYaw = 360F;
	/**
	 * Limits for the look vector of the seat. Range is -90 to 90, but don't go beyond +/-89 or the view will mess up at the poles
	 */
	public float minPitch = -89F, maxPitch = 89F;
	/**
	 * The name of the gun model this seat is connected to. Gun model names are specified in the model files
	 */
	public String gunName;
	/**
	 * Auto assigned by drivable type. Indicates what ammo slot the gun should take from
	 */
	public int gunnerID;
	/**
	 * For turret mounted seats on tanks, the seat will be positioned differently according to this offset and the yaw of the turret
	 */
	public Vector3f rotatedOffset = new Vector3f();
	/**
	 * Where the bullets come from
	 */
	public Vector3f gunOrigin = new Vector3f();

	/**
	 * Type file constructor. Line from type file should be of one of the following forms
	 * Passenger ID x y z
	 * Passenger ID x y z minYaw maxYaw minPitch maxPitch
	 * Passenger ID x y z minYaw maxYaw minPitch maxPitch gunType.shortName gunName
	 */
	public Seat(String[] split)
	{
		id = Integer.parseInt(split[1]);
		x = Integer.parseInt(split[2]);
		y = Integer.parseInt(split[3]);
		z = Integer.parseInt(split[4]);
		gunOrigin = new Vector3f(x, y, z);
		if (split.length > 6)
		{
			minYaw = Float.parseFloat(split[6]);
			maxYaw = Float.parseFloat(split[7]);
			minPitch = Float.parseFloat(split[8]);
			maxPitch = Float.parseFloat(split[9]);
			if (split.length > 10)
			{
				gunName = split[11];
			}
		}
	}

	/**
	 * Type file driver seat constructor. Line from type file should be of one of the following forms
	 * Driver x y z
	 * Pilot x y z
	 */
	public Seat(int dx, int dy, int dz)
	{
		id = 0;
		x = dx;
		y = dy;
		z = dz;
	}

	/**
	 * Type file driver seat constructor with yaw and pitch limiters
	 */
	public Seat(int dx, int dy, int dz, float y1, float y2, float p1, float p2)
	{
		id = 0;
		x = dx;
		y = dy;
		z = dz;
		minYaw = y1;
		maxYaw = y2;
		minPitch = p1;
		maxPitch = p2;
	}
}
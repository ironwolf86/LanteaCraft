package pcl.common.util;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;

/**
 * Represents a Vector in three-dimensional space.
 * 
 * @author AfterLifeLochie
 */
public class Vector3 {

	/**
	 * The zero vector.
	 */
	public static final Vector3 zero = new Vector3(0, 0, 0);

	/**
	 * The unit vector in the x-axis.
	 */

	public static final Vector3 unitX = new Vector3(1, 0, 0);
	/**
	 * The unit vector in the y-axis.
	 */

	public static final Vector3 unitY = new Vector3(0, 1, 0);
	/**
	 * The unit vector in the y-axis.
	 */
	public static final Vector3 unitZ = new Vector3(0, 0, 1);

	/**
	 * The unit vector in the negative x-axis.
	 */
	public static final Vector3 unitNX = new Vector3(-1, 0, 0);

	/**
	 * The unit vector in the negative y-axis.
	 */
	public static final Vector3 unitNY = new Vector3(0, -1, 0);

	/**
	 * The unit vector in the negative z-axis.
	 */
	public static final Vector3 unitNZ = new Vector3(0, 0, -1);

	/**
	 * The unit vector in the x-axis and the y-axis.
	 */
	public static final Vector3 unitPXPY = new Vector3(0.707, 0.707, 0);

	/**
	 * The unit vector in the y-axis and the z-axis.
	 */
	public static final Vector3 unitPYPZ = new Vector3(0, 0.707, 0.707);

	/**
	 * The unit vector in the y-axis and the negative z-axis.
	 */
	public static final Vector3 unitPYNZ = new Vector3(0, 0.707, -0.707);

	/**
	 * The unit vector in the y-axis and the negative x-axis.
	 */
	public static final Vector3 unitPYNX = new Vector3(-0.707, 0.707, 0);

	/**
	 * The x-component of the vector.
	 */
	public double x;

	/**
	 * The y-component of the vector.
	 */
	public double y;

	/**
	 * The z-component of the vector.
	 */
	public double z;

	/**
	 * Creates a new vector.
	 * 
	 * @param x
	 *            The x-component of the vector.
	 * @param y
	 *            The y-component of the vector.
	 * @param z
	 *            The z-component of the vector.
	 */
	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Creates a new vector.
	 * 
	 * @param v
	 *            The Minecraft Vec3 object.
	 */
	public Vector3(Vec3 v) {
		this(v.xCoord, v.yCoord, v.zCoord);
	}

	/**
	 * Creates a new vector from an entity position.
	 * 
	 * @param entity
	 *            The entity.
	 */
	public Vector3(Entity entity) {
		this(entity.posX, entity.posY, entity.posZ);
	}

	/**
	 * Creates a new vector from a tile entity position.
	 * 
	 * @param tileentity
	 *            The tile entity.
	 */
	public Vector3(TileEntity tileentity) {
		this(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
	}

	/**
	 * Converts a Vector3 to a Minecraft Vec3 object.
	 * 
	 * @return A Minecraft Vec3 object.
	 */
	public Vec3 toVec3() {
		return Vec3.createVectorHelper(x, y, z);
	}

	@Override
	public String toString() {
		return "Vector3(" + x + "," + y + "," + z + ")";
	}

	/**
	 * Copy the Vector3.
	 * 
	 * @return A copy of this Vector3.
	 */
	public Vector3 copy() {
		return new Vector3(x, y, z);
	}

	/**
	 * Adds the specified components to this Vector3, returns a new Vector3
	 * product.
	 * 
	 * @param x
	 *            The x-component.
	 * @param y
	 *            The y-component.
	 * @param z
	 *            The z-component.
	 * @return The Vector3 product.
	 */
	public Vector3 add(double x, double y, double z) {
		return new Vector3(this.x + x, this.y + y, this.z + z);
	}

	/**
	 * Adds the specified Vector3 to this Vector3, returns a new Vector3
	 * product.
	 * 
	 * @param v
	 *            The foreign Vector3.
	 * @return The Vector3 product.
	 */
	public Vector3 add(Vector3 v) {
		return add(v.x, v.y, v.z);
	}

	/**
	 * Subtracts the specified components to this Vector3, returns a new Vector3
	 * product.
	 * 
	 * @param x
	 *            The x-component.
	 * @param y
	 *            The y-component.
	 * @param z
	 *            The z-component.
	 * @return The Vector3 product.
	 */
	public Vector3 sub(double x, double y, double z) {
		return new Vector3(this.x - x, this.y - y, this.z - z);
	}

	/**
	 * Subtracts the specified Vector3 to this Vector3, returns a new Vector3
	 * product.
	 * 
	 * @param v
	 *            The foreign Vector3.
	 * @return The Vector3 product.
	 */
	public Vector3 sub(Vector3 v) {
		return sub(v.x, v.y, v.z);
	}

	/**
	 * Multiplies the components of this Vector3 by the constant c, returns a
	 * new Vector3 multiplication product.
	 * 
	 * @param c
	 *            The constant.
	 * @return The Vector3 multiplication product.
	 */
	public Vector3 mul(double c) {
		return new Vector3(c * x, c * y, c * z);
	}

	/**
	 * Determine the dot-product of this Vector3 with respect to another
	 * Vector3.
	 * 
	 * @param v
	 *            The foreign Vector3 object.
	 * @return The dot product (this.x * that.x + y * that.y + this.z * that.z).
	 */
	public double dot(Vector3 v) {
		return x * v.x + y * v.y + z * v.z;
	}

	/**
	 * Determine the minimum vector components of this Vector3 and another
	 * Vector3, returns a new Vector3 minimum.
	 * 
	 * @param v
	 *            The foreign Vector3.
	 * @return The smallest Vector3 object.
	 */
	public Vector3 min(Vector3 v) {
		return new Vector3(Math.min(x, v.x), Math.min(y, v.y), Math.min(z, v.z));
	}

	/**
	 * Determine the maximum vector components of this Vector3 and another
	 * Vector3, returns a new Vector3 maximum.
	 * 
	 * @param v
	 *            The foreign Vector3.
	 * @return The largest Vector3 object.
	 */
	public Vector3 max(Vector3 v) {
		return new Vector3(Math.max(x, v.x), Math.max(y, v.y), Math.max(z, v.z));
	}

	/**
	 * Determine the distance between this Vector3 and another Vector3.
	 * 
	 * @param v
	 *            The foreign Vector3.
	 * @return The distance between this Vector3 and the foreign Vector3.
	 */
	public double distanceTo(Vector3 v) {
		double dx = x - v.x, dy = y - v.y, dz = z - v.z;
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}

	/**
	 * Determines the length of this Vector3.
	 * 
	 * @return The length of this Vector3.
	 */
	public double mag() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
	}

	/**
	 * Returns the unit vector for this vector.
	 * 
	 * @return The unit vector for this vector.
	 */
	public Vector3 unitV() {
		return new Vector3(x / mag(), y / mag(), z / mag());
	}

	/**
	 * Calculates the floored x-component of this Vector3.
	 * 
	 * @return The floored x-component of this Vector3.
	 */
	public int floorX() {
		return (int) Math.floor(x);
	}

	/**
	 * Calculates the floored y-component of this Vector3.
	 * 
	 * @return The floored y-component of this Vector3.
	 */
	public int floorY() {
		return (int) Math.floor(y);
	}

	/**
	 * Calculates the floored z-component of this Vector3.
	 * 
	 * @return The floored z-component of this Vector3.
	 */
	public int floorZ() {
		return (int) Math.floor(z);
	}

	/**
	 * Computes the angle pre normal.
	 * 
	 * @param mul
	 *            The other Vector3.
	 * @return The angle pre normal.
	 */
	public float anglePNorm(Vector3 mul) {
		return (float) Math.acos(dot(mul));
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Vector3))
			return false;
		Vector3 that = (Vector3) o;
		return (this.x == that.x && this.y == that.y && this.z == that.z);
	}
}
